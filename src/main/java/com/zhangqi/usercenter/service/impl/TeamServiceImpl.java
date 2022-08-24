package com.zhangqi.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zhangqi.usercenter.common.ErrorCode;
import com.zhangqi.usercenter.exception.BusinessException;
import com.zhangqi.usercenter.mapper.TeamMapper;
import com.zhangqi.usercenter.model.domain.Team;
import com.zhangqi.usercenter.model.domain.User;
import com.zhangqi.usercenter.model.domain.UserTeam;
import com.zhangqi.usercenter.model.enums.TeamStatusEnum;
import com.zhangqi.usercenter.service.TeamService;
import com.zhangqi.usercenter.service.UserTeamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

/**
 * @author zhangqi
 * @description 针对表【team(队伍)】的数据库操作Service实现
 * @createDate 2022-08-23 15:39:14
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
        implements TeamService {

    @Resource
    private UserTeamService userTeamService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public long addTeam(@RequestBody Team team, User loginUser) {
        // 1. 请求参数是否为空？
        if (team == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //2. 是否登录，未登录不允许创建
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }

        final long userId = loginUser.getId();

        //3. 校验信息
        //1. 队伍人数 > 1 且 <= 20
        int maxNum = Optional.ofNullable(team.getMaxNum()).orElse(0); // 如果为空设置为0
        if (maxNum < 1 || maxNum > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍人数不符合要求");
        }
        //2. 队伍标题 <= 20
        String name = team.getName();
        if (StringUtils.isBlank(name) || name.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍标题不符合要求");
        }

        //3. 描述 <= 512
        String description = team.getDescription();
        if (StringUtils.isNotBlank(description) && description.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍描述过长");
        }
        //4. status 是否公开（int）不传默认为 0（公开）
        int teamStatus = Optional.ofNullable(team.getStatus()).orElse(0);
        TeamStatusEnum statusEnum = TeamStatusEnum.getEnumByValue(teamStatus);
        if (statusEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //5. 如果 status 是加密状态，一定要有密码，且密码 <= 32
        String password = team.getPassword();
        if (TeamStatusEnum.SECRET.equals(statusEnum)) {
            if ((StringUtils.isBlank(password) || password.length() > 32)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        //6. 超时时间 > 当前时间
        Date expireTime = team.getExpireTime();
        if (new Date().after(expireTime)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //7. 校验用户最多创建 5 个队伍
        // TODO: 2022/8/24 可能同时创建出100个队伍
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        long count = this.count(queryWrapper);

        if (count >= 5) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //4. 插入队伍信息到队伍表
        team.setId(null);
        team.setUserId(userId);
        boolean result = this.save(team);
        Long teamId = team.getId();
        if (!result || teamId == null) {

            throw new BusinessException(ErrorCode.PARAMS_ERROR, "创建任务失败");
        }


        //5. 插入用户 =>队伍关系到关系表
        UserTeam userTeam = new UserTeam();
        userTeam.setUserId(userId);
        userTeam.setTeamId(teamId);
        userTeam.setJoinTime(new Date());
        result = userTeamService.save(userTeam);
        if (!result) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "创建任务失败");
        }


        return teamId;
    }
}





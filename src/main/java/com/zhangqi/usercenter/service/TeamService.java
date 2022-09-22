package com.zhangqi.usercenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangqi.usercenter.model.domain.Team;
import com.zhangqi.usercenter.model.domain.User;
import com.zhangqi.usercenter.model.dto.TeamQuery;
import com.zhangqi.usercenter.model.request.TeamJoinRequest;
import com.zhangqi.usercenter.model.request.TeamQuitRequest;
import com.zhangqi.usercenter.model.request.TeamUpdateRequest;
import com.zhangqi.usercenter.model.vo.TeamUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author zhangqi
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2022-08-23 15:39:14
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍信息
     * @param teamUpdateRequest
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}

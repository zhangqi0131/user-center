package com.zhangqi.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zhangqi.usercenter.mapper.UserTeamMapper;
import com.zhangqi.usercenter.model.domain.UserTeam;
import com.zhangqi.usercenter.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author zhangqi
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2022-08-23 15:40:28
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}





package com.zhangqi.usercenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangqi.usercenter.model.domain.Team;
import com.zhangqi.usercenter.model.domain.User;
import com.zhangqi.usercenter.model.dto.TeamQuery;

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

}

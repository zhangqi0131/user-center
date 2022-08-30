package com.zhangqi.usercenter.service;

import com.zhangqi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangqi.usercenter.model.request.TeamJoinRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.zhangqi.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.zhangqi.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author zhangqi
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-03-14 16:48:22
*/
public interface UserService extends IService<User> {


    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销登录
     * @param request
     */
    int userLogout(HttpServletRequest request);


    /**
     * 根据标签搜索用户
     * @param tagNameList
     * @return
     */
    List<User> searchUserByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     * @return
     */
    User getLoginUser(HttpServletRequest request);


    /**
     * 是否为管理员
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param loginUser
     * @return
     */
    boolean isAdmin(User loginUser);


}


package com.like.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.like.pojo.Users;
import com.like.pojo.bo.UserBo;
import com.like.pojo.bo.center.UserCenterBo;
import org.apache.ibatis.annotations.Param;

/**
 * @author like
 * @email 980650920@qq.com
 * @since 2021-02-06 17:24
 */
public interface UsersService extends IService<Users> {


    /**
     * 查询用户信息
     *
     * @param userId 用户id
     * @return {@link Users}
     */
    Users queryUserInfo(String userId);

    /**
     * 更新用户信息
     *
     * @param userId 用户id
     * @param user   用户
     * @return {@link Users}
     */
    Users updateUseUserCenterBO(String userId, UserCenterBo user);

    /**
     * 更新用户的头像
     *
     * @param userId 用户id
     * @param url    url
     * @return
     */
    Users updateUserFace(String userId, String url);

    /**
     * 查询用户名存在
     *
     * @param username 用户名
     * @return boolean
     */
    public boolean queryUserNameIsExist(@Param("username") String username);

    /**
     * 创建用户
     *
     * @param user 用户
     * @return {@link Users}
     */
    public Users createUser(UserBo user);

    /**
     * 查询用户名和密码是否匹配
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link Users}
     */
    public Users queryUserForLogin(String username, String password);
}

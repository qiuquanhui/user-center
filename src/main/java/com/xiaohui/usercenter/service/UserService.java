package com.xiaohui.usercenter.service;

import com.xiaohui.usercenter.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohui.usercenter.domain.vo.UserVo;

/**
* @author Hui
* @description 针对表【user】的数据库操作Service
* @createDate 2024-02-22 15:54:12
*/
public interface UserService extends IService<User> {
    //注册
    long register(UserVo userVo);
    //登录
    User login(UserVo userVo);
}

package com.xiaohui.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohui.usercenter.domain.User;
import com.xiaohui.usercenter.service.UserService;
import com.xiaohui.usercenter.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Hui
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-22 15:54:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





package com.xiaohui.usercenter.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohui.usercenter.common.ResponseCode;
import com.xiaohui.usercenter.domain.User;
import com.xiaohui.usercenter.domain.vo.UserVo;
import com.xiaohui.usercenter.exception.BusinessException;
import com.xiaohui.usercenter.mapper.UserMapper;
import com.xiaohui.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Hui
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-22 15:54:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private  UserMapper userMapper;

    @Override
    public long register(UserVo userVo) {

        String userName = userVo.getUserName();
        String password = userVo.getPassword();
        String userAccount = userVo.getUserAccount();

        //1.校验
        if(StringUtils.isAnyBlank(userName, userAccount, password)){
            throw new BusinessException(ResponseCode.PARAMETER_ERROR);
        }

        //1.1判断账户是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        Long count = userMapper.selectCount(queryWrapper);
        if (count > 0){
            throw new BusinessException(503,"账号重复");
        }

        //2.加密 hutool
        // 5393554e94bf0eb6436f240a4fd71282
        String md5Password = DigestUtil.md5Hex(password);
        //3.新增
        userVo.setPassword(md5Password);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(md5Password);
        user.setUserAccount(userAccount);
        //设置默认值
        user.setStatus(0);
        user.setUserRole(0);

        int result = userMapper.insert(user);


        return result;
    }

    @Override
    public User login(UserVo userVo) {
        //1.校验
        String userAccount = userVo.getUserAccount();
        String password = userVo.getPassword();
        if(StringUtils.isAnyBlank(userAccount, password)){
            throw new BusinessException(4001,"账号密码不可为空");
        }
        //2.查询数据库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new BusinessException(4001,"账号不存在");
        }
        //3.对比
        String userPassword = DigestUtil.md5Hex(password);
        if(!user.getPassword().equals(userPassword)){
            throw new BusinessException(4001,"密码错误");
        }
        User safetyUser = getSafetyUser(user);
        //4.返回
        return safetyUser;
    }

    private User getSafetyUser(User originalUser) {
        User safetyUser = new User();

        safetyUser.setUserName(originalUser.getUserName());
        safetyUser.setUserRole(originalUser.getUserRole());
        safetyUser.setStatus(originalUser.getStatus());

        return safetyUser;
    }
}





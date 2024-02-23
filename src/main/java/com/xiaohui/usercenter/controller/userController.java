package com.xiaohui.usercenter.controller;/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */

import com.xiaohui.usercenter.common.BaseResponse;
import com.xiaohui.usercenter.common.ResponseCode;
import com.xiaohui.usercenter.common.Result;
import com.xiaohui.usercenter.domain.User;
import com.xiaohui.usercenter.domain.vo.UserVo;
import com.xiaohui.usercenter.exception.BusinessException;
import com.xiaohui.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author: Hui
 **/
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    //测试项目是否启动
    @GetMapping("test")
    public String test(){

        if (1 == 1){
            throw new BusinessException(ResponseCode.INTERNAL_SERVER_ERROR);
        }
        int test = 1/0;

        return "test";
    }

    //测试项目与数据库之间的连接
    @PostMapping("/test/add")
    public BaseResponse add(@RequestBody User user){

        userService.save(user);

        return Result.success("测试新增成功");
    }

    /**
     *  注册
     *
     *  @Param  user
     *  @return BaseResponse
    */
    @PostMapping("/register")
    public BaseResponse register(@RequestBody UserVo userVo){
        //1.校验
        if (userVo == null){
            throw new BusinessException(ResponseCode.NULL_PARAMETER);
        }

        long result = userService.register(userVo);

        if (result > 0){
             return Result.success("注册成功");
        }

        return Result.error("注册失败");

    }

}

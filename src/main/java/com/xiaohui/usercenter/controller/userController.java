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

import java.util.ArrayList;
import java.util.List;

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
    public BaseResponse testAdd(@RequestBody User user){

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

    /**
     *  登录
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @PostMapping("/login")
    public BaseResponse login(@RequestBody UserVo userVo){
        //1.校验
        if (userVo == null){
            throw new BusinessException(ResponseCode.PARAMETER_ERROR);
        }

        User safetyUser = userService.login(userVo);

        if (safetyUser != null){
            return Result.success("登录成功", safetyUser);
        }

        return Result.error("登录失败");

    }


    /**
     *  新增
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @PostMapping("/add")
    public BaseResponse add(@RequestBody User user){
        //1.校验
        if (user == null){
            throw new BusinessException(ResponseCode.PARAMETER_ERROR);
        }
        boolean result = userService.save(user);
        if (result){
            return Result.success("新增成功");
        }
        return Result.error("新增失败");
    }

    /**
     *  删除
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @DeleteMapping("/delete")
    public BaseResponse delete(Long userId){
        //1.校验
        if (userId == null || userId == 0){
            throw new BusinessException(ResponseCode.PARAMETER_ERROR);
        }
        boolean result = userService.removeById(userId);
        if (result){
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
     *  修改
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @PutMapping("/update")
    public BaseResponse update(@RequestBody User user){
        //1.校验
        if (user == null){
            throw new BusinessException(ResponseCode.PARAMETER_ERROR);
        }
        boolean result = userService.updateById(user);
        if (result){
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    /**
     *  查询
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @GetMapping("/list")
    public BaseResponse list(){

        List<User> userList = userService.list();
        //脱敏
        ArrayList<User> users = new ArrayList<>();
        for (User user : userList){
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setUserName(user.getUserName());
            newUser.setStatus(user.getStatus());
            newUser.setUpdateTime(user.getUpdateTime());
            newUser.setCreateTime(user.getCreateTime());
            users.add(newUser);
        }

        return Result.success(users);
    }

    /**
     *  分页查询
     *
     *  @Param  user
     *  @return BaseResponse
     */
    @GetMapping("/page")
    public BaseResponse page(){

        List<User> userList = userService.list();
        //脱敏
        ArrayList<User> users = new ArrayList<>();
        for (User user : userList){
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setUserName(user.getUserName());
            newUser.setStatus(user.getStatus());
            newUser.setUpdateTime(user.getUpdateTime());
            newUser.setCreateTime(user.getCreateTime());
            users.add(newUser);
        }

        return Result.success(users);
    }


}

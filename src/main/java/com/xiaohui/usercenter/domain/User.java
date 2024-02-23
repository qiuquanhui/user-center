package com.xiaohui.usercenter.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像 
     */
    private String avatarUrl;

    /**
     * 描述
     */
    private String description;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户角色
0-普通用户
1-管理员
     */
    private Integer userRole;

    /**
     * 用户状态
0-正常
     */
    private Integer status;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    // 注意！这里需要标记为填充字段
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    // 注意！这里需要标记为填充字段
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime  updateTime;

    /**
     * 是否删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
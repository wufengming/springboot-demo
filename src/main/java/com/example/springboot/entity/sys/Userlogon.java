package com.example.springboot.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户登录信息表
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_userlogon")
public class Userlogon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户登录主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long userid;
    /**
     * 用户账号
     */
    private String useraccount;
    /**
     * 用户密码
     */
    private String userpassword;

    /**
     * 用户秘钥
     */
    private String usersecretkey;

    /**
     * 允许登录时间开始
     */
    private Date allowstarttime;

    /**
     * 允许登录时间结束
     */
    private Date allowendtime;

    /**
     * 暂停用户开始日期
     */
    private Date lockstartdate;

    /**
     * 暂停用户结束日期
     */
    private Date lockenddate;

    /**
     * 第一次访问时间
     */
    private Date firstvisittime;

    /**
     * 上一次访问时间
     */
    private Date previousvisittime;

    /**
     * 最后访问时间
     */
    private Date lastvisittime;

    /**
     * 最后修改密码日期
     */
    private Date changepassworddate;

    /**
     * 允许同时有多用户登录
     */
    private Boolean multiuserlogin;

    /**
     * 登录次数
     */
    private Integer logoncount;

    /**
     * 在线状态
     */
    private Boolean useronline;

    /**
     * 密码提示问题
     */
    private String question;

    /**
     * 密码提示答案
     */
    private String answerquestion;

    /**
     * 是否访问限制
     */
    private Boolean checkipaddress;

    /**
     * 系统语言
     */
    private String language;

    /**
     * 系统样式
     */
    private String theme;

    /**
     * 创建用户
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date creatortime;

    /**
     * 最后修改用户
     */
    private Long modifyuserid;

    /**
     * 最后修改时间
     */
    private Date modifytime;

    /**
     * 当前组织id
     */
    private Long curorgid;


}

package com.example.springboot.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 账户
     */
    private String account;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 呢称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String headicon;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 手机
     */
    private String mobilephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 安全级别
     */
    private Integer securitylevel;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 默认组织主键
     */
    private Long organizeid;

    /**
     * 默认部门主键
     */
    private Long departmentid;

    /**
     * 岗位主键
     */
    private Long dutyid;

    /**
     * 是否管理员
     */
    private Integer isadministrator;

    /**
     * 排序码
     */
    private Integer sortcode;

    /**
     * 删除标志
     */
    private Integer deletemark;

    /**
     * 有效标志
     */
    private Integer enabledmark;

    /**
     * 描述
     */
    private String description;

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

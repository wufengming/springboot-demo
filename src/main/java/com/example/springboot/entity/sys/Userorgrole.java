package com.example.springboot.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户组织角色关系表
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_userorgrole")
public class Userorgrole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userid;

    private String useraccount;

    private Long orgid;

    private String orgcode;

    private Long roleid;

    private String rolecode;

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

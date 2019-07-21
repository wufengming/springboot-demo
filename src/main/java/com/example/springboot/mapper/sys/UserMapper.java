package com.example.springboot.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.sys.User;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findUsers();
}

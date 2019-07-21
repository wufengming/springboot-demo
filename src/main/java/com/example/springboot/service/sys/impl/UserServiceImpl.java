package com.example.springboot.service.sys.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.sys.User;
import com.example.springboot.mapper.sys.UserMapper;
import com.example.springboot.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    @DS("master")
    public List<User> selectAll() {
        return  userMapper.selectList(null);
    }

    @DS("slave_1")
    public List<User> selectByCondition() {
        return  userMapper.selectList(null);
    }

    @Transactional(readOnly = true)
    @DS("master")
    public List<User> findAll() {
        //return jdbcTemplate.query("select * from sys_user", new UserRowMapper());
        return null;
    }

    @Transactional(readOnly = true)
    @DS("slave_1")
    public User findUserById(long id) {
        //return jdbcTemplate.queryForObject("select * from sys_user where id=?", new Object[]{id}, new UserRowMapper());
        return null;
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", username);
        List<User> list = userMapper.selectList(queryWrapper);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}

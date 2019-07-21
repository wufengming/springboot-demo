package com.example.springboot.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.sys.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
public interface UserService extends IService<User> {
    List<User> selectAll();
    List<User> selectByCondition();
    List<User> findAll();
    User findUserById(long id);
    /**
     * 功能描述:通过用户名获取用户
     * @Param: [username]
     * @Author: wfm
     * @Date: 2019/7/12 10:42
     */
    @Cacheable(value="users", key="#username")
    User findByUsername(String username);
}

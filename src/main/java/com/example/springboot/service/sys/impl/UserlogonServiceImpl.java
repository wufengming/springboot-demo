package com.example.springboot.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.sys.Userlogon;
import com.example.springboot.mapper.sys.UserlogonMapper;
import com.example.springboot.service.sys.UserlogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户登录信息表 服务实现类
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@Service
public class UserlogonServiceImpl extends ServiceImpl<UserlogonMapper, Userlogon> implements UserlogonService {
    @Autowired
    private UserlogonMapper userloginMapper;
    @Override
    public Userlogon findByUsername(String username) {
        QueryWrapper<Userlogon> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("useraccount", username);
        List<Userlogon> loginlist = userloginMapper.selectList(queryWrapper);
        if (loginlist != null && loginlist.size() > 0) {
            return loginlist.get(0);
        } else {
            return null;
        }
    }
}

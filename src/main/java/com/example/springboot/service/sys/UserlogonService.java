package com.example.springboot.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.sys.Userlogon;

/**
 * <p>
 * 用户登录信息表 服务类
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
public interface UserlogonService extends IService<Userlogon> {
    /**
     * 功能描述:通过用户名获取用户
     * @Param: [username]
     * @Author: wfm
     * @Date: 2019/7/12 10:42
     */
    Userlogon findByUsername(String username);
}

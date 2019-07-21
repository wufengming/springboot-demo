package com.example.springboot.controller.sys;

import com.example.springboot.common.constant.SecurityConstant;
import com.example.springboot.common.utils.JwtTokenUtil;
import com.example.springboot.model.sys.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wfm
 * @title: LoginController
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1518:10
 */
@RestController
public class LoginController {
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUser sysUser, HttpServletRequest request) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUsername());
        final String token = SecurityConstant.TOKEN_SPLIT + jwtTokenUtil.generateToken(userDetails);
        return token;
    }

//    @PostMapping("haha")
//    public String haha(){
//        UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return "haha:"+userDetails.getUsername()+","+userDetails.getPassword();
//    }
}

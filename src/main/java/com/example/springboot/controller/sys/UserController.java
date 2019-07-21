package com.example.springboot.controller.sys;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wfm
 * @since 2019-06-27
 */
@RestController
@RequestMapping("/user")
@Api("用户API")
public class UserController {
    @GetMapping(value = "/list")
    public String getUsers() {
        return "Hello Spring Security";
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/userbyid/{id}", method = RequestMethod.GET)
    public String getUserById (@PathVariable Integer id){
        return id.toString();
    }
}

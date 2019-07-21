package com.example.springboot.mapper.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.sys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wfm
 * @title: UserMapperTest
 * @projectName springboot3
 * @description: TODO
 * @date 2019/6/2715:07
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * <p>
     *     insert 插入测试
     * </p>
     */
    @Test
    public void insertLoads() {
        User user = new User();
        user.setAccount("0001");
        user.setEmail("lqf@163.com");
        user.setBirthday(new Date());
        user.setRealname("test2");
        user.setCreatortime(new Date());
        user.setMobilephone("13111110000");
        user.setNickname("guangqing");

        Integer insert = userMapper.insert(user);
        System.out.println("return insert value = " + insert);
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     *<P>
     *     通过id更新信息
     *</P>
     */
    @Test
    public void updateByIdLoads() {
        User user = new User();
        user.setAccount("0001");
        user.setEmail("wfm@163.com");
        user.setId(1144584787399323649L);

        Integer insert = userMapper.updateById(user);
        System.out.println("return insert value = " + insert);
    }

    /**
     * <P>
     *     deleteBatchIds 根据id批量删除
     * </P>
     */
    @Test
    public void deleteLoads() {
        List<Long> list = new ArrayList<>();
        list.add(1087982257332887553L);
        list.add(1144584787399323649L);

        Integer insert = userMapper.deleteBatchIds(list);
        System.out.println("return deleteBatchIds value = " + insert);
    }

    /**
     * <p>
     * deleteByMap 根据map条件进行删除
     * </P>
     */
    @Test
    public void deleteByMapsLoads() {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("email", "lqf@163.com");
        map.put("age", 12);

        Integer insert = userMapper.deleteByMap(map);
        System.out.println("return deleteByMap value = " + insert);
    }
    /**
     * <p>
     * 通过id查询对象
     * </P>
     */
    @Test
    public void selectByIdLoads() {
        User user = userMapper.selectById(4L);
        System.out.println("return insert value = " + user);
    }

    /**
     * <p>
     * 通过多个id进行查询
     * </P>
     */
    @Test
    public void selectBatchIdsLoads() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        List<User> list1 = userMapper.selectBatchIds(list);
        System.out.println("return selectBatchIds value = " + list1);
    }
    /**
     * <p>
     * 分页查询
     * </P>
     */
    @Test
    public void selectPageLoads() {
        Page<User> page = new Page<>(1,5);
        IPage<User> lstUser = userMapper.selectPage(page, null);
        System.out.println("return selectPageLoads value = " + lstUser);
    }

    @Test
    public void findUsers() {
        List<User> userList = userMapper.findUsers();

        userList.forEach(System.out::println);
    }

}
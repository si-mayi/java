package cn.itcast.controller;


import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    private UserDao ud;

    @Autowired
    private RedisTemplate<String,String> rt;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) throws Exception {
        //先从Redis中去
        String json = rt.opsForValue().get("user:" + id);
        User user = null;
        if (StringUtils.isEmpty(json)){
            //找不到-->从数据库中找,放入redis
            Optional<User> option = ud.findById(id);
            user = option.get();
            //将user转换为json,放入redis
            rt.opsForValue().set("user:" + id,objectMapper.writeValueAsString(user ));
        }else
        {
            //找到了-->将json转换为对象
            user = objectMapper.readValue(json, User.class);
        }
        return user;
    }



   /* @RequestMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        Optional<User> option = ud.findById(id);
        User user = option.get();
        return user;
    }*/



    @RequestMapping("/user/list")
    public String findAll(Model model) {
        List<User> list = ud.findAll();
        model.addAttribute("list",list);
        return "user";
    }

}

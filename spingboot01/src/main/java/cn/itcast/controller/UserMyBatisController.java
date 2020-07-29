package cn.itcast.controller;


import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
public class UserMyBatisController {

    @Autowired
    private UserMapper um;

    @RequestMapping("/user2/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        return um.findById(id);
    }



    @RequestMapping("/user2/list")
    public String findAll(Model model) {
        List<User> list = um.findAll();
        model.addAttribute("list",list);
        return "user";
    }

}

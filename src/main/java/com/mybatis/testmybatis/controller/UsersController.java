package com.mybatis.testmybatis.controller;

import com.mybatis.testmybatis.domain.Users;
import com.mybatis.testmybatis.dto.UsersDTO;
import com.mybatis.testmybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    //UsersService를 다 가져와서 쓸 수 있다.(자동으로 주입 시켜줌)(new, 상속 등을 안써도 됨)
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UsersDTO> userlist =  usersService.getUsersList();

        model.addAttribute("list",userlist);
        return "user";

    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address ,Model model){
        Users user = new Users();
        user.setName(name);
        user.setAddress(address);
        usersService.addUser(user);
        model.addAttribute("list",null);
        return "user";
    }


}
/**
 * @Autowired
 * 이 어노테이션을 사용하면 Spring 컨테이너가 자동으로 해당 타입의 Bean을 필드나 메서드에 주입
 * 1. 핃드 주입: Spring이 자동으로 필드에 주입
 * 장점: 코드가 간결해진다. 단점: 의존성을 변경시키거나 테스트에 어려움이 생길 수 있다.
 *
 * 2. 생성자 주입: Spring이 생성자의 파라미터 타입에 맞는 빈을 찾아 주입
 * - 불변성을 보장(객체의 상태가 생성된 후 변경되지 않음)
 *
 * @Autowired vs new
 * 공통점: 객체를 생성하고 참조하는데 사용
 * 차이점:
 * - @Autowired: Spring의 IoC 컨테이너를 통해 의존성 주입
 * - new: 개발자가 명시적으로 객체를 생성
 *
 *
 *
 */

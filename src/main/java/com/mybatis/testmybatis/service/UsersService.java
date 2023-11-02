package com.mybatis.testmybatis.service;

import com.mybatis.testmybatis.domain.Users;
import com.mybatis.testmybatis.dto.UsersDTO;
import com.mybatis.testmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserMapper userMapper;

    public List<UsersDTO> getUsersList(){
        //실제 데이터베이스에서 가져오는 Users 배열
        List<Users> result = userMapper.findAll();

        //위애 받은 Users 배열을 UsersDTO 배열로 반환하기
        List<UsersDTO> users = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            UsersDTO user = new UsersDTO();

            //DB에서 get으로 가져오고 set으로 user에 넣어준다.
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());

            users.add(user);

        }
        return users;

    }

    //사용자 추가하기
    public void addUser(Users user) {
        userMapper.insertUser(user);
    }

}

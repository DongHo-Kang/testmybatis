package com.mybatis.testmybatis.mapper;

import com.mybatis.testmybatis.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //xml 참고하여 사용
    List<Users> findAll();

    //xml 참고 안하기
    //insertUser에 user가 들어오면 @Insert가 실행된다.
    @Insert("INSERT INTO users (name, address) VALUES(#{name}, #{address})")
    void insertUser(Users user);

}


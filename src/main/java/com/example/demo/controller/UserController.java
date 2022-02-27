package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserMapper mapper;

    public UserController(UserMapper mapper) {
        this.mapper = mapper;
    }

    // 모든 유저 출력
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return mapper.getUsers();
    }

    // 유저 생성
    @PostMapping("/users")
    public int createUser(@RequestBody UserDto userDto) {
        return mapper.createUser(userDto.getFirstName(), userDto.getLastName(), userDto.getAge());
    }

    // 유저 출력
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return mapper.getUser(id);
    }

    // 유저 업데이트
    @PutMapping("/users/{id}")
    public int updateUser(@PathVariable("id") int id, @RequestBody UserDto userDto) {
        return mapper.updateUser(id, userDto.getFirstName(), userDto.getLastName(), userDto.getAge());
    }

    // 유저 삭제
    @DeleteMapping("/users/{id}")
    public int deleteUser(@PathVariable("id") int id) {
        return mapper.deleteUser(id);
    }
}
package com.ymmihw.java8.web;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @GetMapping("/user/{id}")
  @ApiOperation(value = "获取用户", notes = "获取用户")
  public UserVO user(Long id) {
    UserVO u = new UserVO();
    u.setBirthday(LocalDateTime.now());
    return u;
  }

  @PostMapping("/user")
  @ApiOperation(value = "添加用户", notes = "添加用户")
  public void user(@RequestBody UserVO vo) {
    System.out.println(vo);
  }
}

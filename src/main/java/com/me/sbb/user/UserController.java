package com.me.sbb.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/ui/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/signup")
  public String signup(UserForm userForm){
    return "ui/user/signup_form";
  }

  @PostMapping("/signup")
  public String signup(@Valid UserForm userForm, BindingResult bindingResult){
    if (bindingResult.hasErrors()) {
      return "ui/user/signup_form";
    }
    if(!userForm.getPassword().equals(userForm.getPasswordCheck())){
      bindingResult.rejectValue("passwordCheck", "passwordInCorrect",
              "2개의 패스워드가 일치하지 않습니다.");
      return "ui/user/signup_form";
    }
    try {
      this.userService.createUser(userForm.getUsername(), userForm.getEmail(),
              userForm.getPassword(), LocalDateTime.now());
    } catch (DataIntegrityViolationException e) {
      e.printStackTrace();
      bindingResult.reject("singupFailed", "이미 등록된 사용자입니다.");
      return "ui/user/signup_form";
    } catch (Exception e) {
      e.printStackTrace();
      bindingResult.reject("singupFailed", e.getMessage());
      return "ui/user/signup_form";
    }
    return "redirect:/ui/question/question_list";
  }

  @GetMapping("/login")
  public String login() {
    return "ui/user/login_form";
  }

//  @GetMapping("/loginCheck")
//  public String userLogin(@RequestParam(value = "username") String username,
//                          @RequestParam(value = "password") String password) {
//    if(!this.userService.checkLogin(username, password).isPresent()){
//      return "sbb-UI/user/login_form";
//    }
//
//    return "redirect:/sbb-UI/question/question_list";
//  }

}

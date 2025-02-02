package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

  @GetMapping("/")
  public String root() {
    return "index";
//    return "redirect:board";
  }

//  @GetMapping("/board")
//  public String index() {
//    return "/board/sbb-index";
//  }
//  @GetMapping("/sbb-UI/login")
//  public String login(){
//    return "/sbb-UI/login";
//  }
}

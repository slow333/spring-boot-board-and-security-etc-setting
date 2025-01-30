package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring/03-JSP")
public class SpringJSPController {

  String baseUrl = "spring/03-JSP/";

  @GetMapping("/01-settings")
  public String setJSP() {
    return baseUrl + "01-settings";
  }

  @GetMapping("/02-start-jsp")
  public String startJSP() {
    return baseUrl + "02-start-jsp";
  }

  @GetMapping("/03-method-scriptlit")
  public String jpaDb() {
    return baseUrl + "03-method-scriptlit";
  }
}
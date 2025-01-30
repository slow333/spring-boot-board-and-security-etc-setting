package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring/00-setting")
public class SpringSettingController {

  String baseUrl = "spring/00-setting/";

  @GetMapping("/01-about-spring-boot")
  public String aboutSb() {
    return baseUrl+"01-about-spring-boot";
  }

  @GetMapping("/02-sts-setting")
  public String stsSetting() {
    return baseUrl+"02-sts-setting";
  }

  @GetMapping("/03-cors-setting")
  public String coresSetting() {
    return baseUrl+"03-cors-setting";
  }

  @GetMapping("/04-intellij-setting")
  public String intellijSetting() {
    return baseUrl+"04-intellij-setting";
  }

}

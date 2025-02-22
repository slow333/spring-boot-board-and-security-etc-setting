package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restapi")
public class RestApiController {

  @GetMapping("/01-basics/00-rest-spring-27-setting")
  public String restApiBasicsSetting() {
    return "restapi/01-basics/00-rest-spring-27-setting";
  }

  @GetMapping("/01-basics/01-project-basic")
  public String restApiBasicsProjectBasic() {
    return "restapi/01-basics/01-project-basic";
  }
}

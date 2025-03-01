package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restapi")
public class RestApiController {

  //########## 1번째 장: RESTfull web service #################
  @GetMapping("/01-restfull-web/01-rest-web-basic")
  public String restWebBasic() {
    return "restapi/01-restfull-web/01-rest-web-basic";
  }

  
  
}

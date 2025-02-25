package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restapi")
public class RestApiController {

  // 01 rest api 기본
  @GetMapping("/01-basics/00-rest-spring-27-setting")
  public String restApiBasicsSetting() {
    return "restapi/01-basics/00-rest-spring-27-setting";
  }

  @GetMapping("/01-basics/01-project-basic")
  public String restApiBasicsProjectBasic() {
    return "restapi/01-basics/01-project-basic";
  }

  @GetMapping("/01-basics/02-get-api")
  public String restApiBasicsGetApi() {
    return "restapi/01-basics/02-get-api";
  }

  @GetMapping("/01-basics/03-post-api")
  public String restApiBasicsPostApi() {
    return "restapi/01-basics/03-post-api";
  }

  @GetMapping("/01-basics/04-put-delete-api")
  public String restApiBasicsPutDeleteApi() {
    return "restapi/01-basics/04-put-delete-api";
  }

  @GetMapping("/01-basics/05-jpa-entity-dao-dto")
  public String restApiBasicsJpaEntity() {
    return "restapi/01-basics/05-jpa-entity-dao-dto";
  }
  @GetMapping("/02-more/01-logback")
  public String restApiBasicsLogback() {
    return "restapi/02-more/01-logback";
  }

  // 02- more 내용
  @GetMapping("/02-more/02-validation")
  public String restApiMoreValid() {
    return "restapi/02-more/02-validation";
  }

  @GetMapping("/02-more/03-rest-error-handler")
  public String restApiMoreErrorHandler() {
    return "restapi/02-more/03-rest-error-handler";
  }
  
  
}

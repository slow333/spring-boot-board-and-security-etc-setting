package com.me.sbb.urlcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdvancedController {

  @GetMapping("/sbb-UI/advanced/nav_bar")
  public String advNavBar() {
    return "/sbb-UI/advanced/nav_bar";
  }

  @GetMapping("/sbb-UI/advanced/user_subscribe")
  public String userSubscribe() {
    return "sbb-UI/advanced/user_subscribe";
  }
}

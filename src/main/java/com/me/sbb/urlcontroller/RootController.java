package com.me.sbb.urlcontroller;

import com.me.sbb.data.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class RootController {

  @GetMapping("/")
  public String root() {
    return "index";
  }

  @GetMapping("/ui/advanced/nav_bar")
  public String advNavBar() {
    return "ui/advanced/nav_bar";
  }

}

package com.me.sbb.urlcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  @GetMapping("/01-basic-page/sbb-index")
  public String sbbIndex() {
    return "board/sbb-index";
  }

  //########## 1번째 장 #################
  @GetMapping("/01-basic-page/01-question-list")
  public String questionListNote() {
    return "board/01-basic-page/01-question-list";
  }

  @GetMapping("/01-basic-page/02-service-intro")
  public String serviceIntro() {
    return "board/01-basic-page/02-service-intro";
  }

  @GetMapping("/01-basic-page/03-question-detail")
  public String questionDetail() {
    return "board/01-basic-page/03-question-detail";
  }

  @GetMapping("/01-basic-page/04-thymeleaf-style")
  public String thymeleafStyle() {
    return "board/01-basic-page/04-thymeleaf-style";
  }

  @GetMapping("/01-basic-page/05-question-create")
  public String questionCreate() {
    return "board/01-basic-page/05-question-create";
  }

  @GetMapping("/01-basic-page/06-validation")
  public String questionValidate() {
    return "board/01-basic-page/06-validation";
  }

//########## 2번째 장 #################
  @GetMapping("/02-advanced/01-nav-bar")
  public String navBar() {
    return "board/02-advanced/01-nav-bar";
  }





  //########## 3번째 장 #################
  @GetMapping("/03-etc/01-start")
  public String startEtc() {
    return "board/03-etc/01-start";
  }

}

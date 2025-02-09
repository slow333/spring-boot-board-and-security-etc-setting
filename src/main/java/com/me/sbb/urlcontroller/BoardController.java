package com.me.sbb.urlcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class BoardController {

  @GetMapping("/00-setting/sbb-index")
  public String sbbIndex() {
    return "spring/sbb-index";
  }

  //########## 0번째 장 : spring boot settings #################
  @GetMapping("/00-setting/01-about-spring-boot")
  public String aboutSb() {
    return "spring/00-setting/01-about-spring-boot";
  }

  @GetMapping("/00-setting/02-sts-setting")
  public String stsSetting() {
    return "spring/00-setting/02-sts-setting";
  }

  @GetMapping("/00-setting/03-cors-setting")
  public String coresSetting() {
    return "spring/00-setting/03-cors-setting";
  }

  @GetMapping("/00-setting/04-intellij-setting")
  public String intellijSetting() {
    return "spring/00-setting/04-intellij-setting";
  }

  //########## 1번째 장: basic project setting #################
  @GetMapping("/01-basics/00-project-architecture")
  public String projectArchitecture() {
    return "spring/01-basics/00-project-architecture";
  }

  @GetMapping("/01-basics/01-Controller")
  public String controllerSetting() {
    return "spring/01-basics/01-Controller";
  }
  @GetMapping("/01-basics/02-JPA-db")
  public String jpaDb() {
    return "spring/01-basics/02-JPA-db";
  }
  @GetMapping("/01-basics/03-entity-db-mapping")
  public String entityDbMapping() {
    return "spring/01-basics/03-entity-db-mapping";
  }
  @GetMapping("/01-basics/04-repository-basic")
  public String repositoryBasic() {
    return "spring/01-basics/04-repository-basic";
  }

  @GetMapping("/01-basics/05-repository-crud")
  public String repositoryCrud() {
    return "spring/01-basics/05-repository-crud";
  }

  @GetMapping("/01-basics/06-domain-categorize")
  public String domainCateorize() {
    return "spring/01-basics/06-domain-categorize";
  }
  @GetMapping("/01-basics/07-templates")
  public String setTemplates() {
    return "spring/01-basics/07-templates";
  }

  //########## 2번째 장: board base pages #################
  @GetMapping("/02-board-basic-page/01-question-list")
  public String questionListNote() {
    return "spring/02-board-basic-page/01-question-list";
  }

  @GetMapping("//02-board-basic-page/02-service-intro")
  public String serviceIntro() {
    return "spring//02-board-basic-page/02-service-intro";
  }

  @GetMapping("/02-board-basic-page/03-question-detail")
  public String questionDetail() {
    return "spring/02-board-basic-page/03-question-detail";
  }

  @GetMapping("/02-board-basic-page/04-thymeleaf-style")
  public String thymeleafStyle() {
    return "spring/02-board-basic-page/04-thymeleaf-style";
  }

  @GetMapping("/02-board-basic-page/05-question-create")
  public String questionCreate() {
    return "spring/02-board-basic-page/05-question-create";
  }

  @GetMapping("/02-board-basic-page/06-validation")
  public String questionValidate() {
    return "spring/02-board-basic-page/06-validation";
  }

//########## 3번째 장: advanced #################
  @GetMapping("/03-board-advanced/01-nav-bar")
  public String navBar() {
    return "spring/03-board-advanced/01-nav-bar";
  }

  @GetMapping("/03-board-advanced/02-paging")
  public String paging() {
    return "spring/03-board-advanced/02-paging";
  }

  @GetMapping("/03-board-advanced/03-board-detail")
  public String boardDetail() {
    return "spring/03-board-advanced/03-board-detail";
  }

  @GetMapping("/03-board-advanced/04-spring-security")
  public String aboutSpringSecurity() {
    return "spring/03-board-advanced/04-spring-security";
  }

  @GetMapping("/03-board-advanced/05-user-subscribe")
  public String userSubscribe() {
    return "spring/03-board-advanced/05-user-subscribe";
  }

  @GetMapping("/03-board-advanced/06-login-logout")
  public String loginAndLogout() {
    return "spring/03-board-advanced/06-login-logout";
  }

  //########## 4번째 장 : 수정,삭제, 사용자 추가 등 #################
  @GetMapping("/04-board-more/01-add-author")
  public String addAuthor() {
    return "spring/04-board-more/01-add-author";
  }

  @GetMapping("/04-board-more/02-edit-delete")
  public String editDelete() {
    return "spring/04-board-more/02-edit-delete";
  }





  //########## 5번째 장 : etc #################
    @GetMapping("/05-board-etc/01-start")
  public String startEtc() {
    return "spring/05-board-etc/01-start";
  }


  //########## 6번째 장: JSP #################
  @GetMapping("/06-JSP/01-settings")
  public String setJSP() {
    return "spring/06-JSP/01-settings";
  }

  @GetMapping("/06-JSP/02-start-jsp")
  public String startJSP() {
    return "spring/06-JSP/02-start-jsp";
  }

  @GetMapping("/06-JSP/03-method-scriptlit")
  public String jspMethodScript() {
    return "spring/06-JSP/03-method-scriptlit";
  }
}

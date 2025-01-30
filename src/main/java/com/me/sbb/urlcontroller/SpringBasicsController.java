package com.me.sbb.urlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring/01-basics")
public class SpringBasicsController {

  String baseUrl = "spring/01-basics/";

  @GetMapping("/00-project-architecture")
  public String projectArchitecture() {
    return baseUrl + "00-project-architecture";
  }

  @GetMapping("/01-Controller")
  public String controllerSetting() {
    return baseUrl + "01-Controller";
  }
  @GetMapping("/02-JPA-db")
  public String jpaDb() {
    return baseUrl + "02-JPA-db";
  }
  @GetMapping("/03-entity-db-mapping")
  public String entityDbMapping() {
    return baseUrl + "03-entity-db-mapping";
  }
  @GetMapping("/04-repository-basic")
  public String repositoryBasic() {
    return baseUrl + "04-repository-basic";
  }

  @GetMapping("/05-repository-crud")
  public String repositoryCrud() {
    return baseUrl + "05-repository-crud";
  }

  @GetMapping("/06-domain-categorize")
  public String domainCateorize() {
    return baseUrl + "06-domain-categorize";
  }
  @GetMapping("/07-templates")
  public String setTemplates() {
    return baseUrl + "07-templates";
  }
}


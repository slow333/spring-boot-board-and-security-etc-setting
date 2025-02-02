package com.me.sbb.answer;

import com.me.sbb.question.Question;
import com.me.sbb.question.QuestionService;
import com.me.sbb.user.UserInfor;
import com.me.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/sbb-UI")
@RequiredArgsConstructor
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/answer/create/{question_id}")
  public String createAnswer(Model model,
                             @PathVariable("question_id") Integer question_id,
                             @Valid AnswerForm answerForm, BindingResult bindingResult,
                             Principal principal) {
    
    Question question = this.questionService.getQuestion(question_id);
    UserInfor userInfor = this.userService.getUser(principal.getName());
    // validation 관련(AnswerForm을 받아서 처리)
    if(bindingResult.hasErrors()){
      model.addAttribute("question", question);
      return "/sbb-UI/question/question_detail";
    }
    // 정상적 일때
    this.answerService.create(question, answerForm.getContent(), userInfor);
    return String.format("redirect:/sbb-UI/question/question_detail/%s", question_id);
  }
}

package com.me.sbb.answer;

import com.me.sbb.question.Question;
import com.me.sbb.question.QuestionService;
import com.me.sbb.user.UserInfor;
import com.me.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequestMapping("/ui/answer")
@RequiredArgsConstructor
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/create/{id}")
  public String createAnswer(Model model, @PathVariable("id") Integer id,
                             @Valid AnswerForm answerForm, BindingResult bindingResult,
                             Principal principal) {
    
    Question question = this.questionService.getQuestion(id);
    UserInfor userInfor = this.userService.getUser(principal.getName());
    // validation 관련(AnswerForm을 받아서 처리)
    if(bindingResult.hasErrors()){
      model.addAttribute("question", question);
      return "ui/question/question_detail";
    }
    // 정상적 일때
    this.answerService.create(question, answerForm.getContent(), userInfor);
    return String.format("redirect:/ui/question/question_detail/%s", id);
  }
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/modify/{id}")
  public String answerModify(AnswerForm answerForm,
                             @PathVariable("id") Integer id,
                             Principal principal) {
    Answer answer = this.answerService.getAnswer(id);
    if (!answer.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    }
    answerForm.setContent(answer.getContent());
    return "ui/answer/answer_form";
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/modify/{id}")
  public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult,
                             @PathVariable("id") Integer id,
                             Principal principal) {
    if (bindingResult.hasErrors()) {
      return "ui/answer/answer_form";
    }
    Answer answer = this.answerService.getAnswer(id);
    if (!answer.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    }
    this.answerService.modify(answer, answerForm.getContent());
    return String.format("redirect:/ui/question/question_detail/%s", answer.getQuestion().getId());
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/delete/{id}")
  public String answerDelete(Principal principal,
                             @PathVariable("id") Integer id) {
    Answer answer = this.answerService.getAnswer(id);
    if (!answer.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
    }
    this.answerService.delete(answer);
    return String.format("redirect:/ui/question/question_detail/%s", answer.getQuestion().getId());
  }
}

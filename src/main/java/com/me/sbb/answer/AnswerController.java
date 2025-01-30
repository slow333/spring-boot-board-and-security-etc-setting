package com.me.sbb.answer;

import com.me.sbb.question.Question;
import com.me.sbb.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/sbb-UI")
@RequiredArgsConstructor
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;

  @PostMapping("/answer/create/{question_id}")
  public String createAnswer(Model model,
                             @PathVariable("question_id") Integer question_id,
                             @Valid AnswerForm answerForm, BindingResult bindingResult) {
    Question question = this.questionService.getQuestion(question_id);
    if(bindingResult.hasErrors()){
      model.addAttribute("question", question);
      return "/sbb-UI/question/question_detail";
    }
    this.answerService.create(question, answerForm.getContent());
    return String.format("redirect:/sbb-UI/question/question_detail/%s", question_id);
  }
}

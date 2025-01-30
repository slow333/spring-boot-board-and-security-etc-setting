package com.me.sbb.question;

import com.me.sbb.answer.AnswerForm;
import com.me.sbb.utils.DataNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sbb-UI/question")
@RequiredArgsConstructor
public class QuestionController {

//  private final QuestionRepository questionRepository;
  private final QuestionService questionService;

  //  @GetMapping("/question/question_detail/{id}")
//  public String detailQuestion(Model model, @PathVariable("id") Integer id){
  @GetMapping(value={"/question_detail/{id}", "/question_detail"})
  public String detailQuestion(Model model,
                               @PathVariable(required = false) Integer id,
                               AnswerForm answerForm) {
    if(id == null) {
      id = 3;
    }
    Question question = this.questionService.getQuestion(id);

    model.addAttribute("question", question);
    return baseUrl + "question_detail";
  }

  private String baseUrl = "sbb-UI/question/";

  @GetMapping("/question_list")
  public String questionList(Model model) {
    List<Question> questionList = this.questionService.getList();

    model.addAttribute("list", questionList);
    return baseUrl +"question_list";
  }

  @GetMapping("/question_form")
  public String newQuestion(QuestionForm questionForm) {
    return baseUrl + "question_form";
  }

  @PostMapping("/add")
  public String addQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult) {
    if(bindingResult.hasErrors()){
      return baseUrl + "question_form";
    }

    this.questionService.addQuestion(questionForm.getSubject(), questionForm.getContent());

    return "redirect:/sbb-UI/question/question_list";
  }
}

package com.me.sbb.question;

import com.me.sbb.answer.AnswerForm;
import com.me.sbb.user.UserInfor;
import com.me.sbb.user.UserService;
import com.me.sbb.utils.DataNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sbb-UI/question")
@RequiredArgsConstructor
public class QuestionController {

  private final QuestionService questionService;
  private final UserService userService;
  private String baseUrl = "sbb-UI/question/";

//  path variable이 없을 경우에 대해
  // AnswerForm을 주입해서 templates에서 받아서 애러 표시
  @GetMapping(value={"/question_detail/{id}", "/question_detail"})
  public String detailQuestion(Model model,
                               @PathVariable(required = false) Integer id,
                               AnswerForm answerForm) {
    if(id == null) id = 3;
    Question question = this.questionService.getQuestion(id);

    model.addAttribute("question", question);
    return baseUrl + "question_detail";
  }

  @GetMapping("/question_list")
  public String pagingQuestionList(Model model,
                             @RequestParam(value="page", defaultValue = "0") int page) {
    Page<Question> paging = this.questionService.getList(page);
    System.out.println(paging);
    model.addAttribute("pagingList", paging);
    return baseUrl +"question_list";
  }

  // 2. validation을 처리하기 위해 QuestionForm을 매게변수로 전달
  @GetMapping("/create")
  @PreAuthorize("isAuthenticated()")
  public String createQuestion(QuestionForm questionForm) {
    return baseUrl + "question_form";
  }

  @PostMapping("/create")
  @PreAuthorize("isAuthenticated()")
  public String createQuestion(@Valid QuestionForm questionForm,
                            BindingResult bindingResult,
                            Principal principal) {
    UserInfor userInfor = this.userService.getUser(principal.getName());
    // 1. validation에 대한 애러 처리
    if(bindingResult.hasErrors()){
      return baseUrl + "question_form";
    }

    this.questionService.addQuestion(
            questionForm.getSubject(),
            questionForm.getContent(), userInfor);

    return "redirect:/sbb-UI/question/question_list";
  }
}

package com.me.sbb.answer;

import com.me.sbb.question.Question;
import com.me.sbb.user.UserInfor;
import com.me.sbb.utils.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;

  public void create(Question question, String content, UserInfor author) {

    Answer answer = new Answer();
    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setQuestion(question);
    answer.setAuthor(author);

    this.answerRepository.save(answer);
  }

  public Answer getAnswer(Integer id) throws DataNotFoundException {
    Optional<Answer> answer = this.answerRepository.findById(id);
    if(answer.isPresent()){
      return answer.get();
    } else {
      throw new DataNotFoundException("no answer");
    }
  }
}

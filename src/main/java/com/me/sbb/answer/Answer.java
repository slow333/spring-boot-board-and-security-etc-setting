package com.me.sbb.answer;

import com.me.sbb.question.Question;
import com.me.sbb.user.UserInfor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;

  @ManyToOne
  private Question question;

  @ManyToOne
  private UserInfor author;

  @Override
  public String toString() {
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dt = createDate.format(dtFormatter);
//    String dt = createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    return "Answer{" +
            "id=" + id +
            ", content='" + content + '\'' +
            ", createDate=" + dt +
            ", question=" + question +
            '}';
  }
}

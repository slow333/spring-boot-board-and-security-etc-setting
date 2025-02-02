package com.me.sbb.question;

import com.me.sbb.answer.Answer;
import com.me.sbb.user.UserInfor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 200)
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;

  @OneToMany(mappedBy = "question" , cascade = CascadeType.REMOVE)
  private List<Answer> answerList;

  @ManyToOne
  private UserInfor author;

  @Override
  public String toString() {
    String dt = createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    return "{ id: "+id+", subject : "+subject+", content: " + content +", subDateTime : "+  dt;
  }
}

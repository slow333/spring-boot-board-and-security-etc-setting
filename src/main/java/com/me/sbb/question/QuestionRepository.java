package com.me.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

  Optional<Question> findBySubject(String subject);

  Optional<List<Question>> findBySubjectLike(String substring);

  Optional<Question> findBySubjectAndContent(String subject, String content);
}

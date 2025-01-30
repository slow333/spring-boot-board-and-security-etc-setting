package com.me.sbb;

import com.me.sbb.answer.Answer;
import com.me.sbb.answer.AnswerRepository;
import com.me.sbb.question.Question;
import com.me.sbb.question.QuestionRepository;
import com.me.sbb.question.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionService questionService;

	@Test
	void jpaTest() {
//		Question q1 = new Question();
//		q1.setSubject("내용 추가해보기");
//		q1.setContent("아직 시험중");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("추가 추가 시험");
//		q2.setContent(";AUTO_SERVER=true는 @Transactional과 쫑나요");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//		Optional<Question> q = this.questionRepository.findById(3);
//		assertTrue(q.isPresent());
//		Question qInstanc = q.get();
//		assertEquals("fifth subject", qInstanc.getSubject());
//
//		Optional<List<Question>> oqList = this.questionRepository.findBySubjectLike("%주제%");
//		assertTrue(oqList.isPresent());
//		List<Question> list = oqList.get();
//		assertEquals(2, list.size());
//		this.questionRepository.delete(list.get(0));
//		assertEquals(1, list.size());
//
//		Optional<Question> oq = questionRepository.findById(76);
//		assertTrue(oq.isPresent());
//		Question qa = oq.get();
//		Answer a1 = new Answer();
//		a1.setContent("test에서 @Transactional을 삭제해야함.");
//		a1.setCreateDate(LocalDateTime.now());
//		a1.setQuestion(qa);
//		answerRepository.save(a1);
//
//		Answer a2 = new Answer();
//		a2.setContent(";AUTO_SERVER=true 설정을 유지해야함...");
//		a2.setCreateDate(LocalDateTime.now());
//		a2.setQuestion(qa);
//		answerRepository.save(a2);
//
//		Optional<Answer> an1= this.answerRepository.findById(1);
//		assertTrue(an1.isPresent());
//		Answer anInstance = an1.get();
//		System.out.println(anInstance);

		List<Question> allList = this.questionRepository.findAll();
		List<Question> allList2 = this.questionService.getList();
		assertEquals(5, allList2.size());
	}
}

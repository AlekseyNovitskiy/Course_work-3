package com.example.course_work3;

import com.example.course_work3.exception.UnSufficientQuestionsException;
import com.example.course_work3.service.ExaminerServiceImpl;
import com.example.course_work3.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void whenAmountOfQuestionIsSufficientThenGetQuestionReturnExactAmount() {
        List<Question> questionList = List.of(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"));

        when(questionService.getAll()).thenReturn(questionList);
        when(questionService.getRandomQuestion()).thenReturn(questionList.get(0), questionList.get(1));

        assertThat(examinerService.getQuestions(2))
                .hasSize(2).containsOnly(questionList.get(0),questionList.get(1));
    }

    @Test
    void whenAmountOfQuestionsIsInSufficientThenMethodThrowsExeption() {
        when(questionService.getAll()).thenReturn(Collections.emptyList());
        assertThatThrownBy(() -> examinerService.getQuestions(100))
                .isInstanceOf(UnSufficientQuestionsException.class);
    }

}

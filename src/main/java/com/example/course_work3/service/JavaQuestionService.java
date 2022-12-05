package com.example.course_work3.service;

import com.example.course_work3.Question;
import com.example.course_work3.exception.UnSufficientQuestionsException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final static Random RANDOM = new Random();
    private final Set<Question> questions = new HashSet<>();

        @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new UnSufficientQuestionsException();
        }
        return questions.stream().skip(RANDOM.nextInt(0,questions.size()))
                .findFirst().orElseThrow();
    }


}

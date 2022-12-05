package com.example.course_work3.service;

import com.example.course_work3.Question;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}

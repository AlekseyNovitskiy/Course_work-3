package com.example.course_work3.service;

import com.example.course_work3.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}

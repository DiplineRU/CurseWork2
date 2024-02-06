package org.example.cursework2.service;

import org.example.cursework2.Model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);


}

package org.example.cursework2.service.impl;

import org.example.cursework2.Model.Question;
import org.example.cursework2.exception.QuestionAlreadyExistsException;
import org.example.cursework2.exception.QuestionAreEmptyException;
import org.example.cursework2.exception.QuestionNotFoundException;
import org.example.cursework2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    public final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionAreEmptyException();
        }
        int count = random.nextInt(questions.size());
        int counter = 0;
        for (Question question : questions) {
            if (counter == count) {
                return question;
            }
            counter++;
        }
        return null;
    }
}

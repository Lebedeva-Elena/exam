package coursework2.com.exam.service;

import coursework2.com.exam.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}

package coursework2.com.exam.service;

import coursework2.com.exam.dto.Question;
import coursework2.com.exam.exception.NotEnoughQuestion;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    //private final Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;

    }
    @Override
    public  Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount){
            throw new NotEnoughQuestion();
        }
        Set<Question> resultQuestionsSet = new HashSet<>();
        while (resultQuestionsSet.size() < amount) {
            resultQuestionsSet.add(questionService.getRandomQuestion());
        }
        return resultQuestionsSet;
    }
}

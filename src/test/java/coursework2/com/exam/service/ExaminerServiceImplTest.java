package coursework2.com.exam.service;

import coursework2.com.exam.dto.Question;
import coursework2.com.exam.exception.NotEnoughQuestion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_shouldSetQuestionsIfQuestionsEnough() {
        int amount = 3;
        Question question = new Question("question", "answer");
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Set<Question> questions = Set.of(question, question1, question2);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question, question1);

        Collection<Question> result = examinerService.getQuestions(amount);
        assertEquals(questions, result);
        assertEquals(amount, result.stream().distinct().count());


    }

    @Test
    void getQuestions_shouldThrowExceptionIfQuestionsNotEnoughInMap() {
        when(questionService.getAll()).thenReturn(Collections.emptySet());

        assertThrows(NotEnoughQuestion.class,
                () -> examinerService.getQuestions(2));
    }
}
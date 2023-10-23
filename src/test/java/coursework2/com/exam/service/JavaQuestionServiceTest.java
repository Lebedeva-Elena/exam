package coursework2.com.exam.service;

import coursework2.com.exam.dto.Question;
import coursework2.com.exam.exception.NotEnoughQuestion;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private Question expectedQuestion = new Question("question", "answer");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());

        assertTrue(underTest.getAll().contains(expectedQuestion));
        assertEquals(expectedQuestion, result);

    }

    @Test
    void testAdd() {
    }

    @Test
    void remove_shouldRemoveQuestionToSetAndReturnQuestion() {
        Question result = underTest.remove(expectedQuestion);
        assertFalse(underTest.getAll().contains(expectedQuestion));
        assertEquals(expectedQuestion, result);
    }

    @Test
    void getAll_shouldReturnQuestionWhenQuestionInMap() {
        Question question = new Question("question1", "answer1");
        underTest.add(question);
        underTest.add(expectedQuestion);

        Collection<Question> result = underTest.getAll();

        assertEquals(Set.of(question, expectedQuestion), result);

    }

    @Test
    void getRandomQuestion_shouldReturnQuestionIfEnoughQuestions() {
        underTest.add(expectedQuestion);
        Question result = underTest.getRandomQuestion();
        assertEquals(expectedQuestion, result);

    }
    @Test
    void getRandomQuestion_shouldReturnExceptionWhenCollectionIsEmpty() {
        assertThrows(NotEnoughQuestion.class, () -> underTest.getRandomQuestion());
    }
}
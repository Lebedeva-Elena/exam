package coursework2.com.exam.service;

import coursework2.com.exam.dto.Question;
import coursework2.com.exam.exception.NotEnoughQuestion;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random rnd = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionEntity = new Question(question, answer);
        return add(questionEntity);
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
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.isEmpty()) {
            throw new NotEnoughQuestion();
        }
        int random = rnd.nextInt(questions.size());
        return (Question) questions.toArray()[random];



    }
}

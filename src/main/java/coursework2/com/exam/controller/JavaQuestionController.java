package coursework2.com.exam.controller;

import coursework2.com.exam.dto.Question;
import coursework2.com.exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {


    private final QuestionService service;
    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer) {
        return service.remove(new Question(question, answer));

    }
}

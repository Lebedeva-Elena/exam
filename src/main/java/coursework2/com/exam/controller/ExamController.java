package coursework2.com.exam.controller;


import coursework2.com.exam.dto.Question;
import coursework2.com.exam.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    private ExaminerService examinerService;
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);

    }
}

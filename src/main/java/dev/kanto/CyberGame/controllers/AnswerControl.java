package dev.kanto.CyberGame.controllers;

import dev.kanto.CyberGame.Repositories.AnswerRepository;
import dev.kanto.CyberGame.model.Answer;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerControl {

    private final AnswerRepository AnswerRepository;

    public AnswerControl(dev.kanto.CyberGame.Repositories.AnswerRepository answerRepository) {
        this.AnswerRepository = answerRepository;
    }
    @GetMapping("/GetAnswer/")
    @ResponseBody
    @CrossOrigin(origins = "http://35.179.75.192:3000/")
    public Answer GetAnswer(@RequestParam String id) {
        System.out.println("Getting Answer by id: " + id);
        Answer answer = AnswerRepository.findAnswerByid(id);
        if (answer.getSeconderyQuestionID() != null) {
            int random = (int) (Math.floor(Math.random() + 1.5));
            System.out.println(random);
            if (random == 1) {
                System.out.println("It was a one");
                return answer;
            }

            answer.setLinkedQuestionID(answer.getSeconderyQuestionID());
            return answer;
        }
        return answer;
    }
}


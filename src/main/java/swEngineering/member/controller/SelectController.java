package swEngineering.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SelectController {
    @GetMapping("/select/toeic")
    public String toeicForm(){
        return "toeic";
    }

    @GetMapping("/select/teps")
    public String tepsForm(){
        return "teps";
    }


    @GetMapping("/select/csat")
    public String castForm(){
        return "csat";
    }

    @GetMapping("/select/test")
    public String testForm(){
        return "test";
    }
}

package hello.hello.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/") //첫번째로 호출됨
    public String home(){
        return "home";
    }

}

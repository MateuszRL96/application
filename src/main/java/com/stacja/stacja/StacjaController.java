package com.stacja.stacja;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/stacja")
@CrossOrigin(origins = "http://localhost:51583")
public class StacjaController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}

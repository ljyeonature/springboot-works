package com.example.demo.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    // 추후에 SQLException / BoardException ...
    public String handle(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "/error/generalError";
    }
}

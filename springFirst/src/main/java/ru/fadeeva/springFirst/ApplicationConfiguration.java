package ru.fadeeva.springFirst;

import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {
    @Bean
    StudentRepository studentRepository(){
        return new StudentRepository();
    }
}

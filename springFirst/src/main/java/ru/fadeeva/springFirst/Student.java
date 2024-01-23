package ru.fadeeva.springFirst;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Student {

    public static List<Student> students = new ArrayList<>();

    private int id;
    private String name;
    private String groupName;

    @JsonCreator
    public Student(int id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }
}

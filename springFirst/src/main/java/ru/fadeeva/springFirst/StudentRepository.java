package ru.fadeeva.springFirst;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> students;
    public StudentRepository(){
        this.students= new ArrayList<>();
        students.add(new Student(1, "Petr", "physics"));
        students.add(new Student(2, "Sveta", "chemistry"));
        students.add(new Student(3, "Petr", "math"));
        students.add(new Student(4, "Valya", "chemistry"));
        students.add(new Student(5, "Ivan", "math"));
    }

    public List<Student> getStudents(){
        return List.copyOf(students);
    }

    public Student getNameById(int id){
        return students.stream().filter(s->s.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentByName(String name){
        return students.stream().filter(s->s.getName().contains(name)).collect(Collectors.toList());
    }
    public List<Student> getStudentByGroup(String group){
        return students.stream().filter(s->s.getGroupName().contains(group)).collect(Collectors.toList());
    }

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public Student deleteById(int id) {
        return students.stream().filter(s->s.getId()==id).findFirst().get() ;
    }
}

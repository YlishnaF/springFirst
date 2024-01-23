package ru.fadeeva.springFirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {
    private StudentRepository repository;


    public MyController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id)   {
       return repository.getNameById(id);
    }

    @GetMapping
    public List<Student> getListStudents()   {
        return repository.getStudents();
    }

    @GetMapping("/")
    public List<Student> getStudentsByName(@RequestParam String name){
        return  repository.getStudentByName(name);
    }
    @RequestMapping(path = "/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return repository.getStudentByGroup(groupName);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student ){
        return repository.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable int id)   {
        return repository.deleteById(id);
    }
}

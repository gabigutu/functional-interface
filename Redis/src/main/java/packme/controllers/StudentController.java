package packme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import packme.model.Student;
import packme.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping("/student")
    public String postStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student).toString();
    }


}

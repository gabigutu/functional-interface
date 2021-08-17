package packme.service;

import org.springframework.stereotype.Service;
import packme.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import packme.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        student = studentRepository.save(student);
        return student;
    }

    public Student retrieveStudent(String id) {
        return studentRepository.findById(id).get();
    }

}

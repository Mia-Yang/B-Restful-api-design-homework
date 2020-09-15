package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudents(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delStudent(@PathVariable Integer id) {
        studentService.delStudent(id);
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List getStudentsByGender(@RequestParam(required = false) String gender) {
        return studentService.getStudentsByGender(gender);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentsById(@PathVariable int id) {
        return studentService.getStudentsById(id);
    }

    @PatchMapping("/students/{id}")
    public Student updateStudentInfo(@PathVariable int id, @RequestBody Student studentInfo) {
        return studentService.updateStudentInfo(id, studentInfo);
    }
}

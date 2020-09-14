package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.addStudents(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delStudent(@PathVariable Integer id) {
        studentService.delStudent(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/students")
    public ResponseEntity<List> getStudentsByGender(@RequestParam(required = false) String gender) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByGender(gender));
    }

}

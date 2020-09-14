package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "杨思雨", "female", ""));
        students.add(new Student(2, "徐慧慧", "female", ""));
        students.add(new Student(3, "陈思聪", "male", ""));
        students.add(new Student(4, "王江林", "male", ""));
        students.add(new Student(5, "王登宇", "male", ""));
        students.add(new Student(6, "沈乐祺", "male", ""));
    }

    public void addStudents(Student student) {
        int next_id = students.size() + 1;
        student.setId(next_id);
        students.add(student);
    }

    public void delStudent(Integer id) {
        students.remove(id - 1);
    }

    public List<Student> getStudentsByGender(String gender) {
        if (gender == null) {
            return students;
        }
        return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudentsById(int id) {
        return students.get(id - 1);
    }

    public Student updateStudentInfo(int id, Student studentInfo) {
        Student student = students.get(id - 1);
        student.setGender(studentInfo.getGender() == null ? student.getGender():studentInfo.getGender());
        student.setName(studentInfo.getName() == null ? student.getName() : studentInfo.getName());
        student.setNote(studentInfo.getNote() == null ? student.getNote() : studentInfo.getNote());
        return student;
    }
}

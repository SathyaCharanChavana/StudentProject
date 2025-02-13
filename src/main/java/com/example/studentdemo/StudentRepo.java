package com.example.studentdemo;

import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    private static Map<Integer,Student> studentCache= new HashMap<>();
    private static int counter=1;
    public static Student createStudent(Student student){
        student.setStudentId(counter);
        int tempId=counter;
        studentCache.put(counter,student);
        counter++;
        return studentCache.get(tempId);
    }

    public boolean updateStudent(int studentId,Student student){
        studentCache.put(studentId,student);
        if(studentCache.get(studentId)==student)
            return true;
        else
            return false;
        }

    public ArrayList<Student> getAllstudents(){
        List<Student> allStudents=new ArrayList<>(studentCache.values());
        return (ArrayList<Student>) allStudents;
}

    public Student getStudent(int studentID){
        return studentCache.get(studentID);
    }

    public void deleteStudent(int studentId){
        studentCache.remove((studentId));
    }
}

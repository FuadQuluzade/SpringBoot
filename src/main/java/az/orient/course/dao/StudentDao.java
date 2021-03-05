package az.orient.course.dao;

import az.orient.course.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    void addStudent(Student student) throws  Exception;

    void updateStudent(Student student) throws Exception;

    void deleteStudent(Long studentId) throws Exception;

    Integer countStudent() throws Exception;

}

package az.orient.course.service;

import az.orient.course.request.ReqStudent;
import az.orient.course.response.RespStatusList;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;


public interface StudentService {

    RespStudentList getStudenteList();

    RespStatusList addStudent(ReqStudent reqStudent);

    RespStatusList updateStudent(ReqStudent reqStudent);

    RespStatusList deleteStudent(ReqStudent reqStudent);

    RespStudent getStudentById(Long studentId);
}

package az.orient.course.controller;

import az.orient.course.request.ReqStudent;
import az.orient.course.response.RespStatusList;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;
import az.orient.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentList")
    public RespStudentList getStudentList(){
        return studentService.getStudenteList();
    }

    @PostMapping(value = "/addStudent")
    public RespStatusList addStudent(@RequestBody ReqStudent reqStudent){
        return  studentService.addStudent(reqStudent);
    }

    @PutMapping(value = "/updateStudent")
    public RespStatusList updateStudent(@RequestBody ReqStudent reqStudent){
        return  studentService.updateStudent(reqStudent);
    }

    @PutMapping(value = "/deleteStudent")
    public RespStatusList deleteStudent(@RequestBody ReqStudent reqStudent){
        return  studentService.deleteStudent(reqStudent);
    }

    @GetMapping(value = "/getStudentById/{studentId}")
    public RespStudent getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }
}

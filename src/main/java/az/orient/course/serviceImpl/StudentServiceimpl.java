package az.orient.course.service;

import az.orient.course.dao.StudentDao;
import az.orient.course.exception.ExceptionConstant;
import az.orient.course.model.Student;
import az.orient.course.request.ReqStudent;
import az.orient.course.response.RespStatus;
import az.orient.course.response.RespStatusList;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceimpl  implements StudentService {

    @Autowired
    private StudentDao studentDao;

    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public RespStudentList getStudenteList() {
        RespStudentList response=new RespStudentList();
        List<RespStudent> respStudentList=new ArrayList<>();

        try {
            List<Student> studentList=  studentDao.getStudentList();
            if(studentList.isEmpty()){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return  response;
            }
            for(Student student :studentList){
                RespStudent respStudent=new RespStudent();
                respStudent.setStudentId(student.getId());
                respStudent.setName(student.getName());
                respStudent.setSurname(student.getSurname());
                respStudent.setAddress(student.getAddress());
                respStudent.setPhone(student.getPhone());
                if(student.getDob() != null)
                    respStudent.setDob(df.format(student.getDob()));
                respStudentList.add(respStudent);

            }
            response.setStudentList(respStudentList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));
        }
        return response;
    }

    @Override
    public RespStatusList addStudent(ReqStudent reqStudent) {
        RespStatusList response =new RespStatusList();
        try {
            String name=reqStudent.getName();
            String surname =reqStudent.getSurname();
            String address =reqStudent.getAddress();
            String phone=reqStudent.getPhone();
            Date dob=reqStudent.getDob();
            if(name == null ||
                    surname == null||
                    dob== null  ){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            Student student =new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setAddress(address);
            student.setPhone(phone);
            student.setDob(dob);
            studentDao.addStudent(student);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));

        }
        return response;
    }

    @Override
    public RespStatusList updateStudent(ReqStudent reqStudent) {
        RespStatusList response =new RespStatusList();
        try {

            String name=reqStudent.getName();
            String surname =reqStudent.getSurname();
            String address =reqStudent.getAddress();
            String phone=reqStudent.getPhone();
            Date dob=reqStudent.getDob();
            Long studentId=reqStudent.getStudentId();
            if(name == null ||
                    surname == null||
                    dob== null  ||
                    studentId ==null){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            Student student =new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setAddress(address);
            student.setPhone(phone);
            student.setDob(dob);
            student.setId(studentId);
            studentDao.updateStudent(student);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));

        }
        return response;
    }

    @Override
    public RespStatusList deleteStudent(ReqStudent reqStudent) {
        RespStatusList response =new RespStatusList();
        try {
            Long studentId=reqStudent.getStudentId();
            if(studentId ==null){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            studentDao.deleteStudent(studentId);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));
        }
        return response;
    }

    @Override
    public RespStudent getStudentById(Long studentId) {
        RespStudent response=new RespStudent();
        try {
            if(studentId ==null){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            Student student=  studentDao.getStudentById(studentId);
            if(student == null){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return  response;
            }

            response.setStudentId(student.getId());
            response.setName(student.getName());
            response.setSurname(student.getSurname());
            response.setAddress(student.getAddress());
            response.setPhone(student.getPhone());
            if(student.getDob() != null)
                response.setDob(df.format(student.getDob()));
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));
        }
        return response;
    }
}

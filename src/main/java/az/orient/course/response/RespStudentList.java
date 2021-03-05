package az.orient.course.response;

import lombok.Data;

import java.util.List;

@Data
public class RespStudentList {
    private List<RespStudent> studentList;
    private RespStatus status;
}

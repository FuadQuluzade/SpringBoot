package az.orient.course.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespStudent {

    private Long studentId;
    private String name;
    private String surname;
    private String address;
    private String dob;
    private String phone;
    private RespStatus status;


}

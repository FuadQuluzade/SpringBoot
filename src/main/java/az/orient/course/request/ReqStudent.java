package az.orient.course.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqStudent {

    private Long studentId;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Date dob;

}

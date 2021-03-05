package az.orient.course.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student extends Abstract{

    private String name;
    private String surname;
    private String address;
    private Date dob;
    private String phone;
}

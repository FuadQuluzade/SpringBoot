package az.orient.course.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespStatus {
    private Integer status_code;
    private String status_message;

    private static final Integer SUCCESS_CODE=0;
    private static final String SUCCESS_MESSAGE="success";

    public static RespStatus getSuccessMessage(){
        return new RespStatus(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
}

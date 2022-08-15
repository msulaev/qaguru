package data;

import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Builder
@Data
public class User {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String subject;
    private String currentAddress;
    private String state;
    private String email;
    private String birthDay;
    private String birthYear;
    private String birthMonth;
    private String city;
    private String gender;
    private String hobby;


    public static String[] getDate() {
        return new SimpleDateFormat("dd/MMMM/yyyy").format(new Date()).split("/");
    }

}

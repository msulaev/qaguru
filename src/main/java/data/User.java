package data;

import java.text.SimpleDateFormat;
import java.util.Date;

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


    public User(String name, String lastName, String phoneNumber, String subject, String currentAddress, String stete, String city, String email, String birthDay, String birthYear, String birthMonth, String gender, String hobby) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.subject = subject;
        this.currentAddress = currentAddress;
        this.state = stete;
        this.city = city;
        this.email = email;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static String[] getDate(){
       return new SimpleDateFormat("dd/MMMM/yyyy").format(new Date()).split("/");
    }

    public String getGender(){
        return gender;
    }

    public String getHobby() {
        return hobby;
    }
}

package com.example.Super.Admin.dao;



import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "course")
    private String course;

    @Column (name = "phonenumber")
    private String phonenumber;

    @Column (name = "dateofbirth")
    private String dateofbirth;

    @Column (name ="address")
    private String address;

    @Column (name = "courseFee")
    private Double courseFee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String  phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }
}

package cs.mum.edu.orangeteam.compro.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    private double GPA;
    
    //
    @Embedded
    private Address address;
    
    public Student() {
    }


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

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", GPA=" + GPA +
                ", address=" + address +
                '}';
    }
}

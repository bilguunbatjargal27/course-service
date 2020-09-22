package cs.mum.edu.orangeteam.compro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    private double GPA;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Attend> attends = new ArrayList<>();

    @OneToMany(mappedBy = "studentId")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @Column(name = "tm_instructor")
    private Long tmInstructor;

    private boolean canJobSearch;

    private Long jobId;

    private Long coachId;

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

    public List<Attend> getAttends() {
        return attends;
    }

    public void setAttends(List<Attend> attends) {
        this.attends = attends;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getTmInstructor() {
        return tmInstructor;
    }

    public void setTmInstructor(Long tmInstructor) {
        this.tmInstructor = tmInstructor;
    }

    public boolean isCanJobSearch() {
        return canJobSearch;
    }

    public void setCanJobSearch(boolean canJobSearch) {
        this.canJobSearch = canJobSearch;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
}

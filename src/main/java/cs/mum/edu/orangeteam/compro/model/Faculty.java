package cs.mum.edu.orangeteam.compro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date hiringDate;

    private String room;

    @OneToMany(mappedBy = "faculty")
    private List<Course> teachingCourses = new ArrayList<>();

    @Embedded
    private Address address;

    public Faculty() {
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

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

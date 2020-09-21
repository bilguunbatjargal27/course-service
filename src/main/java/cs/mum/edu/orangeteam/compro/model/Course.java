package cs.mum.edu.orangeteam.compro.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;

    private String title;

    private String building;

    private String room;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private boolean isTA;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "course")
    private List<Attend> attends = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isTA() {
        return isTA;
    }

    public void setTA(boolean TA) {
        isTA = TA;
    }

    public List<Attend> getAttends() {
        return attends;
    }

    public void setAttends(List<Attend> attends) {
        this.attends = attends;
    }
}

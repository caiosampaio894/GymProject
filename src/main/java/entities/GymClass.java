package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_gymClass")
public class GymClass {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String type;
    private String room;
    private List<String> days = new ArrayList<>();
    private String time;

    @ManyToMany
    @JoinTable(name="tb_gymClass_student",
                joinColumns = @JoinColumn(name="gymClass_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();

    @OneToMany
    @JoinTable(name = "tb_gymClass_coach",
                joinColumns = @JoinColumn(name = "gymClass_id"),
                inverseJoinColumns = @JoinColumn(name = "coach_id"))
    private String coach;

    public GymClass() {
    }

    public GymClass(Long id, String name, String type, String room, List<String> days, String time, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.room = room;
        this.days = days;
        this.time = time;
        this.students = students;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "GymClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", room='" + room + '\'' +
                ", days=" + days +
                ", time='" + time + '\'' +
                ", students=" + students +
                ", coach='" + coach + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GymClass other = (GymClass) obj;
        return Objects.equals(id, other.id);
    }
}

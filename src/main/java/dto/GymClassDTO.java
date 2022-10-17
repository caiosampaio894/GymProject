package dto;

import entities.Coach;
import entities.GymClass;
import entities.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GymClassDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String type;
    private String room;
    private List<List<String>> days = new ArrayList<>();
    private String time;

    private List<StudentDTO> students = new ArrayList<>();

    private String Coach;

    public GymClassDTO() {
    }

    public GymClassDTO(Long id, String name, String type, String room, List<List<String>> days, String time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.room = room;
        this.days = days;
        this.time = time;
    }

    public GymClassDTO(GymClass entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.room = entity.getRoom();
        this.time = entity.getTime();
        this.days = Arrays.asList(entity.getDays());
    }

    public GymClassDTO(GymClass entity, Set<Student> students) {
        this(entity);
        students.forEach(stu -> this.students.add(new StudentDTO(stu)));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<List<String>> getDays() {
        return days;
    }

    public void setDays(List<List<String>> days) {
        this.days = days;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

}

package dto;

import entities.Coach;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoachDTO {


    private Long id;
    private String name;
    private int age;
    private String expertise;

    private List<GymClassDTO> gymClass = new ArrayList<>();

    public CoachDTO() {
    }

    public CoachDTO(Long id, String name, int age, String expertise) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.expertise = expertise;
    }

    public CoachDTO(Coach entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.expertise = entity.getExpertise();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<GymClassDTO> getGymClass() {
        return gymClass;
    }

    public void setGymClass(List<GymClassDTO> gymClass) {
        this.gymClass = gymClass;
    }
}

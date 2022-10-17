package dto;

import entities.GymClass;
import entities.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private int age;
    private double weight;
    private double height;
    private List<GymClassDTO> gymClass = new ArrayList<>();

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, int age, double weight, double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public StudentDTO(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.weight = entity.getWeight();
        this.height = entity.getHeight();
    }

    public StudentDTO(Student entity, Set<GymClass> gymClass) {
        this(entity);
        gymClass.forEach(gc -> this.gymClass.add(new GymClassDTO(gc)));
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<GymClassDTO> getGymClass() {
        return gymClass;
    }

    public void setGymClass(List<GymClassDTO> gymClass) {
        this.gymClass = gymClass;
    }

}

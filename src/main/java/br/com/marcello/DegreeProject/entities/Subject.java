package br.com.marcello.DegreeProject.entities;

public class Subject {

    private Long id;
    private Double grade;
    private String name;

    public Subject(Long id, Double grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

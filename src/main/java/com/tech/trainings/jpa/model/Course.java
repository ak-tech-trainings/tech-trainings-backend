package com.tech.trainings.jpa.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long course_id;
    private String name;
    private String description;
    private int duration;
    /**
     * 1. The basic @ElementCollection annotation (where you can define the known fetch and targetClass preferences)
     * 2. The @CollectionTable annotation is very useful when it comes to giving a name to the table that'll be generated,
     *      as well as definitions like joinColumns, foreignKey's, indexes, uniqueConstraints, etc.
     * 3. @Column is important to define the name of the column that'll store the varchar value of the list.
     */
    @ElementCollection // 1
    @CollectionTable(name = "curriculum_details", joinColumns = @JoinColumn(name = "course_id")) // 2
    @Column(name = "curriculum") // 3
//    @JsonManagedReference
    private List<String> curriculum;
    private Long fee;

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(List<String> curriculum) {
        this.curriculum = curriculum;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", curriculum=" + curriculum +
                ", fee=" + fee +
                '}';
    }
}

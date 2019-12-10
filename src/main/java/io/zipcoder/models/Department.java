package io.zipcoder.models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Employee manager;

    public Department() {
    }

    public Department(String name) {
        this(null, name);
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;

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

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }


}

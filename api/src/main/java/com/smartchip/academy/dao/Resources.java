package com.smartchip.academy.dao;


import jakarta.persistence.*;

@Entity
@Table(name = "Resources")

public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column (name = "resourcepath")
    private String resourcepath;

    @Column (name = "extension")
    private String extension;

    @Column (name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getResourcepath() {
        return resourcepath;
    }

    public void setResourcepath(String resourcepath) {
        this.resourcepath = resourcepath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

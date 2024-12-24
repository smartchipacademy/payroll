package com.smartchip.academy.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "Fileupload")


public class Fileupload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "filepart")
    private String filepart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilepart() {
        return filepart;
    }

    public void setFilepart(String filepart) {
        this.filepart = filepart;
    }
}

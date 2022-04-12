package com.example.skillslearn.DAO_Adapter;

public class Subject {

    String id,subject,category,description;

    public Subject() {
    }

    public Subject(String id, String subject, String category, String description) {
        this.id = id;
        this.subject = subject;
        this.category = category;
        this.description = description;
    }

    public String getSubid() {
        return id;
    }

    public void setSubid(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

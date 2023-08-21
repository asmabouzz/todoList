package org.example.entity;


import javax.persistence.*;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="titre")
    private String titre;

    private boolean completed;

    public ToDoList() {
    }

    public ToDoList(String titre, boolean completed) {
        this.titre = titre;
        this.completed = completed;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", completed=" + completed +
                '}';
    }
}

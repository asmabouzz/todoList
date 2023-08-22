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

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idTask", referencedColumnName = "idTask")
    private TaskInfo task;


    public ToDoList() {
    }

//    public ToDoList(String titre, boolean completed, TaskInfo task) {
//        this.titre = titre;
//        this.completed = completed;
//        this.task = task;
//    }

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

    public TaskInfo getTask() {
        return task;
    }

    public void setTask(TaskInfo task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", completed=" + completed +
                ", task=" + task +
                '}';
    }
}

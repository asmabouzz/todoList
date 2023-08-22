package org.example.entity;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class TaskInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTask;


    private String description;

    private boolean priorite;

    private LocalDateTime date;



    public TaskInfo() {
    }

    public TaskInfo(String description, boolean priorite, LocalDateTime date) {
        this.description = description;
        this.priorite = priorite;
        this.date = date;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPriorite() {
        return priorite;
    }

    public void setPriorite(boolean priorite) {
        this.priorite = priorite;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "TaskInfo{" +
                "idTask=" + idTask +
                ", description='" + description + '\'' +
                ", priorite='" + priorite + '\'' +
                ", date=" + date +
                '}';
    }
}

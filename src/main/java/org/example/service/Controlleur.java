package org.example.service;

import org.example.entity.TaskInfo;
import org.example.entity.ToDoList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Controlleur {
   public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("to_do_postgres");




   public static void add(Object element){

       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(element);
       em.getTransaction().commit();
       em.close();

   }

   public static   void lister(){
       EntityManager em = emf.createEntityManager();

       List<ToDoList> maList = null;
       maList = em.createQuery("select todo from ToDoList todo", ToDoList.class).getResultList();

       for (ToDoList todo : maList) {
           System.out.println(todo);
       }

   }


    public static void remove(int id){
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();

       ToDoList toDoDelete = em.find(ToDoList.class,id);
       em.remove(toDoDelete);
       em.getTransaction().commit();
       em.close();

   }


    public static void completed(int id){
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       ToDoList completed = em.find(ToDoList.class,id);
       try {
           System.out.println(completed.toString());
           if(completed.isCompleted()) {
               completed.setCompleted(!completed.isCompleted());
           }else{
               completed.setCompleted(true);
           }
           System.out.println(completed.toString());
           em.getTransaction().commit();
       }catch ( NullPointerException e ){
           System.out.println("la todo list n'existe pas");
       }


       em.getTransaction().commit();
       em.close();
       emf.close();
   }

}

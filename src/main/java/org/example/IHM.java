package org.example;

import org.example.entity.TaskInfo;
import org.example.entity.ToDoList;
import org.example.service.Controlleur;

import java.time.LocalDateTime;
import java.util.Scanner;

public class IHM {

    private static Scanner scanner = new Scanner(System.in);



    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Cree ToDo List");
            System.out.println("2. Afficher les todo lists");
            System.out.println("3. todo fini");
            System.out.println("4. supprimer todo list");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addToList();
                    break;
                case 2:
                    AfficheListes();
                    break;
                case 3:
                    ListFini();
                    break;
                case 4:
                    deleteListes();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void deleteListes() {
        System.out.print("list a supprimer  : ");
        int id = scanner.nextInt();
        Controlleur.remove(id);
        System.out.println(" Supprimer  : ");


    }

    private static void ListFini() {


        System.out.print("list fini  : ");
        int id = scanner.nextInt();
        Controlleur.completed(id);


    }

    private static void AfficheListes() {
        Controlleur.lister();
    }

    private static void addToList() {
        System.out.println("creation de TODOlIST : ");
        System.out.print("titre  : ");
        String titre = scanner.nextLine();
        System.out.print("description  : ");
        String description = scanner.nextLine();

        ToDoList list = new ToDoList();

        TaskInfo info = new TaskInfo(description,true, LocalDateTime.now());



        list.setTitre(titre);
        list.setCompleted(false);
        list.setTask(info);

        System.out.println(list.toString());
        System.out.println(info.toString());

        Controlleur.add(info);
        Controlleur.add(list);



    }


}

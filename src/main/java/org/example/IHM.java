package org.example;

import org.example.entity.ToDoList;
import org.example.service.EditToDo;

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
        EditToDo.remove(id);
        System.out.print(" Supprimer  : ");


    }

    private static void ListFini() {


        System.out.print("list fini  : ");
        int id = scanner.nextInt();
        EditToDo.completed(id);


    }

    private static void AfficheListes() {
        EditToDo.lister();
    }

    private static void addToList() {
        System.out.println("creation de TODOlIST : ");
        System.out.print("titre  : ");
        String titre = scanner.nextLine();

        ToDoList list = new ToDoList(titre,false);

        EditToDo.add(list);



    }


}

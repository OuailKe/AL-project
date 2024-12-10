package net.javaguides;

import EmployeIHM.ManagementIHMV2;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
//        EmployeData.listEmployee = new ArrayList<>();
//        InterfaceGestion gestionEmployer = new GestionEmployer();
//        InterfaceSalaire gestionSalaire = new GestionSalaire();
//
//        IHMEmploye.sasirEmploye();
//        System.out.println("*********************");
//
//        IHMEmploye.sasirEmploye();
//        System.out.println("*********************");
//            for (Employe e : EmployeData.listEmployee){
//                IHMEmploye.afficherEmploye(e.getNom());
//            }
//
//        static InterfaceGestion gestion = new GestionEmployeV1();

        ////////////////////////////////////////////////////////////////////////////////////////
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("Menu:");
//            System.out.println("1. Saisir Employe");
//            System.out.println("2. Afficher Employe");
//            System.out.println("3. Quitter");
//            System.out.print("Entrez votre choix: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    IHMEmploye.sasirEmploye();
//                    break;
//                case 2:
//                    System.out.print("Entrez le nom de l'employe: ");
//                    String nom = scanner.next();
//                    IHMEmploye.afficherEmploye(nom);
//                    break;
//                case 3:
//                    System.out.println("Au revoir!");
//                    break;
//                default:
//                    System.out.println("Choix invalide, veuillez réessayer.");
//            }
//        } while (choice != 3);
//
//        scanner.close();

//////////////////////////////////////////////////////////////////

        new ManagementIHMV2().setVisible(true);



///////////////////////////////////////////////////////////////////////////////////////////////////////////////





//        Employe e2 = new Employe(2,"ouail","kerrak","fes","0633");
//        Employe e3 = new Employe(3,"ayoub","hhhh","fes","0792");
//        Employe e4 = new Employe(4,"amine","hahaha","fes","0743");

//        EmployeData.listEmployee.add(e2);
//        EmployeData.listEmployee.add(e3);
//        EmployeData.listEmployee.add(e4);

//        gestionEmployer.supprimerEmployee(e2);
//        gestionEmployer.supprimerEmployee(e3);
//        gestionEmployer.supprimerEmployee(e4);

//        for (Employe e : EmployeData.listEmployee){
//            System.out.println(" le nom :  "+ e.getNom());
//        }


    }
}
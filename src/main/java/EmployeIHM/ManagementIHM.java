package EmployeIHM;

import Enteties.Employe;
import Enteties.FicheSalaire;
import Services.GestionEmployeV1;
import Services.GestionSalaireV1;
import Services.InterfaceGestion;
import Services.InterfaceSalaire;

import java.util.Scanner;

public class ManagementIHM implements ManagementInterface {
    static InterfaceGestion gestion = new GestionEmployeV1();
    static InterfaceSalaire salary = new GestionSalaireV1();

    Scanner scanner = new Scanner(System.in);

    public void start() {
        int mainChoice;

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Employee Management");
            System.out.println("2. Salary Management");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    employeeManagementMenu(scanner);
                    break;
                case 2:
                    salaryManagementMenu(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (mainChoice != 3);

        scanner.close();
    }

    private void employeeManagementMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Employee Management Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmploye();
                    break;
                case 2:
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    findEmploye(name);
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }

    private void salaryManagementMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Salary Management Menu:");
            System.out.println("1. Add Salary Record");
            System.out.println("2. Display Salary Record");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement add salary record functionality
                    System.out.println("Add Salary Record functionality not implemented yet.");
                    break;
                case 2:
                    // Implement display salary record functionality
                    System.out.println("Display Salary Record functionality not implemented yet.");
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }

    public void addEmploye() {
        Employe e = new Employe();
        System.out.println("Saisir l'Id");
        e.setId(scanner.nextInt());
        System.out.println("Saisir le nom : ");
        e.setNom(scanner.next());
        System.out.println("Saisir le prenom : ");
        e.setPrenom(scanner.next());
        System.out.println("Saisir l'adresse ");
        e.setAdresse(scanner.next());
        System.out.println("Saisir le numéro tel ");
        e.setNumTel(scanner.next());

        gestion.aouterEmployee(e);
    }

    public void deleteEmploye() {
        System.out.print("Enter the employee name: ");
        String name = scanner.next();
        Employe e = gestion.chercherEmployee(name);
        if (e != null) {
            gestion.supprimerEmployee(e);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void findEmploye(String nom) {
        Employe e = gestion.chercherEmployee(nom);

        System.out.println("le nom est :" + e.getNom());
        System.out.println("le prenom est :" + e.getPrenom());
        System.out.println("l'adresse est :" + e.getAdresse());
        System.out.println("le num de tel est :" + e.getNumTel());
    }

    public void findAllEmployes() {

            for (Employe e : gestion.findAllEmployes()) {
                System.out.println("Id: " + e.getId());
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Adresse: " + e.getAdresse());
                System.out.println("Num Tel: " + e.getNumTel());
                System.out.println("-------------------------");
            }
    }

    public void updateEmploye() {
        Employe e = new Employe();
        System.out.println("Saisir l'Id");
        e.setId(scanner.nextInt());
        System.out.println("Saisir le nom : ");
        e.setNom(scanner.next());
        System.out.println("Saisir le prenom : ");
        e.setPrenom(scanner.next());
        System.out.println("Saisir l'adresse ");
        e.setAdresse(scanner.next());
        System.out.println("Saisir le numéro tel ");
        e.setNumTel(scanner.next());

        gestion.modifierEmployee(e);
    }

    public void addFicheSalaire() {

        FicheSalaire f = new FicheSalaire();

        System.out.println("Saisir le nombre h'heures :");
        f.setNbHeure(scanner.nextInt());

        System.out.println("Saisir le taux h'heures :");
        f.setTauxHeure(scanner.nextDouble());

        System.out.println("Saisir l'Id de l'employe :");
        Employe e = gestion.chercherEmployee(scanner.nextInt());
        f.setE(e);

        salary.ajouterFicheSalaire(f);
        salary.calculerSalair(f);
    }

    public void deleteFicheSalaire() {
        System.out.print("Enter the salary record ID: ");
        int id = scanner.nextInt();
        FicheSalaire f = salary.chercherFicheSalaire(id);
        if (f != null) {
            salary.supprimerFicheSalaire(f);
            System.out.println("Salary record deleted successfully.");
        } else {
            System.out.println("Salary record not found.");
        }
    }

    public void findFicheSalaire() {
        System.out.print("Enter the salary record ID: ");
        int id = scanner.nextInt();
        FicheSalaire f = salary.chercherFicheSalaire(id);
        if (f != null) {
            System.out.println("Le nombre d'heures est :" + f.getNbHeure());
            System.out.println("Le taux d'heures est :" + f.getTauxHeure());
            System.out.println("Le salaire brute est :" + f.getSalaireBrut());
            System.out.println("Le salaire net est :" + f.getSalireNet());
        } else {
            System.out.println("Salary record not found.");
        }
    }

    public void findAllFicheSalaires() {
        for (FicheSalaire f : salary.findAllFicheSalaires()) {
            System.out.println("ID: " + f.getFId());
            System.out.println("Nombre d'heures: " + f.getNbHeure());
            System.out.println("Taux d'heures: " + f.getTauxHeure());
            System.out.println("Salaire brut: " + f.getSalaireBrut());
            System.out.println("Salaire net: " + f.getSalireNet());
            System.out.println("-------------------------");
        }
    }

    public void updateFicheSalaire() {
        FicheSalaire f = new FicheSalaire();

        System.out.println("Saisir l'Id de la fiche de salaire");
        f.setFId(scanner.nextInt());

        System.out.println("Saisir le nombre h'heures :");
        f.setNbHeure(scanner.nextInt());

        System.out.println("Saisir le taux h'heures :");
        f.setTauxHeure(scanner.nextDouble());

        System.out.println("Saisir l'Id de l'employe :");
        Employe e = gestion.chercherEmployee(scanner.nextInt());
        f.setE(e);

        salary.modifierFicheSalaire(f);
    }
}

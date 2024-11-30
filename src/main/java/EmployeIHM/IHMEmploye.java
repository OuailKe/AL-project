package EmployeIHM;


import Enteties.Employe;
import Databiz.EmployeData;
import Services.GestionEmployeV1;
import Services.GestionEmployer;
import Services.InterfaceGestion;
import lombok.Data;

import java.util.Scanner;

@Data
public class IHMEmploye {

    static InterfaceGestion gestion = new GestionEmployeV1();
    //static InterfaceGestion gestion = new GestionEmployeV();

    static Scanner scan = new Scanner(System.in);

    public static void sasirEmploye() {
        Employe e = new Employe();
        System.out.println("Saisir l'Id");
        e.setId(scan.nextInt());
        System.out.println("Saisir le nom : ");
        e.setNom(scan.next());
        System.out.println("Saisir le prenom : ");
        e.setPrenom(scan.next());
        System.out.println("Saisir l'adresse ");
        e.setAdresse(scan.next());
        System.out.println("Saisir le numéro tel ");
        e.setNumTel(scan.next());

        gestion.aouterEmployee(e);
    }

    public static void afficherEmploye(String nom){

        Employe e = gestion.chercherEmployee(nom);

        System.out.println("le nom est :" + e.getNom());
        System.out.println("le prenom est :" + e.getPrenom());
        System.out.println("l'adresse est :" + e.getAdresse());
        System.out.println("le num de tel est :" + e.getNumTel());

    }




}

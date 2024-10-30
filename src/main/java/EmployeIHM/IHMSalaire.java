package EmployeIHM;

import Enteties.FicheSalaire;
import Services.GestionEmployer;
import Services.GestionSalaire;
import Services.InterfaceGestion;
import Services.InterfaceSalaire;

import java.util.Scanner;

public class IHMSalaire {

    static InterfaceSalaire gestion = new GestionSalaire();
    static Scanner scan = new Scanner(System.in);

    public static void saisirFicheSalaire(){
        FicheSalaire f = new FicheSalaire();
        System.out.println("Saisir le nombre h'heures :");
        f.setNbHeure(scan.nextInt());

        System.out.println("Saisir le taux h'heures :");
        f.setTauxHeure(scan.nextDouble());

        gestion.ajouterFicheSalaire(f);

        gestion.calculerSalair(f);


    }

    public static void afficherFicheSalaire(int fId){
        FicheSalaire f = gestion.chercherFicheSalaire(fId);

        System.out.println("Le nombre d'heures est :"+ f.getNbHeure());
        System.out.println("Le taux d'heures est :"+ f.getTauxHeure());
        System.out.println("Le salaire brute est :"+ f.getSalaireBrut());
        System.out.println("Le salaire net est :"+ f.getSalireNet());

    }
}

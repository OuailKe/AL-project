package net.javaguides;

import EmployeIHM.IHMEmploye;
import Enteties.Employe;
import Databiz.EmployeData;
import Services.GestionEmployer;
import Services.GestionSalaire;
import Services.InterfaceGestion;
import Services.InterfaceSalaire;

import java.lang.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeData.listEmployee = new ArrayList<>();
        InterfaceGestion gestionEmployer = new GestionEmployer();
        InterfaceSalaire gestionSalaire = new GestionSalaire();

        IHMEmploye.sasirEmploye();
        System.out.println("*********************");

        IHMEmploye.sasirEmploye();
        System.out.println("*********************");
            for (Employe e : EmployeData.listEmployee){
                IHMEmploye.afficherEmploye(e.getNom());
            }


















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
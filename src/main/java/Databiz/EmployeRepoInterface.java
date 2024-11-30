package Databiz;

import Enteties.Employe;

import java.util.ArrayList;
import java.util.List;

public interface EmployeRepoInterface {

    boolean addEmploye(Employe employe);

    boolean deleteEmploye(int id);

    Employe findEmploye(int id);

    Employe findEmploye(String nom);

    ArrayList<Employe> findAllEmployes();

    boolean updateEmploye(Employe employe);
}

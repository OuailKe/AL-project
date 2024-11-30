package Services;
import Databiz.*;
import Databiz.DataBaseConnection;
import Databiz.EmployeRepoInterface;
import Enteties.Employe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionEmployeV1 implements InterfaceGestion {

    EmployeRepoInterface repo = new EmployeRepo();

    @Override
    public Boolean aouterEmployee(Employe e) {

        try {
            return repo.addEmploye(e);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean supprimerEmployee(Employe e) {

        try {
            return repo.deleteEmploye(e.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean aouterEmployee(int id) {
        return null;
    }

    @Override
    public Employe chercherEmployee(int id) {
        try {
            return repo.findEmploye(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Employe chercherEmployee(String nom) {
        try {
            return repo.findEmploye(nom);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean modifierEmployee(Employe employe) {
        try {
            return repo.updateEmploye(employe);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Employe> findAllEmployes() {
        try {
         return repo.findAllEmployes();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
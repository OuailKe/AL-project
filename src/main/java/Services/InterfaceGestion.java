package Services;
import Enteties.*;

import java.util.ArrayList;

public interface InterfaceGestion {

    public Boolean aouterEmployee(Employe e);

    public Boolean supprimerEmployee(Employe e);

    public Boolean aouterEmployee(int id);

    public Employe chercherEmployee(int id);

    public Employe chercherEmployee(String nom);

    public Boolean modifierEmployee(Employe employe);

    public ArrayList<Employe> findAllEmployes();


}





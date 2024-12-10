package Services;

import Enteties.Employe;
import Enteties.FicheSalaire;

import java.util.List;

public interface InterfaceSalaire {

    public boolean calculerSalair(FicheSalaire ficheS);

    public boolean ajouterFicheSalaire(FicheSalaire ficheS);

    public boolean modifierFicheSalaire(FicheSalaire ficheS);

    public boolean supprimerFicheSalaire(FicheSalaire ficheS);

    public FicheSalaire chercherFicheSalaire(int fId);

    public List<FicheSalaire> findAllFicheSalaires();


}

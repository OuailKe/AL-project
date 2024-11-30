package Services;

import Databiz.FicheSalaireRepo;
import Databiz.FicheSalaireRepoInterface;
import Enteties.FicheSalaire;

import java.util.ArrayList;

public class GestionSalaireV1 implements InterfaceSalaire {

    FicheSalaireRepoInterface repo = new FicheSalaireRepo();
    @Override
    public double calculerSalair(FicheSalaire ficheS) {

        double salBrut = ficheS.getNbHeure() * ficheS.getNbHeure();
        ficheS.setSalaireBrut(salBrut);

        double salNet = salBrut * ficheS.getTaxe();
        ficheS.setSalireNet(salNet);

        return salNet;
    }

    @Override
    public boolean ajouterFicheSalaire(FicheSalaire ficheS) {
        try {
            return repo.addFicheSalaire(ficheS);
        } catch (Exception ex) {
            ex.getMessage();
            return false;
        }
    }
    @Override
    public boolean modifierFicheSalaire(FicheSalaire ficheS) {
        try {
            return repo.updateFicheSalaire(ficheS);
        } catch (Exception ex) {
            ex.getMessage();
            return false;
        }
    }

    @Override
    public boolean supprimerFicheSalaire(FicheSalaire ficheS) {
        try {
            return repo.deleteFicheSalaire(ficheS.getFId());
        } catch (Exception ex) {
            ex.getMessage();
            return false;
        }
    }

    @Override
    public FicheSalaire chercherFicheSalaire(int fId) {
        try {
            return repo.findFicheSalaire(fId);
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }
}

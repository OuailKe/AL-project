package Services;

import Databiz.FicheSalaireRepo;
import Databiz.FicheSalaireRepoInterface;
import Enteties.Employe;
import Enteties.FicheSalaire;

import java.util.ArrayList;
import java.util.List;

public class GestionSalaireV1 implements InterfaceSalaire {

    FicheSalaireRepoInterface repo = new FicheSalaireRepo();
    @Override
    public boolean calculerSalair(FicheSalaire ficheS) {

        try {
            double salBrut = ficheS.getNbHeure() * ficheS.getNbHeure();
            ficheS.setSalaireBrut(salBrut);

            double salNet = salBrut - (salBrut * ficheS.getTaxe());
            ficheS.setSalireNet(salNet);

            return true;
        }catch (Exception ex){
            ex.getMessage();
            return false;
        }

    }

    @Override
    public boolean ajouterFicheSalaire(FicheSalaire ficheS) {
        calculerSalair(ficheS);
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

    @Override
    public List<FicheSalaire> findAllFicheSalaires() {

            List<FicheSalaire> ficheSalaires = repo.findAllFicheSalaires();
            for (FicheSalaire f : ficheSalaires) {
                System.out.println("ID: " + f.getFId());
                System.out.println("Nombre d'heures: " + f.getNbHeure());
                System.out.println("Taux d'heures: " + f.getTauxHeure());
                System.out.println("Salaire brut: " + f.getSalaireBrut());
                System.out.println("Salaire net: " + f.getSalireNet());
                System.out.println("-------------------------");
            }
        return ficheSalaires;
    }
}

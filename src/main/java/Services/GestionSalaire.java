package Services;

import Enteties.FicheSalaire;
import Databiz.*;

public class GestionSalaire implements InterfaceSalaire{
    @Override
    public double calculerSalair(FicheSalaire ficheS) {

        double salBrut = ficheS.getNbHeure() * ficheS.getNbHeure();
        ficheS.setSalaireBrut(salBrut);

        double salNet = salBrut * 0.20;
        ficheS.setSalireNet(salNet);

        return salNet;
    }

    @Override
    public boolean ajouterFicheSalaire(FicheSalaire ficheS) {
        boolean result = false;
            try{
                SalaireData.listSalaire.add(ficheS);
                result = true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        return result;
    }

    @Override
    public boolean modifierFicheSalaire(FicheSalaire ficheS) {
        boolean result = false;
            try {
                for (FicheSalaire f : SalaireData.listSalaire){
                    if (f.getFId() == ficheS.getFId()){
                        f.setE(ficheS.getE());
                        f.setNbHeure(ficheS.getNbHeure());
                        f.setTauxHeure(ficheS.getTauxHeure());
                        f.setSalaireBrut(ficheS.getSalaireBrut());
                        result = true;
                    }
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        return result;
    }

    @Override
    public boolean supprimerFicheSalaire(FicheSalaire ficheS) {
        try {
            SalaireData.listSalaire.remove(ficheS);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public FicheSalaire chercherFicheSalaire(int fId) {
        FicheSalaire result = new FicheSalaire();
        for (FicheSalaire f : SalaireData.listSalaire){
            if (f.getFId() == fId){
                result = f;
                break;
            }
        }
        return result;
    }
}

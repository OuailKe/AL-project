package Databiz;

import Enteties.FicheSalaire;

import java.util.List;

public interface FicheSalaireRepoInterface {
    boolean addFicheSalaire(FicheSalaire ficheSalaire);

    boolean deleteFicheSalaire(int id);

    FicheSalaire findFicheSalaire(int id);

    List<FicheSalaire> findAllFicheSalaires();

    boolean updateFicheSalaire(FicheSalaire ficheSalaire);
}

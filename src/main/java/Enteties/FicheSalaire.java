package Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FicheSalaire {

    private int fId;
    
    private Employe e;// one-to-many relation

    private int nbHeure;

    private double tauxHeure;

    private final double taxe = 0.20;

    private double salaireBrut;

    private double salireNet;

    public FicheSalaire(int fId, int nbHeure, double tauxHeure) {
        this.fId = fId;
        this.nbHeure = nbHeure;
        this.tauxHeure = tauxHeure;
    }

    public FicheSalaire(int fId, Employe e, int nbHeure, double tauxHeure) {
        this.fId = fId;
        this.e = e;
        this.nbHeure = nbHeure;
        this.tauxHeure = tauxHeure;
    }
}

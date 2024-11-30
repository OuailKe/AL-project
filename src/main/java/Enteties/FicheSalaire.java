package Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
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
}

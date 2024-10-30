package Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FicheSalaire {

    private int fId;
    
    private Employe e;

    private int nbHeure;

    private double tauxHeure;

    private double salaireBrut;

    private double salireNet;
}

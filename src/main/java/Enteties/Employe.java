package Enteties;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@RequiredArgsConstructor
public class Employe {
    public int Id;
    public String nom;
    public String prenom;
    public String adresse ;
    public String numTel;

    public Employe(String nom, String prenom, String adresse, String numTel) {

        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numTel = numTel;
    }

}

package Enteties;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Employe {
    public int Id;
    public String nom;
    public String prenom;
    public String adresse ;
    public String numTel;

}

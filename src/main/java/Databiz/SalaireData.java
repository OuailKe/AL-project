package Databiz;

import Enteties.FicheSalaire;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class SalaireData {

    public static ArrayList<FicheSalaire> listSalaire;
}

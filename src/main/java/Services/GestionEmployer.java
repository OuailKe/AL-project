package Services;
import Databiz.EmployeData;
import Enteties.*;

public class GestionEmployer implements InterfaceGestion{

    @Override
    public Boolean aouterEmployee(Employe e) {
         boolean result = false;
        try{
            EmployeData.listEmployee.add(e);
            result = true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public Boolean supprimerEmployee(Employe e) {
        boolean result = false;

        try {
            EmployeData.listEmployee.remove(e);
            result = true;

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public Boolean aouterEmployee(int id) {
        return null;
    }

    @Override
    public Employe chercherEmployee(int id) {
        Employe result = new Employe();

        for (Employe e : EmployeData.listEmployee){
            if (e.Id == id){
                result = e;
                break;
            }
        }

        return result;
    }

    @Override
    public Employe chercherEmployee(String nom) {
        Employe result = new Employe();

        for (Employe e : EmployeData.listEmployee){
            if (e.getNom().equals(nom)){
                result = e;
                break;
            }
        }
        return result;
    }

    @Override
    public Boolean modifierEmployee(Employe employe) {
        boolean result = false;

        for (Employe e : EmployeData.listEmployee){
            if (e.Id == employe.Id){
                e.setNom(employe.getNom());
                e.setPrenom(employe.getPrenom());
                e.setAdresse(employe.getAdresse());
                e.setNumTel(employe.getNumTel());
                result = true;
            }
        }

        return result;
    }
}

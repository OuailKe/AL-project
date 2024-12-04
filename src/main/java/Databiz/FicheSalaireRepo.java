package Databiz;

import Enteties.FicheSalaire;
import Enteties.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FicheSalaireRepo implements FicheSalaireRepoInterface {

    @Override
    public boolean addFicheSalaire(FicheSalaire ficheSalaire) {
        String query = "INSERT INTO FicheSalaire (nbHeure, tauxHeure, salaireBrut, salireNet,employeId) VALUES (?,?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ficheSalaire.getNbHeure());
            stmt.setDouble(2, ficheSalaire.getTauxHeure());
            stmt.setDouble(3, ficheSalaire.getSalaireBrut());
            stmt.setDouble(4, ficheSalaire.getSalireNet());
            stmt.setInt(5, ficheSalaire.getE().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFicheSalaire(int id) {
        String query = "DELETE FROM FicheSalaire WHERE fId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FicheSalaire findFicheSalaire(int id) {
        String query = "SELECT fs.*, e.Id AS employeId, e.nom, e.prenom, e.adresse, e.numTel " +
                       "FROM FicheSalaire fs " +
                       "JOIN Employe e ON fs.employeId = e.Id " +
                       "WHERE fs.fId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Employe employe = new Employe(
                    rs.getInt("employeId"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("numTel")
                );
                return new FicheSalaire(
                    rs.getInt("fId"),
                        employe,
                    rs.getInt("nbHeure"),
                    rs.getDouble("tauxHeure"),
                    rs.getDouble("salaireBrut"),
                    rs.getDouble("salireNet")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FicheSalaire> findAllFicheSalaires() {
        List<FicheSalaire> ficheSalaires = new ArrayList<>();
        String query = "SELECT fs.*, e.Id AS employeId, e.nom, e.prenom, e.adresse, e.numTel " +
                       "FROM FicheSalaire fs " +
                       "JOIN Employe e ON fs.employeId = e.Id";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Employe employe = new Employe(
                    rs.getInt("employeId"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("numTel")
                );
                ficheSalaires.add(new FicheSalaire(
                    rs.getInt("fId"),
                        employe,
                    rs.getInt("nbHeure"),
                    rs.getDouble("tauxHeure"),
                    rs.getDouble("salaireBrut"),
                    rs.getDouble("salireNet")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ficheSalaires;
    }

    @Override
    public boolean updateFicheSalaire(FicheSalaire ficheSalaire) {
        String query = "UPDATE FicheSalaire SET nbHeure = ?, tauxHeure = ?, salaireBrut = ?, salireNet = ? WHERE fId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ficheSalaire.getNbHeure());
            stmt.setDouble(2, ficheSalaire.getTauxHeure());
            stmt.setDouble(3, ficheSalaire.getSalaireBrut());
            stmt.setDouble(4, ficheSalaire.getSalireNet());
            stmt.setInt(5, ficheSalaire.getFId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package Databiz;

import Enteties.Employe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeRepo implements EmployeRepoInterface {

    @Override
    public boolean addEmploye(Employe employe) {
        String query = "INSERT INTO Employe (nom, prenom, adresse, numTel) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employe.getNom());
            stmt.setString(2, employe.getPrenom());
            stmt.setString(3, employe.getAdresse());
            stmt.setString(4, employe.getNumTel());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmploye(int id) {
        String query = "DELETE FROM Employe WHERE Id = ?";
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
    public Employe findEmploye(int id) {
        String query = "SELECT * FROM Employe WHERE Id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employe(
                    rs.getInt("Id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("numTel") // Assuming ficheSalaire is not fetched here
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employe findEmploye(String nom) {
        String query = "SELECT * FROM Employe WHERE nom = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employe(
                    rs.getInt("Id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("numTel") // Assuming ficheSalaire is not fetched here
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employe> findAllEmployes() {
        ArrayList<Employe> employes = new ArrayList<>();
        String query = "SELECT * FROM Employe";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employes.add(new Employe(
                    rs.getInt("Id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getString("numTel")// Assuming ficheSalaire is not fetched here
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;
    }

    @Override
    public boolean updateEmploye(Employe employe) {
        String query = "UPDATE Employe SET nom = ?, prenom = ?, adresse = ?, numTel = ? WHERE Id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employe.getNom());
            stmt.setString(2, employe.getPrenom());
            stmt.setString(3, employe.getAdresse());
            stmt.setString(4, employe.getNumTel());
            stmt.setInt(5, employe.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

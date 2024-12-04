package EmployeIHM;

import Enteties.Employe;
import Enteties.FicheSalaire;
import Services.GestionEmployeV1;
import Services.GestionSalaireV1;
import Services.InterfaceGestion;
import Services.InterfaceSalaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHMEmployeV2 extends JFrame {

    private JTextField idField, nomField, prenomField, adresseField, numTelField;
    private JButton submitButton, displayButton,submitButtonSalaire, displayButtonSalaire;
    private JButton gestionEmployeButton, gestionSalaireButton;
    private JButton ajouterEmp, modifierEmp, supprimerEmp, chercherEmp, afficherEmp;
    private JButton ajouterSalaire, modifierSalaire, supprimerSalaire, chercherSalaire, afficherSalaire;
    private JPanel mainMenuPanel, employePanel, salairePanel, employeInitPanel, salaireInitPanel;
    private JTextArea displayArea;
    private InterfaceGestion gestion = new GestionEmployeV1();
    private InterfaceSalaire gestionSalaire = new GestionSalaireV1();
    public IHMEmployeV2() {
        setTitle("Employee Management");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        mainMenuPanel = new JPanel(new GridLayout(3, 3));
        employeInitPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // after clicking on the gestion employe button in menu
        salaireInitPanel = new JPanel(new GridLayout(2, 2, 10, 10));//after clicking on the gestion salaire button in menu//after clicking on the gestion salaire button in menu
        employePanel = new JPanel(new GridBagLayout());
        salairePanel = new JPanel(new GridBagLayout());


        ///////////////////////////////////////////////////////////////////////////////

        gestionEmployeButton = new JButton("Gestion Employe");
        gestionEmployeButton.setBackground(Color.BLUE);
        gestionEmployeButton.setForeground(Color.WHITE);
        gestionEmployeButton.setPreferredSize(new Dimension(100, 50)); // Set preferred size




        gestionSalaireButton = new JButton("Gestion Salaire");
        gestionSalaireButton.setBackground(Color.GREEN);
        gestionSalaireButton.setForeground(Color.WHITE);
        gestionSalaireButton.setPreferredSize(new Dimension(100, 50));

        mainMenuPanel.add(gestionEmployeButton, BorderLayout.NORTH);
        mainMenuPanel.add(gestionSalaireButton, BorderLayout.SOUTH);

        ///////////////////////////////////////////////////////////////////////////////
        add(mainMenuPanel, "Main Menu");
        add(employeInitPanel, "Employe Panel");
        add(salaireInitPanel, "Salaire Panel");

        //redirect after clicking on the gestion employe button or the gestion salaire button
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        gestionEmployeButton.addActionListener(e -> cl.show(getContentPane(), "Employe Panel"));
        gestionSalaireButton.addActionListener(e -> cl.show(getContentPane(), "Salaire Panel"));


        ///////////////////////////////////////////////////////////////////////////////
        // Add buttons to employeInitPanel
        ajouterEmp = new JButton("Ajouter Employe");
       modifierEmp = new JButton("Modifier Employe");
        supprimerEmp = new JButton("Supprimer Employe");
        afficherEmp = new JButton("Lister Employe");

        employeInitPanel.add(ajouterEmp);
       // employeInitPanel.add(modifierEmp);
        employeInitPanel.add(supprimerEmp);
        employeInitPanel.add(afficherEmp);

        add(employePanel, "Ajouter Employe Panel");
        ajouterEmp.addActionListener(e -> cl.show(getContentPane(), "Ajouter Employe Panel"));

                        ///////////////////////////////////////////////////////////////////////////////

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        employePanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        idField = new JTextField(15);
        employePanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        employePanel.add(new JLabel("Nom:"), gbc);
        gbc.gridx = 1;
        nomField = new JTextField(15);
        employePanel.add(nomField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        employePanel.add(new JLabel("Prenom:"), gbc);
        gbc.gridx = 1;
        prenomField = new JTextField(15);
        employePanel.add(prenomField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        employePanel.add(new JLabel("Adresse:"), gbc);
        gbc.gridx = 1;
        adresseField = new JTextField(15);
        employePanel.add(adresseField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        employePanel.add(new JLabel("Num Tel:"), gbc);
        gbc.gridx = 1;
        numTelField = new JTextField(15);
        employePanel.add(numTelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        submitButton = new JButton("Add");
        submitButton.setBackground(Color.ORANGE);
        submitButton.setForeground(Color.BLACK);
        employePanel.add(submitButton, gbc);

        gbc.gridx = 1;
        displayButton = new JButton("Display");
        displayButton.setBackground(Color.CYAN);
        displayButton.setForeground(Color.BLACK);
        employePanel.add(displayButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        displayArea = new JTextArea(5, 20);
        employePanel.add(displayArea, gbc);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        add(salairePanel, "Ajouter Salaire Panel");


        // Add buttons to salaireInitPanel
        ajouterSalaire = new JButton("Ajouter Salaire");
       // modifierSalaire = new JButton("Modifier Salaire");
        supprimerSalaire = new JButton("Supprimer Salaire");
        afficherSalaire = new JButton("Lister Salaire");

        ajouterSalaire.addActionListener(e -> cl.show(getContentPane(), "Ajouter Salaire Panel"));


        salaireInitPanel.add(ajouterSalaire);
        //salaireInitPanel.add(modifierSalaire);
        salaireInitPanel.add(supprimerSalaire);
        salaireInitPanel.add(afficherSalaire);

        GridBagConstraints gbcSalaire = new GridBagConstraints();
        gbcSalaire.insets = new Insets(5, 5, 5, 5);
        gbcSalaire.fill = GridBagConstraints.HORIZONTAL;

//        gbcSalaire.gridx = 0;
//        gbcSalaire.gridy = 0;
//        salairePanel.add(new JLabel("ID:"), gbcSalaire);
//        gbcSalaire.gridx = 1;
//        JTextField idFieldSalaire = new JTextField(15);
//        salairePanel.add(idFieldSalaire, gbcSalaire);

        gbcSalaire.gridx = 0;
        gbcSalaire.gridy = 1;
        salairePanel.add(new JLabel("Nombre d'heure:"), gbcSalaire);
        gbcSalaire.gridx = 1;
        JTextField nbhHeure = new JTextField(15);
        salairePanel.add(nbhHeure, gbcSalaire);

        gbcSalaire.gridx = 0;
        gbcSalaire.gridy = 2;
        salairePanel.add(new JLabel("Taux d'heure:"), gbcSalaire);
        gbcSalaire.gridx = 1;
        JTextField tauxHeure = new JTextField(15);
        salairePanel.add(tauxHeure, gbcSalaire);

        gbcSalaire.gridx = 0;
        gbcSalaire.gridy = 3;
        salairePanel.add(new JLabel("Id de l'employe:"), gbcSalaire);
        gbcSalaire.gridx = 1;
        JTextField idEmploye = new JTextField(15);
        salairePanel.add(idEmploye, gbcSalaire);

//        gbcSalaire.gridx = 0;
//        gbcSalaire.gridy = 4;
//        salairePanel.add(new JLabel("Num Tel:"), gbcSalaire);
//        gbcSalaire.gridx = 1;
//        JTextField numTelFieldSalaire = new JTextField(15);
//        salairePanel.add(numTelFieldSalaire, gbcSalaire);

        gbcSalaire.gridx = 0;
        gbcSalaire.gridy = 5;
        JButton submitButtonSalaire = new JButton("Add");
        submitButtonSalaire.setBackground(Color.ORANGE);
        submitButtonSalaire.setForeground(Color.BLACK);
        salairePanel.add(submitButtonSalaire, gbcSalaire);

        gbcSalaire.gridx = 1;
        JButton displayButtonSalaire = new JButton("Display");
        displayButtonSalaire.setBackground(Color.CYAN);
        displayButtonSalaire.setForeground(Color.BLACK);
        salairePanel.add(displayButtonSalaire, gbcSalaire);

//        gbcSalaire.gridx = 0;
//        gbcSalaire.gridy = 6;
//        gbcSalaire.gridwidth = 2;
//        JTextArea displayAreaSalaire = new JTextArea(5, 20);
//        salairePanel.add(displayAreaSalaire, gbcSalaire);


        // updating code parts
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Modify Employe

// Create a new panel for modifying an employee
        JPanel modifyEmployePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcModify = new GridBagConstraints();
        gbcModify.insets = new Insets(5, 5, 5, 5);
        gbcModify.fill = GridBagConstraints.HORIZONTAL;

// Add components to the modifyEmployePanel
        gbcModify.gridx = 0;
        gbcModify.gridy = 0;
        modifyEmployePanel.add(new JLabel("Enter Employee ID:"), gbcModify);
        gbcModify.gridx = 1;
        JTextField idFieldModify = new JTextField(15);
        modifyEmployePanel.add(idFieldModify, gbcModify);

        gbcModify.gridx = 0;
        gbcModify.gridy = 1;
        modifyEmployePanel.add(new JLabel("Nom:"), gbcModify);
        gbcModify.gridx = 1;
        JTextField nomFieldModify = new JTextField(15);
        modifyEmployePanel.add(nomFieldModify, gbcModify);

        gbcModify.gridx = 0;
        gbcModify.gridy = 2;
        modifyEmployePanel.add(new JLabel("Prenom:"), gbcModify);
        gbcModify.gridx = 1;
        JTextField prenomFieldModify = new JTextField(15);
        modifyEmployePanel.add(prenomFieldModify, gbcModify);

        gbcModify.gridx = 0;
        gbcModify.gridy = 3;
        modifyEmployePanel.add(new JLabel("Adresse:"), gbcModify);
        gbcModify.gridx = 1;
        JTextField adresseFieldModify = new JTextField(15);
        modifyEmployePanel.add(adresseFieldModify, gbcModify);

        gbcModify.gridx = 0;
        gbcModify.gridy = 4;
        modifyEmployePanel.add(new JLabel("Num Tel:"), gbcModify);
        gbcModify.gridx = 1;
        JTextField numTelFieldModify = new JTextField(15);
        modifyEmployePanel.add(numTelFieldModify, gbcModify);

        gbcModify.gridx = 0;
        gbcModify.gridy = 5;
        JButton fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.ORANGE);
        fetchButton.setForeground(Color.BLACK);
        modifyEmployePanel.add(fetchButton, gbcModify);

        gbcModify.gridx = 1;
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Color.CYAN);
        saveButton.setForeground(Color.BLACK);
        modifyEmployePanel.add(saveButton, gbcModify);

// Add the modifyEmployePanel to the card layout
        add(modifyEmployePanel, "Modify Employe Panel");

// Action listener for the fetch button
        fetchButton.addActionListener(e -> {
            int id = Integer.parseInt(idFieldModify.getText());
            Employe employe = gestion.chercherEmployee(id);
            if (employe != null) {
                nomFieldModify.setText(employe.getNom());
                prenomFieldModify.setText(employe.getPrenom());
                adresseFieldModify.setText(employe.getAdresse());
                numTelFieldModify.setText(employe.getNumTel());
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found!");
            }
        });

// Action listener for the save button
        saveButton.addActionListener(e -> {
            int id = Integer.parseInt(idFieldModify.getText());
            Employe employe = new Employe(
                    id,
                    nomFieldModify.getText(),
                    prenomFieldModify.getText(),
                    adresseFieldModify.getText(),
                    numTelFieldModify.getText()
            );
            gestion.modifierEmployee(employe);
            JOptionPane.showMessageDialog(null, "Employee details updated successfully!");
        });

// Add a button to navigate to the modifyEmployePanel
        JButton modifyEmpButton = new JButton("Modify Employe");
        modifyEmpButton.setBackground(Color.YELLOW);
        modifyEmpButton.setForeground(Color.BLACK);
        employeInitPanel.add(modifyEmpButton);
        modifyEmpButton.addActionListener(e -> cl.show(getContentPane(), "Modify Employe Panel"));



        // modify ficheSalaire
      // Create a new panel for modifying a FicheSalaire
        JPanel modifyFicheSalairePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcModifyFiche = new GridBagConstraints();
        gbcModifyFiche.insets = new Insets(5, 5, 5, 5);
        gbcModifyFiche.fill = GridBagConstraints.HORIZONTAL;

// Add components to the modifyFicheSalairePanel
        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 0;
        modifyFicheSalairePanel.add(new JLabel("Enter FicheSalaire ID:"), gbcModifyFiche);
        gbcModifyFiche.gridx = 1;
        JTextField idFieldModifyFiche = new JTextField(15);
        modifyFicheSalairePanel.add(idFieldModifyFiche, gbcModifyFiche);

        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 1;
        modifyFicheSalairePanel.add(new JLabel("Nombre d'heure:"), gbcModifyFiche);
        gbcModifyFiche.gridx = 1;
        JTextField nbHeureFieldModify = new JTextField(15);
        modifyFicheSalairePanel.add(nbHeureFieldModify, gbcModifyFiche);

        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 2;
        modifyFicheSalairePanel.add(new JLabel("Taux d'heure:"), gbcModifyFiche);
        gbcModifyFiche.gridx = 1;
        JTextField tauxHeureFieldModify = new JTextField(15);
        modifyFicheSalairePanel.add(tauxHeureFieldModify, gbcModifyFiche);

        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 3;
        modifyFicheSalairePanel.add(new JLabel("Salaire Brut:"), gbcModifyFiche);
        gbcModifyFiche.gridx = 1;
        JTextField salaireBrutFieldModify = new JTextField(15);
        modifyFicheSalairePanel.add(salaireBrutFieldModify, gbcModifyFiche);

        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 4;
        modifyFicheSalairePanel.add(new JLabel("Salaire Net:"), gbcModifyFiche);
        gbcModifyFiche.gridx = 1;
        JTextField salaireNetFieldModify = new JTextField(15);
        modifyFicheSalairePanel.add(salaireNetFieldModify, gbcModifyFiche);

        gbcModifyFiche.gridx = 0;
        gbcModifyFiche.gridy = 5;
        JButton fetchButtonFiche = new JButton("Fetch");
        fetchButtonFiche.setBackground(Color.ORANGE);
        fetchButtonFiche.setForeground(Color.BLACK);
        modifyFicheSalairePanel.add(fetchButtonFiche, gbcModifyFiche);

        gbcModifyFiche.gridx = 1;
        JButton saveButtonFiche = new JButton("Save");
        saveButtonFiche.setBackground(Color.CYAN);
        saveButtonFiche.setForeground(Color.BLACK);
        modifyFicheSalairePanel.add(saveButtonFiche, gbcModifyFiche);

// Add the modifyFicheSalairePanel to the card layout
        add(modifyFicheSalairePanel, "Modify FicheSalaire Panel");

// Action listener for the fetch button
        fetchButtonFiche.addActionListener(e -> {
            int id = Integer.parseInt(idFieldModifyFiche.getText());
            FicheSalaire ficheSalaire = gestionSalaire.chercherFicheSalaire(id);
            if (ficheSalaire != null) {
                nbHeureFieldModify.setText(String.valueOf(ficheSalaire.getNbHeure()));
                tauxHeureFieldModify.setText(String.valueOf(ficheSalaire.getTauxHeure()));
                salaireBrutFieldModify.setText(String.valueOf(ficheSalaire.getSalaireBrut()));
                salaireNetFieldModify.setText(String.valueOf(ficheSalaire.getSalireNet()));
            } else {
                JOptionPane.showMessageDialog(null, "FicheSalaire not found!");
            }
        });

// Action listener for the save button
        saveButtonFiche.addActionListener(e -> {
            int id = Integer.parseInt(idFieldModifyFiche.getText());
            FicheSalaire ficheSalaire = new FicheSalaire(
                    id,
                    null, // Assuming employe is not modified here
                    Integer.parseInt(nbHeureFieldModify.getText()),
                    Double.parseDouble(tauxHeureFieldModify.getText()),
                    Double.parseDouble(salaireBrutFieldModify.getText()),
                    Double.parseDouble(salaireNetFieldModify.getText())
            );
            gestionSalaire.modifierFicheSalaire(ficheSalaire);
            JOptionPane.showMessageDialog(null, "FicheSalaire details updated successfully!");
        });

// Add a button to navigate to the modifyFicheSalairePanel
        JButton modifyFicheButton = new JButton("Modify FicheSalaire");
        modifyFicheButton.setBackground(Color.YELLOW);
        modifyFicheButton.setForeground(Color.BLACK);
        salaireInitPanel.add(modifyFicheButton);
        modifyFicheButton.addActionListener(e -> cl.show(getContentPane(), "Modify FicheSalaire Panel"));

// ///////////////////////////////////////////////////////////////////////////////////////////////////////////

// Back button for employePanel
        JButton backButtonEmploye = new JButton("Back");
        backButtonEmploye.setBackground(Color.RED);
        backButtonEmploye.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        employeInitPanel.add(backButtonEmploye, gbc);

// Back button for salairePanel
        JButton backButtonSalaire = new JButton("Back");
        backButtonSalaire.setBackground(Color.RED);
        backButtonSalaire.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        salaireInitPanel.add(backButtonSalaire, gbc);


        // Back button to employePanel
        JButton backButtonToEmploye = new JButton("Back");
        backButtonEmploye.setBackground(Color.RED);
        backButtonEmploye.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        employePanel.add(backButtonToEmploye, gbc);

        // Back button o salaryPanel
        JButton backButtonToSalaire = new JButton("Back");
        backButtonEmploye.setBackground(Color.RED);
        backButtonEmploye.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        salairePanel.add(backButtonToSalaire, gbc);

        // Back button for employePanel2
        JButton backButtonToEmploye2 = new JButton("Back");
        backButtonEmploye.setBackground(Color.RED);
        backButtonEmploye.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        modifyEmployePanel.add(backButtonToEmploye2, gbc);

        // Back button for salaryPanel2
        JButton backButtonToSalaire2 = new JButton("Back");
        backButtonEmploye.setBackground(Color.RED);
        backButtonEmploye.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        modifyFicheSalairePanel.add(backButtonToSalaire2, gbc);


// Action listeners for back buttons
        backButtonEmploye.addActionListener(e -> cl.show(getContentPane(), "Main Menu"));
        backButtonSalaire.addActionListener(e -> cl.show(getContentPane(), "Main Menu"));
        backButtonToEmploye.addActionListener(e -> cl.show(getContentPane(), "Employe Panel"));
        backButtonToSalaire.addActionListener(e -> cl.show(getContentPane(), "Salaire Panel"));
        backButtonToEmploye2.addActionListener(e -> cl.show(getContentPane(), "Employe Panel"));
        backButtonToSalaire2.addActionListener(e -> cl.show(getContentPane(), "Employe Panel"));




///////////////////////////////////////////////////////////////////////////////////////////////////////////


        // to the add employe
        submitButton.addActionListener(e -> {
            Employe employe = new Employe(
                    Integer.parseInt(idField.getText()),
                    nomField.getText(),
                    prenomField.getText(),
                    adresseField.getText(),
                    numTelField.getText()
            );
            gestion.aouterEmployee(employe);
            JOptionPane.showMessageDialog(null, "Employee added successfully!");
        });
        // to add ficheSalaire
        submitButtonSalaire.addActionListener(e -> {
            Employe employe = gestion.chercherEmployee(Integer.parseInt(idEmploye.getText()));
            if (employe != null) {
                FicheSalaire ficheSalaire = new FicheSalaire(
                        0, // fId, assuming it's auto-generated
                        employe,
                        Integer.parseInt(nbhHeure.getText()),
                        Double.parseDouble(tauxHeure.getText()),
                        0.0, // salaireBrut, will be calculated
                        0.0  // salireNet, will be calculated
                );
                gestionSalaire.ajouterFicheSalaire(ficheSalaire);
                JOptionPane.showMessageDialog(null, "FicheSalaire added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found!");
            }
        });

        displayButton.addActionListener(e -> {
            String nom = nomField.getText();
            Employe employe = IHMEmploye.gestion.chercherEmployee(nom);
            if (employe != null) {
                displayArea.setText("Nom: " + employe.getNom() + "\n" +
                        "Prenom: " + employe.getPrenom() + "\n" +
                        "Adresse: " + employe.getAdresse() + "\n" +
                        "Num Tel: " + employe.getNumTel());
            } else {
                displayArea.setText("Employee not found!");
            }
        });

        
    }

}
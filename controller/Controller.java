package controller;

import view.*;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Controller {
    private Homepage homepage = null;
    private ResultSet queryResult = null;

    public Controller(Homepage newHomepage) {
        this.homepage = newHomepage;
    }

    /*
     * Initialize all the events from the home window
     */
    public void initializeHomeframeWindowEvents() {
        initializeWindowClosingEvent();
        initializeButton1PressingEvent();
        initializeButton2PressingEvent();
        initializeButton3PressingEvent();
        initializeButton4PressingEvent();
    }

    /*
     * Set up the event handler that shows the small alert
     * whenever you wish to close the home window.
     */
    private void initializeWindowClosingEvent() {
        homepage.getHomeframe().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                    homepage.getHomeframe(), 
                    "Are you sure you want to exit?",
                    "Close Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    homepage.getHomeframe().setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE);
                } else {
                    homepage.getHomeframe().setDefaultCloseOperation(
                        JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    /*
     * Initialize Button1 (from the home page) 
     * pressing event (to show the 1st query).
     */
    private void initializeButton1PressingEvent() {    
        homepage.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String tableTitle = "1st Report";
                String[] tableHeader = {"Leader ID", "First Name", 
                    "Last Name", "City"};
                String[][] tableData = fillTableValues(1);
                Reports report1 = new Reports(tableData, tableHeader,
                                              tableTitle);
                report1.initialize();
            }
          });
    }

    /*
     * Initialize Button2 (from the home page) 
     * pressing event (to show the 2nd query).
     */
    private void initializeButton2PressingEvent() {    
        homepage.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String tableTitle = "2nd Report";
                String[] tableHeader = {"Project ID", "Construction Company", 
                    "Number of Rooms", "City"};
                String[][] tableData = fillTableValues(2);
                Reports report1 = new Reports(tableData, tableHeader,
                                              tableTitle);
                report1.initialize();
            }
          });
    }

    /*
     * Initialize Button3 (from the home page) 
     * pressing event (to show the 3rd query).
     */
    private void initializeButton3PressingEvent() {    
        homepage.getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String tableTitle = "3rd Report";
                String[] tableHeader = {"Purchase ID", "Construction Company", 
                    "Associated Bank"};
                String[][] tableData = fillTableValues(3);
                Reports report1 = new Reports(tableData, tableHeader,
                                              tableTitle);
                report1.initialize();
            }
          });
    }

    /*
     * Initialize Button4 (from the home page)
     * pressing event (to show the instructions).
     */
    private void initializeButton4PressingEvent() {
        String instructions = "Click on each button (1st Report, "
                             + "2nd report and 3rd report) to "
                             + "see the results of each query.\n"
                             + "Developed by: Carlos Murcia.\n"
                             + "App icon retrieved from: "
                             + "https://www.flaticon.com/free-icons/query";

        homepage.getButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(homepage.getHomeframe(),
                                              instructions);
            }
          });
    }

    private String[][] fillTableValues(int queryOption) {
        if (queryOption == 1) {
            String[] columnIDs = {"ID_Lider", "Nombre", 
                "Primer_Apellido", "Ciudad_Residencia"};
            String[][] tableData = new String[50][4];
            int numberOfColumns = columnIDs.length;
            int i = 0;
            try {
                queryResult = Queries.executeQuery(queryOption);
                while (queryResult.next()) {
                    for (int j = 0; j < numberOfColumns; j++) {                       
                        tableData[i][j] = queryResult.getString(
                            columnIDs[j]);
                    }
                    i++;
                }
                return tableData;
            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }
        }
        if (queryOption == 2) {
            String[] columnIDs = {"ID_Proyecto", "Constructora", 
                "Numero_Habitaciones", "Ciudad"};
            String[][] tableData = new String[13][4];
            int numberOfColumns = columnIDs.length;
            int i = 0;
            try {
                queryResult = Queries.executeQuery(queryOption);
                while (queryResult.next()) {
                    for (int j = 0; j < numberOfColumns; j++) {                       
                        tableData[i][j] = queryResult.getString(
                            columnIDs[j]);
                    }
                    i++;
                }
                return tableData;
            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }
        }
        if (queryOption == 3) {
            String[] columnIDs = {"ID_Compra", "Constructora", 
                "Banco_Vinculado"};
            String[][] tableData = new String[20][3];
            int numberOfColumns = columnIDs.length;
            int i = 0;
            try {
                queryResult = Queries.executeQuery(queryOption);
                while (queryResult.next()) {
                    for (int j = 0; j < numberOfColumns; j++) {                       
                        tableData[i][j] = queryResult.getString(
                            columnIDs[j]);
                    }
                    i++;
                }
                return tableData;
            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
}
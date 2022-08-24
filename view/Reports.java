package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Reports {
    // Constants (for size and location of elements)
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_ICON = "resources/icon.png";

    // Elements declaration (frames, buttons, labels...)
    private JFrame reportFrame = null;
    private JPanel queryContainer = null;
    private JTable query = null;
    private String queryTitle = null;
    private Image frameIcon = null;

    /*
     * Initialize a new report with the date sent from the controller
     */
    public Reports(String[][] newData, String[] newHeader,
                   String newTitle) {
        reportFrame = new JFrame();
        queryContainer = new JPanel();
        query = new JTable(newData, newHeader);
        queryTitle = newTitle;
        frameIcon = Toolkit.getDefaultToolkit().getImage(WINDOW_ICON);
    }

     /*
     * Initialize the window and all its components.
     */
    public void initialize() {
        initializeTable();
        initializeWindow();
    }

    /*
     * Initialize the window that will contain all inside elements.
     */
    private void initializeWindow() {
        reportFrame.setTitle(queryTitle);
        reportFrame.setIconImage(frameIcon);
        reportFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.add(queryContainer);        
        reportFrame.setResizable(false);
        reportFrame.setVisible(true);
    }

    /*
     * Initialize the table which will show the results of the
     * 1st report.
    */
    private void initializeTable() {
        query.getTableHeader().setFont(new Font(
            "Tahoma", Font.BOLD, 12));
        query.setFont(new Font("Tahoma", Font.PLAIN, 12));
        query.setBackground(new Color(59, 89, 182));
        query.setForeground(Color.WHITE);
        queryContainer.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), queryTitle,
                TitledBorder.CENTER, TitledBorder.TOP));
        queryContainer.add(new JScrollPane(query));
    }
}
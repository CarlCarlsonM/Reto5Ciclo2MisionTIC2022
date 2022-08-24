package view;

import javax.swing.*;
import java.awt.*;

public class Homepage {
    // Window constants
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private final String WINDOW_TITLE = "Homepage - Reto 5";
    private final String WINDOW_COVER = "resources/cover.jpg";
    private final String WINDOW_ICON = "resources/icon.png";

    // Button contstants
    private final int BUTTON_WIDTH = 120;
    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_POS_X = 50;
    private final int BUTTON_POS_Y = 500;
    private final String BUTTON_1_TEXT = "1st Report";
    private final String BUTTON_2_TEXT = "2nd Report";
    private final String BUTTON_3_TEXT = "3rd Report";
    private final String BUTTON_4_TEXT = "Instructions";

    // Elements declaration (frames, buttons, labels...)
    private JFrame homeframe = null;
    private JLabel coverImageLabel = null;
    private JButton button1 = null;
    private JButton button2 = null;
    private JButton button3 = null;
    private JButton button4 = null;
    private Image frameIcon = null;

    /*
     * Initialize the window and all its components.
     */
    public Homepage() {
        homeframe = new JFrame();
        coverImageLabel = new JLabel(new ImageIcon(WINDOW_COVER));
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        frameIcon = Toolkit.getDefaultToolkit().getImage(WINDOW_ICON);

        initializeWindow();
        initializeCoverImage();
        initializeButton1();
        initializeButton2();
        initializeButton3();
        initializeButton4();
    }

    // Homeframe getter
    public JFrame getHomeframe() {
        return homeframe;
    }

    // Button 1 getter
    public JButton getButton1() {
        return button1;
    }

    // Button 2 getter
    public JButton getButton2() {
        return button2;
    }

    // Button 3 getter
    public JButton getButton3() {
        return button3;
    }

    // Button 4 getter
    public JButton getButton4() {
        return button4;
    }

    /*
     * Initialize the window that will contain all inside elements.
     */
    private void initializeWindow() {
        homeframe.add(button1);
        homeframe.add(button2);
        homeframe.add(button3);
        homeframe.add(button4);
        homeframe.add(coverImageLabel);
        homeframe.setTitle(WINDOW_TITLE);
        homeframe.setIconImage(frameIcon);
        homeframe.setResizable(false);
        homeframe.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        homeframe.setLocationRelativeTo(null);
        homeframe.setVisible(true);
    }

    /*
     * Initialize the cover image
     */
    private void initializeCoverImage() {
        coverImageLabel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT - 150);
        coverImageLabel.setVerticalAlignment(JLabel.TOP);
    }

    /*
     * Initialize Button1 (for the 1st query)
     */
    private void initializeButton1() {
        button1.setText(BUTTON_1_TEXT);
        button1.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button1.setLocation(BUTTON_POS_X, BUTTON_POS_Y);
        button1.setVisible(true);
        button1.setBackground(new Color(59, 89, 182));
        button1.setForeground(Color.WHITE);
        button1.setFocusPainted(false);
        button1.setFont(
            new Font("Tahoma", Font.BOLD, 12));
    }

    /*
     * Initialize Button2 (for the 2nd query)
     */
    private void initializeButton2() {
        button2.setText(BUTTON_2_TEXT);
        button2.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button2.setLocation(BUTTON_POS_X + 120, BUTTON_POS_Y);
        button2.setVisible(true);
        button2.setBackground(new Color(59, 89, 182));
        button2.setForeground(Color.WHITE);
        button2.setFocusPainted(false);
        button2.setFont(
            new Font("Tahoma", Font.BOLD, 12));
    }

    /*
     * Initialize Button3 (for the 3rd query)
     */
    private void initializeButton3() {
        button3.setText(BUTTON_3_TEXT);
        button3.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button3.setLocation(BUTTON_POS_X + 240, BUTTON_POS_Y);
        button3.setVisible(true);
        button3.setBackground(new Color(59, 89, 182));
        button3.setForeground(Color.WHITE);
        button3.setFocusPainted(false);
        button3.setFont(
            new Font("Tahoma", Font.BOLD, 12));
    }

    /*
     * Initialize Button4 (for the 4th query)
     */
    private void initializeButton4() {
        button4.setText(BUTTON_4_TEXT);
        button4.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button4.setLocation(BUTTON_POS_X + 360, BUTTON_POS_Y);
        button4.setVisible(true);
        button4.setBackground(new Color(59, 89, 182));
        button4.setForeground(Color.WHITE);
        button4.setFocusPainted(false);
        button4.setFont(
            new Font("Tahoma", Font.BOLD, 12));
    }
}
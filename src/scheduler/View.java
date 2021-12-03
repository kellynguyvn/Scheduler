package scheduler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.IOException;


public class View {
    // view uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel justBreathe;
    private JButton begin;

    /**
     * View Constructor
     *
     * @param title title used for the frame
     */
    public View(String title) throws IOException{
        // Create the principal frame
        Color Background = new Color(38, 62, 91);
        JFrame frame = new JFrame("Tutor Scheduler");
        BufferedImage myImage = ImageIO.read(new File("src/scheduler/pictures/mainPage.png"));
        frame.setContentPane(new ImagePanel(myImage));
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel runner = new JPanel(new FlowLayout(FlowLayout.LEFT));
        runner.setOpaque(false);
        BufferedImage hi = ImageIO.read(new File("src/scheduler/pictures/logo.png"));
        JButton pic = new JButton(new ImageIcon(hi));
        pic.setMargin(new Insets(0, 0, 0, 0));
        pic.setBackground(null);
        pic.setBorder(null);
        JLabel name = new JLabel("tutor scheduler", SwingConstants.CENTER);
        name.setFont(new Font("league spartan", Font.BOLD, 30));
        name.setForeground(Color.white);
        runner.add(pic);
        runner.add(name);
        runner.setMaximumSize(new Dimension(2000, 300));


        JPanel space = new JPanel();
        JLabel Tutor_Scheduler = new JLabel("Welcome Back!", SwingConstants.CENTER);
        Tutor_Scheduler.setFont(new Font("League Spartan", Font.BOLD, 80));
        Tutor_Scheduler.setForeground(Color.white);
        space.setOpaque(false);
        space.setMaximumSize(new Dimension(2000, 110));
        space.add(Tutor_Scheduler);



        JPanel combo = new JPanel();
        JLabel User_Type = new JLabel("I am scheduling as a ", SwingConstants.CENTER);
        User_Type.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        User_Type.setForeground(Color.white);
        String[] user={"student","tutor", "manager" };
        JComboBox comboBox = new JComboBox(user);
        comboBox.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        comboBox.setMaximumSize(new Dimension(400, 40));
        comboBox.setForeground(Color.getColor(null, Background));
        BufferedImage i = ImageIO.read(new File("src/scheduler/pictures/go.png"));
        JButton go = new JButton(new ImageIcon(i));
        go.setMargin(new Insets(0, 0, 0, 0));
        go.setBackground(null);
        go.setBorder(null);
        combo.setMaximumSize(new Dimension(2000, 100));
        combo.setOpaque(false);
        combo.add(User_Type);
        combo.add(comboBox);
        combo.add(go);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(2000, 1000);
        frame.setVisible(true);
        frame.add(runner);
        frame.add(space);
        frame.add(combo);


        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("student")){
                    try {
                        new StudentView();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(comboBox.getSelectedItem().equals("tutor")){
                    try {
                        new TutorView();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(comboBox.getSelectedItem().equals("manager")){
                    try {
                        new ManagerView();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }








}



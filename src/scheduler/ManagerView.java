package scheduler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManagerView {

    //private static void printResultSetFromTutor (ResultSet rs) throws SQLException {
    //
    //		while (rs.next()) {
    //
    //			int tutorID = rs.getInt("tutorID");
    //			String firstName = rs.getString("firstName");
    //			String lastName = rs.getString("lastName");
    //			String email = rs.getString("email");
    //
    //			System.out.println("tutorID: " + tutorID + "| name: " + firstName + " " + lastName + "| email: " + email);
    //
    //		}
    //
    //	}
    //
    //	private static void printResultSetFromSession (ResultSet rs) throws SQLException {
    //
    //		while (rs.next()) {
    //
    //			int sessionID = rs.getInt("sessionID");
    //			int studentID = rs.getInt("studentID");
    //			int tutorID = rs.getInt("tutorID");
    //			int assignmentID = rs.getInt("assignmentID");
    //			int duration = rs.getInt("duration");
    //			String startTime = rs.getString("startTime");
    //
    //			System.out.println("sessionID: " + sessionID + "| studentID: " + studentID + "| tutorID: " + tutorID
    //					 + "| assignmentID: " + assignmentID + "| duration: " + duration + "| startTime: " + startTime);
    //
    //		}
    //
    public ManagerView() throws IOException{
        JFrame f;
        Color Background = new Color(38, 47, 65);
        f =new JFrame("Welcome Manager");
        f.getContentPane().setBackground(Color.getColor(null, Background));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        JPanel space = new JPanel();
        JLabel Tutor_Scheduler = new JLabel("What would you like to do?", SwingConstants.CENTER);
        Tutor_Scheduler.setFont(new Font("League Spartan", Font.BOLD, 50));
        Tutor_Scheduler.setForeground(Color.white);
        space.setOpaque(false);
        space.setMaximumSize(new Dimension(2000, 100));
        space.add(Tutor_Scheduler);

        JPanel combo = new JPanel();
        String[] user={"","view tutors", "view session" };
        JComboBox comboBox = new JComboBox(user);
        comboBox.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        comboBox.setMaximumSize(new Dimension(400, 100));
        comboBox.setForeground(Color.getColor(null, Background));
        BufferedImage i = ImageIO.read(new File("src/scheduler/pictures/go.png"));
        JButton go = new JButton(new ImageIcon(i));
        go.setMargin(new Insets(0, 0, 0, 0));
        go.setBackground(null);
        go.setBorder(null);
        combo.setMaximumSize(new Dimension(2000, 100));
        combo.setOpaque(false);
        combo.add(comboBox);
        combo.add(go);

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
        runner.setMaximumSize(new Dimension(2000, 70));



        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(2000, 1000);
        f.setVisible(true);
        f.add(runner);
        f.add(space);
        f.add(combo);

        pic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new View("Tutor Scheduler");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("view tutors")){
                    try {
                        new ViewTutors();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                else if(comboBox.getSelectedItem().equals("view session")){
                    try {
                        new ViewSession();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

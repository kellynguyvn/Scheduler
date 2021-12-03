package scheduler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewSessions {
    public ViewSessions() throws IOException {
        JFrame f;

        Color Background = new Color(0, 100, 103);
        Color accent = new Color(156, 196, 164);
        f =new JFrame("Welcome Student");
        f.setSize(2000, 1000);
        f.getContentPane().setBackground(Color.getColor(null, Background));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

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

        //1 = register, 2 = find tutor, 3 = request tutor, 4 = view upcoming sessions, ? = quit with invalid value
        JPanel space = new JPanel();
        JLabel Tutor_Scheduler = new JLabel("What would you like to do?", SwingConstants.CENTER);
        Tutor_Scheduler.setFont(new Font("League Spartan", Font.BOLD, 50));
        Tutor_Scheduler.setForeground(Color.white);
        space.setOpaque(false);
        space.setMaximumSize(new Dimension(2000, 100));
        space.add(Tutor_Scheduler);

        JPanel combo = new JPanel();
        String[] user={"","register","request tutor", "view upcoming sessions" };
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

        JPanel register = new JPanel();
        register.setLayout(new GridLayout(0, 1));
        register.setMaximumSize(new Dimension(450, 100));
        register.setBorder(null);
        register.setBackground(Color.white);

        JPanel margin = new JPanel();
        margin.setBackground(Color.getColor(null, accent));
        margin.setMaximumSize(new Dimension(1200, 30));
        JLabel enter = new JLabel("Upcoming Sessions:");
        enter.setFont(new Font("League Spartan", Font.BOLD, 37));
        enter.setForeground(Color.getColor(null, Background));
        margin.add(enter);

        JPanel a= new JPanel();
        a.setOpaque(false);
        a.setMaximumSize(new Dimension(1200, 40));
        JLabel first = new JLabel("  Student ID: ");
        first.setForeground(Color.getColor(null, Background));
        first.setFont(new Font("Avenir Next", Font.BOLD, 24));
        JTextField firstName = new JTextField();
        firstName.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        firstName.setText("Enter Student ID");
        BufferedImage bb = ImageIO.read(new File("src/scheduler/pictures/go.png"));
        JButton bs = new JButton(new ImageIcon(bb));
        bs.setMargin(new Insets(0, 0, 0, 0));
        bs.setBackground(null);
        bs.setBorder(null);
        a.add(first);
        a.add(firstName);
        a.add(bs);

        register.add(margin);
        register.add(a);


        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(2000, 1000);
        f.setVisible(true);
        f.add(runner);
        f.add(space);
        f.add(combo);
        f.add(register);



        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("register")){
                    try {
                        new RegisterView();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                else if(comboBox.getSelectedItem().equals("request tutor")){
                    try {
                        new RequestTutorView();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                else if(comboBox.getSelectedItem().equals("view upcoming sessions")){
                    try {
                        new ViewSessions();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });



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
    }
}

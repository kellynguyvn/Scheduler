package scheduler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tutor_Register {
    public Tutor_Register() throws IOException {
        JFrame f;

        Color Background = new Color(36, 62, 91);
        Color Accent = new Color(63, 77, 108);
        f =new JFrame("Welcome Tutor");
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
        String[] user={"","register", "view upcoming sessions" };
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

        //case 1:
        //                    sql = "CALL Student_register (?, ?, ?, ?, ?)";
        //                    preparedStatement = conn.prepareStatement(sql);
        //
        //                    System.out.println("First name: ");
        //                    String firstName = sc.nextLine();
        //                    preparedStatement.setString(1, firstName);
        //
        //                    System.out.println("Last name: ");
        //                    String lastName = sc.nextLine();
        //                    preparedStatement.setString(2, lastName);
        //
        //                    System.out.println("Email: ");
        //                    String email = sc.nextLine();
        //                    preparedStatement.setString(3, email);
        //
        //                    System.out.println("Grade: ");
        //                    int grade = Integer.valueOf(sc.nextLine());
        //                    preparedStatement.setInt(4, grade);
        //
        //                    System.out.println("Major: ");
        //                    String major = sc.nextLine();
        //                    preparedStatement.setString(5, major);
        //
        //                    preparedStatement.execute();
        //                    break;

        JPanel register = new JPanel();
        register.setLayout(new GridLayout(0, 1));
        register.setMaximumSize(new Dimension(450, 500));
        register.setBorder(null);
        register.setBackground(Color.white);

        JPanel margin = new JPanel();
        margin.setBackground(Color.getColor(null, Accent));
        margin.setMaximumSize(new Dimension(1200, 30));
        JLabel enter = new JLabel("  Register Information: ");
        enter.setFont(new Font("League Spartan", Font.BOLD, 37));
        enter.setForeground(Color.getColor(null, Background));
        margin.add(enter);

        JPanel a= new JPanel(new FlowLayout(FlowLayout.LEFT));
        a.setOpaque(false);
        a.setMaximumSize(new Dimension(1200, 40));
        JLabel first = new JLabel("  TutorID: ");
        first.setForeground(Color.getColor(null, Background));
        first.setFont(new Font("Avenir Next", Font.BOLD, 24));
        JTextField firstName = new JTextField();
        firstName.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        firstName.setText("Enter your ID");
        a.add(first);
        a.add(firstName);
        firstName.requestFocus();

        JPanel b= new JPanel(new FlowLayout(FlowLayout.LEFT));
        b.setOpaque(false);
        b.setMaximumSize(new Dimension(1200, 40));
        JLabel last = new JLabel("  Course Code: ");
        last.setFont(new Font("Avenir Next", Font.BOLD, 24));
        last.setForeground(Color.getColor(null, Background));
        JTextField lastName = new JTextField();
        lastName.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        lastName.setText("Enter your course code");
        b.add(last);
        b.add(lastName);
        lastName.requestFocus();

        JPanel c= new JPanel(new FlowLayout(FlowLayout.LEFT));
        c.setOpaque(false);
        c.setMaximumSize(new Dimension(1200, 40));
        JLabel email = new JLabel("  Availability: ");
        email.setForeground(Color.getColor(null, Background));
        email.setFont(new Font("Avenir Next", Font.BOLD, 24));
        JTextField email_text = new JTextField();
        email_text.setFont(new Font("Avenir Next", Font.PLAIN, 24));
        email_text.setText("start time");
        c.add(email);
        c.add(email_text);
        email_text.requestFocus();



        JPanel button = new JPanel();
        button.setOpaque(false);
        BufferedImage bb = ImageIO.read(new File("src/scheduler/pictures/go.png"));
        JButton bs = new JButton(new ImageIcon(bb));
        bs.setMargin(new Insets(0, 0, 0, 0));
        bs.setBackground(null);
        bs.setBorder(null);
        button.add(bs);

        register.add(margin);
        register.add(a);
        register.add(b);
        register.add(c);
        register.add(button);


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
                        new Tutor_Register();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                else if(comboBox.getSelectedItem().equals("view upcoming sessions")){
                    try {
                        new Tutor_ViewSessions();
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

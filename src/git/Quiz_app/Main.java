package git.Quiz_app;


import git.Quiz_app.Util.jbtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JLabel header;
    JLabel uname , pass;
    JTextField u , p;
    jbtn login;
    Main(){
        setTitle("Quiz App");
        setLayout(null); //removing margins and padding
        getContentPane().setBackground(Color.decode("#f4f4f4"));//setting bg to off-white color

        //Top header
        header = new JLabel("Welcome To Quiz App!!!");
        header.setFont(new Font("Osward", Font.BOLD, 38));
        header.setBounds(75,40,520,40);
        add(header);

        //username
        uname = new JLabel("Username");
        uname.setFont(new Font("Raleway", Font.BOLD, 25));
        uname.setBounds(120,160,375,30);
        add(uname);

        //username - textfield
        u = new JTextField(300);
        u.setFont(new Font("Arial", Font.PLAIN, 20));
        u.setBounds(250,165,230,25);
        add(u);

        //password
        pass = new JLabel("Password");
        pass.setFont(new Font("Raleway", Font.BOLD, 25));
        pass.setBounds(120,230,375,30);
        add(pass);

        //password - textfield
        p = new JTextField(300);
        p.setFont(new Font("Arial", Font.PLAIN, 20));
        p.setBounds(250,235,230,25);
        add(p);


        login = new jbtn("Login",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
        //bg color set using jbtn utility class
        login.setForeground(Color.decode("#000000"));
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBounds(240,310,100,30);
        add(login);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,500);
        this.setVisible(true);

    }
    public static void main(String[] args) {
    	admin a = new admin();
//        Main m = new Main();
    	}

    public void actionPerformed(ActionEvent e){

    }
}

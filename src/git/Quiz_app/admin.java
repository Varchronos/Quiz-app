package git.Quiz_app;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class admin extends JFrame implements ActionListener {
        JLabel l1,l2,l3,l4,l5,l6;
    JFrame frame = new JFrame();
	JTextField question,opt1,opt2,opt3,opt4,rightans;
	JButton submit,clear;
	
	admin(){
            frame.setBounds(500,500,10,10);
		setTitle("Quiz App");
		l1 = new JLabel("Add Question");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,520,40);
        add(l1);
        
        l2 = new JLabel("Question");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        question = new JTextField(300);
        question.setBounds(300,150,230,30);
        question.setFont(new Font("Arial", Font.BOLD, 14));
        add(question);
        
        l3 = new JLabel("Option1:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        opt1 = new JTextField(30);
        opt1.setBounds(300,220,230,30);
        opt1.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt1);
        
        l4 = new JLabel("Option2:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(125,220,375,30);
        add(l4);
        
        opt2 = new JTextField(30);
        opt2.setBounds(300,150,230,30);
        opt2.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt2);
        
        l5 = new JLabel("Option3:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(125,220,375,30);
        add(l5);
        
        opt3 = new JTextField(300);
        opt3.setBounds(300,150,230,30);
        opt3.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt3);
        
        l6 = new JLabel("Option4:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(125,220,375,30);
        add(l6);
        
        opt4 = new JTextField(300);
        opt4.setBounds(300,150,230,30);
        opt4.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt4);

//        l6 = new JLabel("Option4:");
//        l6.setFont(new Font("Raleway", Font.BOLD, 28));
//        l6.setBounds(125,220,375,30);
//        add(l6);
//
//        opt4 = new JTextField(300);
//        opt4.setBounds(300,150,230,30);
//        opt4.setFont(new Font("Arial", Font.BOLD, 14));
//        add(opt4);
                
        submit = new JButton("Add Question");
        submit.setBounds(100,100,400,200);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
//        b3 = new JButton("SIGN UP");
//        b3.setBackground(Color.BLACK);
//        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setBounds(300,300,100,30);
        add(submit);
        
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);
        
//        clear.setFont(new Font("Arial", Font.BOLD, 14));
//        clear.setBounds(300,350,230,30);
//        add(clear);
        
        submit.addActionListener(this);
        clear.addActionListener(this);
//        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
	}
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit) {         //submit the data in dbms
                        connection con = new connection();          //creating connection to dbms
                        PreparedStatement stmt = con.c.prepareStatement("INSERT INTO question (question,option1,option2,option3,option4,correct_apt) VALUE (?,?,?,?,?,?)");
//                        stmt.setInt(1,question_no);
                        stmt.setString(2,question);
                        stmt.setString(3,opt1);
                        stmt.setString(4,opt2);
                        stmt.setString(5,opt3);
                        stmt.setString(6,opt4);
                        stmt.setString(7,rightans);

                        int i = stmt.executeUpdate();
                        System.out.println(i + " Question added");
                }
    }

}

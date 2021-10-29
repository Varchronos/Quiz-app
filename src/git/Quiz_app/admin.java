package git.Quiz_app;

import git.Quiz_app.Util.jbtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class admin extends JFrame implements ActionListener {
        JLabel head, Q,o1, o2, o3, o4;
    
	JTextField question;
    JTextField opt1;
    JTextField opt2;
    JTextField opt3;
    JTextField opt4;
    jbtn submit,clear; //created a button utility class on Util pkg
	
	admin(){
            


		setTitle("Admin Panel");
		head = new JLabel("Add Question");
        head.setFont(new Font("Osward", Font.BOLD, 38));
        head.setBounds(170,40,520,40);
        add(head);

        //Question text
        Q = new JLabel("Question");
        Q.setFont(new Font("Raleway", Font.BOLD, 15));
        Q.setBounds(135,120,375,30);
        add(Q);

        //Text field for question
        question = new JTextField(300);
        question.setBounds(205,125,230,20);
        question.setFont(new Font("Arial", Font.PLAIN, 15));
        add(question);

        //option 1
        o1 = new JLabel("Option1:");
        o1.setFont(new Font("Raleway", Font.BOLD, 15));
        o1.setBounds(135,170,375,30);
        add(o1);

        //text field for option 1
        opt1 = new JTextField(30);
        opt1.setBounds(205,175,230,20);
        opt1.setFont(new Font("Arial", Font.BOLD, 15));
        add(opt1);

        //option 2
        o2 = new JLabel("Option2:");
        o2.setFont(new Font("Raleway", Font.BOLD, 15));
        o2.setBounds(135,200,375,30);
        add(o2);

        //text field for option 2
        opt2 = new JTextField(30);
        opt2.setBounds(205,205,230,20);
        opt2.setFont(new Font("Arial", Font.BOLD, 15));
        add(opt2);

        //option 3
        o3 = new JLabel("Option3:");
        o3.setFont(new Font("Raleway", Font.BOLD, 15));
        o3.setBounds(135,230,375,30);
        add(o3);

        //text field for option 3
        opt3 = new JTextField(300);
        opt3.setBounds(205,235,230,20);
        opt3.setFont(new Font("Arial", Font.BOLD, 15));
        add(opt3);

        //option 4
        o4 = new JLabel("Option4:");
        o4.setFont(new Font("Raleway", Font.BOLD, 15));
        o4.setBounds(135,260,375,30);
        add(o4);

        //text field for option 4
        opt4 = new JTextField(300);
        opt4.setBounds(205,265,230,20);
        opt4.setFont(new Font("Arial", Font.BOLD, 15));
        add(opt4);

        //submit button
        submit = new jbtn("Add Question",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
        //bg color set using jbtn utility class
        submit.setForeground(Color.decode("#000000"));
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setBounds(130,340,140,40);
        add(submit);

        //Clear-Button
        clear = new jbtn("CLEAR",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
        //bg color set using jbtn utility class
        clear.setForeground(Color.decode("#000000"));
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(330,340,140,40);
        add(clear);

        
        setLayout(null);
        submit.addActionListener(this);
        clear.addActionListener(this);
        getContentPane().setBackground(Color.decode("#f4f4f4"));
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,500);
        this.setVisible(true);
        this.add(head);
	}
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit) {         //submit the data in dbms
                        connection con = new connection();          //creating connection to dbms
                    PreparedStatement stmt = null;
                    try {
                        stmt = con.c.prepareStatement("INSERT INTO question (question,option1,option2,option3,option4,correct_apt) VALUE (?,?,?,?,?,?)");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//                        stmt.setInt(1,question_no);
                    try {
                        if (stmt != null) {

                            stmt.setString(2, String.valueOf(question));
                            stmt.setString(3, String.valueOf(opt1));
                            stmt.setString(4, String.valueOf(opt2));
                            stmt.setString(5, String.valueOf(opt3));
                            stmt.setString(6, String.valueOf(opt4));
//                        stmt.setString(7,rightans);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                    int i = 0;
                    try {
                        if (stmt != null) {
                            i = stmt.executeUpdate();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(i + " Question added");
                }


    }

}

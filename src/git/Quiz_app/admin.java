package git.Quiz_app;

import git.Quiz_app.Util.jbtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class admin extends JFrame implements ActionListener {
        JLabel head, Q,o1, o2, o3, o4,ans;
    
	JTextField question,an;
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

        //answer text
        ans = new JLabel("Answer");
        ans.setFont(new Font("Raleway", Font.BOLD, 15));
        ans.setBounds(135,150,375,30);
        add(ans);

        //text field for ans text
        an = new JTextField(300);
        an.setFont(new Font("Arial", Font.PLAIN, 15));
        an.setBounds(205,155,230,20);
        add(an);

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
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/quiz_app", "root", "root");
                        Statement s = c.createStatement();         //creating connection to dbms
                        System.out.println(c);
                        String query = "INSERT INTO question (question_no,question,option1,option2,option3,option4,correct_opt) VALUES (DEFAULT,'"+question.getText()
                                + "','" + opt1.getText()
                                + "','" + opt2.getText() + "','" + opt3.getText() + "','" + opt4.getText() + "','" + an.getText() + "');";
                        System.out.println(query);
                        s.executeUpdate(query);
                        s.close();
                        c.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    System.out.println( " Question added");
                }
    }

}

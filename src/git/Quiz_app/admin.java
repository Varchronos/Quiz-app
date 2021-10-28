package git.Quiz_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
        JLabel l1,l2,l3,l4,l5,l6;
    
	JTextField question;
    JTextField opt1;
    JTextField opt2;
    JTextField opt3;
    JTextField opt4;
    JButton submit,clear;
	
	admin(){
            


		setTitle("Quiz App");
		l1 = new JLabel("Add Question");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(170,40,520,40);
        add(l1);
        
        l2 = new JLabel("Question");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(100,100,375,30);
        add(l2);

        question = new JTextField(300);
        question.setBounds(230,100,230,30);
        question.setFont(new Font("Arial", Font.BOLD, 14));
        add(question);

        l3 = new JLabel("Option1:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(100,150,375,30);
        add(l3);

        opt1 = new JTextField(30);
        opt1.setBounds(230,150,230,30);
        opt1.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt1);

        l4 = new JLabel("Option2:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(100,200,375,30);
        add(l4);

        opt2 = new JTextField(30);
        opt2.setBounds(230,200,230,30);
        opt2.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt2);

        l5 = new JLabel("Option3:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(100,250,375,30);
        add(l5);

        opt3 = new JTextField(300);
        opt3.setBounds(230,250,230,30);
        opt3.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt3);

        l6 = new JLabel("Option4:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(100,300,375,30);
        add(l6);

        opt4 = new JTextField(300);
        opt4.setBounds(230,300,230,30);
        opt4.setFont(new Font("Arial", Font.BOLD, 14));
        add(opt4);

//        Submit-Button
        submit = new JButton("Add Question");
        submit.setBounds(100,100,400,200);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setBounds(170,380,100,30);
        add(submit);

//        Clear-Button
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(330,380,100,30);
        add(clear);

        
        setLayout(null);
        

        

        

        
        submit.addActionListener(this);
        clear.addActionListener(this);

        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,500);
        this.setVisible(true);
        this.add(l1);
	}
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit) {
                        System.out.println("hello");
                }
    }

}

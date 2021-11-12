package git.Quiz_app;


import git.Quiz_app.Util.jbtn;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main extends JFrame implements ActionListener {
    private JPanel header;
    private JPanel body;
    private JLabel top,username,regID;
    private JTextField uname, reg;
    private jbtn login;
    private JButton lnk;
    private ImageIcon icon;
    Main(){
        this.setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#f4f4f4"));

        //adding icon to the frame
        icon = new ImageIcon("Screenshots/car.png");
        this.setIconImage(icon.getImage());

        //header panel
        header = new JPanel();
        header.setPreferredSize(new Dimension(100,100));
        header.setLayout(new MigLayout());
        header.setBackground(Color.decode("#f4f4f4"));
        this.add(header,BorderLayout.NORTH);
        //top text head on header panel
        top = new JLabel("Welcome To Quiz App",JLabel.CENTER);
        top.setFont(new Font("Osward", Font.BOLD, 38));
        header.add(top,"push,grow");

        //body Panel
        body = new JPanel();
        body.setPreferredSize(new Dimension(400,600));
        body.setBackground(Color.decode("#f4f4f4"));
        this.add(body,BorderLayout.CENTER);
        body.setLayout(new MigLayout("","[:100, grow, center][grow, left]",""));
        //username
        username = new JLabel("Username:");
        username.setFont(new Font("Raleway", Font.BOLD, 25));
        uname =new JTextField();
        uname.setFont(new Font("Arial", Font.PLAIN, 20));
        body.add(username,"align right");
        body.add(uname,"wmin 230,wrap");
        regID = new JLabel("Roll-no:");
        regID.setFont(new Font("Raleway", Font.BOLD, 25));
        reg = new JTextField();
        reg.setFont(new Font("Arial", Font.PLAIN, 20));
        body.add(regID,"align right");
        body.add(reg,"wmin 230, wrap 20px");
        //login button
        login = new jbtn("Login",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.addActionListener(this);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        body.add(login,"span,align center,wrap 2px");
        //admin link
        lnk = new JButton("Are you an Admin? Click here");
        lnk.setFont(new Font("Raleway", Font.BOLD, 10));
        lnk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lnk.setFocusPainted(false);
        lnk.setForeground(Color.decode("#193498"));
        lnk.setBackground(Color.decode("#f4f4f4"));
        lnk.setBorderPainted(false);
        lnk.addActionListener(this);
        body.add(lnk,"span,align center,wrap");



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource()==lnk){
            this.dispose();
            admin_login al = new admin_login();
        }
        if(evt.getSource()==login)
        {
            this.dispose();
            startmenu s = new startmenu(uname.getText(),reg.getText());

        }
    }

    //main runner

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("\n\nPresent Project Directory : "+ System.getProperty("user.dir"));
    }

}

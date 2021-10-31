//package git.Quiz_app;
//
//import git.Quiz_app.Util.jbtn;
//import net.miginfocom.swing.MigLayout;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class test extends JFrame implements ActionListener
//{
//    JPanel header;
//    JPanel body;
//    JLabel head, Q,o1, o2, o3, o4,ans;
//
//    JTextField question,an;
//    JTextField opt1;
//    JTextField opt2;
//    JTextField opt3;
//    JTextField opt4;
//    jbtn submit,clear;
//    JButton lnk ;
//
//    test(){
//        this.setLayout(new BorderLayout());
//        getContentPane().setBackground(Color.decode("#f4f4f4"));
//
//        //header panel
//        header = new JPanel();
//        header.setPreferredSize(new Dimension(100,100));
//        header.setLayout(new MigLayout("fill","",""));
//        header.setBackground(Color.decode("#f4f4f4"));
//        this.add(header,BorderLayout.NORTH);
//        //top text head on header panel
//        head = new JLabel("Add Question");
//        head.setFont(new Font("Osward", Font.BOLD, 38));
//        header.add(head,"align center , span");
//
//        //body Panel
//        body = new JPanel();
//        body.setPreferredSize(new Dimension(400,600));
//        body.setBackground(Color.decode("#f4f4f4"));
//        this.add(body,BorderLayout.CENTER);
//        body.setLayout(new MigLayout("debug","[:70, grow, center][grow, left]",""));
//        //question
//        Q = new JLabel("Question:");
//        Q.setFont(new Font("Raleway", Font.BOLD, 15));
//        question = new JTextField(300);
//        question.setBounds(205,125,230,20);
//        body.add(Q,"align right");
//        body.add(question,"wmin 230, wmax 230,align left,wrap");
//        //ans
//        ans = new JLabel("Answer:");
//        ans.setFont(new Font("Raleway", Font.BOLD, 15));
//        an = new JTextField(300);
//        an.setFont(new Font("Arial", Font.PLAIN, 15));
//        body.add(ans,"align right");
//        body.add(an,"wmin 230, wmax 230,align left, wrap");
//        //option 1
//        o1 = new JLabel("Option1:");
//        o1.setFont(new Font("Raleway", Font.BOLD, 15));
//        opt1 = new JTextField(30);
//        opt1.setBounds(205,175,230,20);
//        body.add(o1,"align right");
//        body.add(opt1,"wmin 230 ,wmax 230,align left ,wrap");
//        //option 2
//        o2 = new JLabel("Option2:");
//        o2.setFont(new Font("Raleway", Font.BOLD, 15));
//        opt2 = new JTextField(30);
//        opt2.setBounds(205,205,230,20);
//        body.add(o2,"align right");
//        body.add(opt2,"wmin 230, wmax 230 ,align left ,wrap");
//        //option 3
//        o3 = new JLabel("Option3:");
//        o3.setFont(new Font("Raleway", Font.BOLD, 15));
//        opt3 = new JTextField(300);
//        opt3.setBounds(205,235,230,20);
//        body.add(o3,"align right");
//        body.add(opt3,"wmin 230, wmax 230,align left ,wrap");
//        //option 4
//        o4 = new JLabel("Option4:");
//        o4.setFont(new Font("Raleway", Font.BOLD, 15));
//        opt4 = new JTextField(300);
//        opt4.setBounds(205,265,230,20);
//        body.add(o4,"align right");
//        body.add(opt4,"wmin 230, wmax 230,align left,wrap 20px");
//
//
//
//
//
//        //submit button
//        submit = new jbtn("ADD",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
//        submit.setForeground(Color.decode("#000000"));
//        submit.setFont(new Font("Arial", Font.BOLD, 14));
//        submit.addActionListener(this);
//        body.add(submit,"span,wmin 100, wmax 100,align center,split2");
//        //clear
//        clear = new jbtn("CLEAR",Color.decode("#9A9483"), Color.decode("#C7BEA2"));
//        clear.setFont(new Font("Arial", Font.BOLD, 14));
//        clear.setForeground(Color.decode("#000000"));
//        body.add(clear,"wmin 100, wmax 100,wrap 2px");
//        //Login link
//        lnk = new JButton("Return to Login? Click here");
//        lnk.setFont(new Font("Raleway", Font.BOLD, 10));
//        lnk.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        lnk.setFocusPainted(false);
//        lnk.setForeground(Color.decode("#193498"));
//        lnk.setBackground(Color.decode("#f4f4f4"));
//        lnk.setBorderPainted(false);
//        lnk.addActionListener(this);
//        body.add(lnk,"span,align center,wrap");
//
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(true);
//
//        this.setSize(500,400);
//        this.setVisible(true);
//
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}

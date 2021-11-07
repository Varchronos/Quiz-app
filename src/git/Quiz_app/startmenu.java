package git.Quiz_app;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class startmenu extends JFrame implements ActionListener {
   JPanel header,body,footer;
   JLabel head,h2,inst,inf;
   JButton starmit, next;

startmenu(){}
startmenu(String name,String reg){
    user use = new user();
    use.name = name;
    use.regID = reg;

    setTitle("Strat Menu");
    this.setLayout(new BorderLayout());
    getContentPane().setBackground(Color.decode("#f4f4f4"));
    //header panel
    header = new JPanel();
    header.setPreferredSize(new Dimension(100,100));
    header.setLayout(new MigLayout("fillx","[grow, left]",""));
    header.setBackground(Color.decode("#f4f4f4"));
    this.add(header,BorderLayout.NORTH);
    // head on header panel
    head = new JLabel("Start Menu",JLabel.CENTER);
    head.setFont(new Font("Osward", Font.BOLD, 38));
    header.add(head,"push,grow,wrap");
    h2 = new JLabel("Welcome "+name);
    h2.setFont(new Font("Osward",Font.PLAIN,15));
    header.add(h2,"align center");

    //body panel which will have contents of instruction and quiz
    body =  new JPanel();
    body.setPreferredSize(new Dimension(700,400));
    body.setBackground(Color.white);
    this.add(body, BorderLayout.CENTER);
    body.setLayout(new MigLayout(" ","[:100, grow, center][grow, left]",""));
    inst = new JLabel("Instructions");
    inst.setFont(new Font("Raleway",Font.BOLD,25));
    body.add(inst,"align left,wrap");

    inf = new JLabel("=> All questions are within syllabus"){
        @Override
        public void setFont(Font font) {
            font = new Font("Raleway",Font.PLAIN,15);
            super.setFont(font);
        }
    };
    body.add(inf,"align left ,grow, wrap,newline 30px");
    body.add(new JLabel("=> You wont be able to return back to previous question/s after answering them"){
        @Override
        public void setFont(Font font) {
            font = new Font("Raleway",Font.PLAIN,15);
            super.setFont(font);
        }
    },"align left, grow , wrap");
    body.add(new JLabel("=> All the best"){
        @Override
        public void setFont(Font font) {
            font = new Font("Raleway",Font.PLAIN,15);
            super.setFont(font);
        }
    },"align left, grow, wrap");

    //footer panel, panel will have buttons only
    footer  =  new JPanel();
    footer.setPreferredSize(new Dimension(100,100));
    footer.setBackground(Color.decode("#f4f4f4"));
    this.add(footer,BorderLayout.SOUTH);

    //start submit button
    starmit =  new JButton("START");
    starmit.setBackground(Color.white);
    starmit.setBorderPainted(false);
    starmit.setFocusPainted(false);
    starmit.setBackground(Color.decode("#b69f66"));
    starmit.setFont(new Font("Raleway", Font.BOLD, 15));
    starmit.addActionListener(this);
    footer.add(starmit,"");

    //next button
    next = new JButton("NEXT");
    next.setBackground(Color.white);
    next.setBorderPainted(false);
    next.setBackground(Color.decode("#b69f66"));
    next.setFocusPainted(false);
    next.setFont(new Font("Raleway", Font.BOLD, 15));
    next.addActionListener(this);
    footer.add(next,"wrap");



    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(700,600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==starmit){
        System.out.println("start button changed to submit button");
        starmit.setText("SUBMIT");

    }
        if(e.getSource()==next)
        {
            System.out.println("next button pressed");
        }
    }


}

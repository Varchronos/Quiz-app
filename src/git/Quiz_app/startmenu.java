package git.Quiz_app;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;

public class startmenu extends JFrame implements ActionListener {

   JPanel header,body,footer;
   JLabel head,h2,inst, inf1,inf2, inf3;
   JButton starmit;
   int count=0,marks=0;
   JRadioButton o1, o2, o3, o4;
   ButtonGroup group;
   Connection c;
   Statement s;
   ResultSet rs;
   ArrayList<Integer> arr;
   user use;
    String time;
    JLabel samay = new JLabel("Time: 00:00");
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            Timer tm = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passedtime+=1000;
                    min = (passedtime/60000)%60;
                    sec = (passedtime/1000)%60;
                    secs = String.format("%02d", sec);
                    mins = String.format("%02d", min);
                    samay.setText("Time: "+mins+":"+secs);
                    time=mins+" mins " +secs+" secs ";
                }
            });
            tm.start();
        }
    };
    Thread t1 = new Thread(r1);
    int passedtime = 0;
    int min = 0;
    int sec = 0;
    String secs = String.format("%02d", sec);
    String mins = String.format("%02d", min);

startmenu(){}
startmenu(String name,String reg){
    //connection to mysql
    try {
            //connecting to dbms for fetching question
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6450129", "sql6450129", "iJ8zlh5CCx");
            s = c.createStatement();
            String query = "SELECT count(*) FROM question;";
            rs = s.executeQuery(query);
            rs.next();
            int max = rs.getInt(1);
//            System.out.println("debug");
            use = new user();
            use.name = name;
            use.regID = reg;

            setTitle("Start Menu");
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
            body.setLayout(new MigLayout("fillx","[:100,grow, center][grow, left]",""));
            inst = new JLabel("Instructions");
            inst.setFont(new Font("Raleway",Font.BOLD,25));
            body.add(inst,"align left,wrap");

            inf1 = new JLabel("=> All questions are within syllabus"){
                @Override
                public void setFont(Font font) {
                    font = new Font("Raleway",Font.PLAIN,15);
                    super.setFont(font);
                }
            };
            body.add(inf1,"align left ,grow, wrap,newline 30px");
            inf2 = new JLabel("=> You wont be able to return back to previous question/s after answering them"){
                @Override
                public void setFont(Font font) {
                    font = new Font("Raleway",Font.PLAIN,15);
                    super.setFont(font);
                }
            };
            body.add(inf2,"align left, grow , wrap");

            inf3 = new JLabel("=> All the best"){
                @Override
                public void setFont(Font font) {
                    font = new Font("Raleway",Font.PLAIN,15);
                    super.setFont(font);
                }
            };
            body.add(inf3,"align left, grow, wrap");

            //footer panel, panel will have buttons only
            footer  =  new JPanel();
            footer.setPreferredSize(new Dimension(100,100));
            footer.setBackground(Color.decode("#f4f4f4"));
            footer.setLayout(new MigLayout("fillx","[grow, left]",""));
            this.add(footer,BorderLayout.SOUTH);

            //start submit button
            starmit =  new JButton("START");
            starmit.setBackground(Color.white);
            starmit.setBorderPainted(false);
            starmit.setFocusPainted(false);
            starmit.setBackground(Color.decode("#b69f66"));
            starmit.setFont(new Font("Raleway", Font.BOLD, 15));
            starmit.addActionListener(this);
            footer.add(starmit,"align center");

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(700,600);
            this.setLocationRelativeTo(null);
            this.setVisible(true);

            //generating random numbers for quiz
            arr = randGen(max);
            System.out.println(max);
        }
        catch(SQLException | ClassNotFoundException error){
            System.out.println("System Requirements not fulfilled!\nAborting...");//hello cpp
            error.printStackTrace();
    }
}
private void qset(ResultSet rs){
    try{
        group = new ButtonGroup();
        body.revalidate();
        body.repaint();
        rs.next();
        samay.setFont(new Font("Raleway", Font.BOLD, 18));
        String question = rs.getString(2);
        String opt1 = rs.getString(3);
        String opt2 = rs.getString(4);
        String opt3 = rs.getString(5);
        String opt4 = rs.getString(6);
        String correct_ans = rs.getString(7);
        body.setPreferredSize(new Dimension(700,400));
        body.setBackground(Color.white);
        this.add(body,BorderLayout.CENTER);
        body.setLayout(new MigLayout("fillx","[grow, left]",""));
        body.add(samay, "align center, wrap, newline 20");

        inst = new JLabel(question);
        inst.setFont(new Font("Raleway",Font.BOLD,25));
        body.add(inst, "align left,span 2, wrap, wmax 700px,newline 30");

        o1 = new JRadioButton(opt1);
        o1.setBorderPainted(false);
        o1.setBackground(Color.white);
        o1.setFont(new Font("Raleway", Font.PLAIN, 15));
        group.add(o1);
        body.add(o1, "align left, wrap");
        o1.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if(o1.getText().equalsIgnoreCase(correct_ans)){
                if(state == ItemEvent.SELECTED){
                    marks+=1;
                }
                else if(state==ItemEvent.DESELECTED){
                    marks-=1;
                }
            }
        });

        o2= new JRadioButton(opt2);
        o2.setBorderPainted(false);
        o2.setBackground(Color.white);
        o2.setFont(new Font("Raleway", Font.PLAIN, 15));
        group.add(o2);
        body.add(o2, "align left, wrap");
        o2.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if(o2.getText().equalsIgnoreCase(correct_ans)) {
                if (state == ItemEvent.SELECTED) {
                    marks += 1;
                } else if (state == ItemEvent.DESELECTED) {
                    marks -= 1;
                }
            }
        });

        o3 = new JRadioButton(opt3);
        o3.setBorderPainted(false);
        o3.setBackground(Color.white);
        o3.setFont(new Font("Raleway", Font.PLAIN, 15));
        group.add(o3);
        body.add(o3, "align left, wrap");
        o3.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if(o3.getText().equalsIgnoreCase(correct_ans)) {
                if (state == ItemEvent.SELECTED) {
                    marks += 1;
                } else if (state == ItemEvent.DESELECTED) {
                    marks -= 1;
                }
            }
        });

        o4 = new JRadioButton(opt4);
        o4.setBorderPainted(false);
        o4.setBackground(Color.white);
        o4.setFont(new Font("Raleway", Font.PLAIN, 15));
        group.add(o4);
        body.add(o4, "align left, wrap");
        o1.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if(o4.getText().equalsIgnoreCase(correct_ans)){
                if(state == ItemEvent.SELECTED){
                    marks+=1;
                }
                else if(state==ItemEvent.DESELECTED){
                    marks-=1;
                }
            }
        });
    }
    catch(SQLException e) {
        e.printStackTrace();
    }
}

    //random array generator
    public static ArrayList<Integer> randGen(int max){
        ArrayList<Integer> arr = new ArrayList<>();
        int min = 1;
        int m = max;
        while(arr.toArray().length!=max){
            for(int i = 1; i<=max;i++) {
                int b = (int) (Math.random() * (m - min + 1) + min);
                if (!arr.contains(b)) {
                    arr.add(b);
                }
            }
        }
//        System.out.println(arr);
        return arr;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==starmit) {
            if(count ==0) {
                t1.start();
                System.out.println("Timer started");
            }
            if (count < 5) {
                System.out.println("start button changed to submit button");
                starmit.setText("NEXT");
                String query = "SELECT * FROM question where question_no="+ arr.get(count) +";";
                try {
                    rs = s.executeQuery(query);
                }catch (SQLException exec){
                    exec.printStackTrace();
                }
                body.removeAll();
                body.revalidate();
                body.repaint();
                body.add(samay, BorderLayout.SOUTH);
                qset(rs);
                System.out.println(marks);
                count++;

                //changing to submit btn at last question
                if(count ==5)
                {starmit.setText("SUBMIT");
                System.out.println("changing button to submit");}
            }
            else{


                System.out.println(marks);
                use.marks = marks;
                t1.stop();
                System.out.println(time);
                use.time = time;
                try{

                    //connecting to dbms for fetching question
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    c = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6450129", "sql6450129", "iJ8zlh5CCx");
                    Statement s = c.createStatement();
                    String query = "INSERT INTO users (id,name,userid,correctans,time) VALUES (DEFAULT,'"
                            + use.name + "','"
                            + use.regID + "',"
                            + use.marks + ",'"
                            + use.time + "');";
                    s.executeUpdate(query);
                    s.close();
                    c.close();
                    JOptionPane.showMessageDialog(null,"You have successfully submitted the quiz!!!","Successfull", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    result_table r = new result_table();
                }catch (SQLException | ClassNotFoundException en){
                    en.printStackTrace();
                }
            }

        }
    }

}


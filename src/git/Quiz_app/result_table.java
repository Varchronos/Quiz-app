package git.Quiz_app;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class result_table extends JFrame implements ActionListener {
    JPanel header, footer;
    JLabel head;
    JButton lnk;
    JScrollPane scroll;
    String[] columnName = {"Id","RegID","Name","Scores","Time Taken"};
    ResultSet rs;

    result_table(){
        setTitle("Result");
        getContentPane().setBackground(Color.decode("#f4f4f4"));
        this.setLayout(new BorderLayout());

        //header panel
        header= new JPanel();
        header.setPreferredSize(new Dimension(100,100));
        header.setLayout(new MigLayout("fillx","[grow, left]",""));
        header.setBackground(Color.decode("#F6E6CB"));
        this.add(header,BorderLayout.NORTH);
        // head on header panel
        head = new JLabel("Results",JLabel.CENTER);
        head.setFont(new Font("Osward", Font.BOLD, 38));
        header.add(head,"push,grow,wrap");

        //Table added for displaying results
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnName);
        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);

        table.setFont(new Font("Raleway",Font.PLAIN,15));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );
        int id,scores;
        String regID,name,time;

        try{
            //connecting to dbms for fetching question
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6450129", "sql6450129", "iJ8zlh5CCx");
            Statement st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM users;");
            while (rs.next()){
                id = rs.getInt("id");
                regID = rs.getString("userid");
                name = rs.getString("name");
                scores = rs.getInt("correctans");
                time = rs.getString("time");
                model.addRow(new Object[]{id,regID,name,scores,time});
                System.out.println(id);
            }

        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        this.add(table,BorderLayout.CENTER);
        this.setVisible(true);
        scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);

        footer = new JPanel();
        footer.setPreferredSize(new Dimension(100,100));
        footer.setLayout(new MigLayout("fillx","[grow, left]",""));
        footer.setBackground(Color.decode("#F6E6CB"));
        this.add(footer, BorderLayout.SOUTH);

        lnk = new JButton("Return to Login? Click here");
        lnk.setFont(new Font("Raleway", Font.BOLD, 16));
        lnk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lnk.setFocusPainted(false);
        lnk.setForeground(Color.BLACK);
        lnk.setBackground(Color.decode("#F6E6CB"));
        lnk.setBorderPainted(false);
        lnk.addActionListener(this);
        footer.add(lnk,"push,align center,wrap");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==lnk){
            this.dispose();
            Main m = new Main();
        }
    }
}


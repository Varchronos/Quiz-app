package git.Quiz_app;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class result_table extends JFrame implements ActionListener {
    JPanel header, body, footer;
    JLabel head;
    JScrollPane scroll;

    result_table(){
        setTitle("Result");
        getContentPane().setBackground(Color.decode("#f4f4f4"));
        this.setLayout(new BorderLayout());

        //header panel
        header= new JPanel();
        header.setPreferredSize(new Dimension(100,100));
        header.setLayout(new MigLayout("fillx","[grow, left]",""));
        header.setBackground(Color.decode("#9A9483"));
        this.add(header,BorderLayout.NORTH);
        // head on header panel
        head = new JLabel("Results",JLabel.CENTER);
        head.setFont(new Font("Osward", Font.BOLD, 38));
        header.add(head,"push,grow,wrap");

        body = new JPanel();
        body.setPreferredSize(new Dimension(700,400));
        body.setBackground(Color.decode("#f4f4f4"));
        this.add(body, BorderLayout.CENTER);
        //query here
        scroll = new JScrollPane(body);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scroll);

        footer = new JPanel();
        footer.setPreferredSize(new Dimension(100,100));
        footer.setLayout(new MigLayout("fillx","[grow, left]",""));
        footer.setBackground(Color.decode("#9A9483"));
        this.add(footer, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}


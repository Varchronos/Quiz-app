package git.Quiz_app;

import java.sql.*;

public class connection {
    Connection c;
    Statement s;

    public connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/quiz_app", "root", "root");
            s = c.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

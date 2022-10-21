import java.sql.*;

public class Main {
        private static final String QUERY="select id,name,email,country,password from Users";
    public static void main(String[] args) {

        System.out.println("Hello world!");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false","root","123456");
            Statement stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," +name +"," +email+", "+country+", "+password);
            }
            System.out.println(connection.isValid(10));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        ;
    }
}
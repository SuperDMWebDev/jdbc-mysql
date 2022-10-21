import java.sql.*;

public class InsertPStatementExample {
    private static final String INSERT_USERS_SQL="INSERT INTO users"+" (id,name,email,country,password) VALUES "+ "(?,?,?,?,?);";
    public static void main(String[] args) throws SQLException{
        InsertPStatementExample createTable = new InsertPStatementExample();
        createTable.insertRecord();

    }
    public void insertRecord() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false","root","123456");
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Tony");
            preparedStatement.setString(3, "tony@gmail.com");
            preparedStatement.setString(4, "US");
            preparedStatement.setString(5, "secret");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


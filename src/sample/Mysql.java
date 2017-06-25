package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mysql
{

    public static Connection connection()
    {
        String driver = "jdbc:mysql://localhost:3306";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(driver+"/DevDB","root","root");
            return con;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

<<<<<<< HEAD
    public void insertRowsInCustomer(List rows)
    {
        String query = "INSERT INTO Customer (lastName,firstName,dateOfBirth,address,phone) VALUES (?,?,?,?,?)";
        try
        {
            for(int i=0; i<=rows.size(); i++)
            {
                PreparedStatement stmt = Mysql.connection().prepareStatement(query);
=======
    public void insertRowsInCustomer(List rows) //Insert new rows in the customer table
    {
        // String variable that holds the query to the DB
        String query = "INSERT INTO Customer (lastName,firstName,dateOfBirth,address,phone) VALUES (?,?,?,?,?)";
        try
        {
            for(int i=0; i<=rows.size(); i++) // loop as many times as rows we have in the list
            {
                //Creates a prepared statement to execute the query
                PreparedStatement stmt = Mysql.connection().prepareStatement(query);
                //This is the statement that holds the rows from the table
                //stmt needs 2 values, the row in the table you want to query and the data you want to insert
>>>>>>> 1288d67e89e698fee3e4e4585e749dfbb8df5dd1
                stmt.setString(i+1, rows.get(i).toString());
            }
        }catch (SQLException e)
        {
<<<<<<< HEAD
            System.out.println(e);
        }finally
        {
            System.out.println("Can't excecute the query");
=======
            System.out.println(e); // Error handling
        }finally
        {
            System.out.println("Can't excecute the query"); //If the error is thrown, say a message
>>>>>>> 1288d67e89e698fee3e4e4585e749dfbb8df5dd1
        }
    }

    public void selectRowsFromCustomer()
    {
        String query = "SELECT * FROM Customer";
        List<String> customer = new ArrayList<>();
        int i=0;
        try
        {
            PreparedStatement stmt = Mysql.connection().prepareStatement(query);
            ResultSet result = stmt.executeQuery(query);
            while(result.next())
            {
                System.out.println(result.getString(i));
                //customer.add(result.getString(i+1));
                i++;
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }finally
        {
            System.out.println("Can't excecute the query");
        }
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}

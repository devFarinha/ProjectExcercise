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

    public void insertRowsInCustomer(List rows)
    {
        String query = "INSERT INTO Customer (lastName,firstName,dateOfBirth,address,phone) VALUES (?,?,?,?,?)";
        try
        {
            for(int i=0; i<=rows.size(); i++)
            {
                PreparedStatement stmt = Mysql.connection().prepareStatement(query);
                stmt.setString(i+1, rows.get(i).toString());
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }finally
        {
            System.out.println("Can't excecute the query");
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

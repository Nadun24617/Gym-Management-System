/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thanu
 */
import java.sql.*;
public class DBconnection {
 public static void main(String[]args)
    {
        try
        {
            Connection con=null;
            //Load the JDBC Driver
            Class.forName("com.mysql.cj.jbdc.Driver");
            //Establish the connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management_system","root","");
            //Create statement type object
            Statement stmt=con.createStatement();

        }
        catch(Exception e){
            System.out.println("Error!"+e.getMessage());}
    }
    
}

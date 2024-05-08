
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class payment1 {
    
    private String Cus_ID;
    
    public payment1(String Cus_ID){
        this.Cus_ID=Cus_ID;
    }
     public void getpayee() { 
    // Initialize connection, prepared statement, and result set
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null; 
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym management system", "root", "");
        // Prepare SQL statement to select name based on ID
        String sql = "SELECT First_N FROM customer WHERE Customer_ID = ?";
        preparedStatement = conn.prepareStatement(sql);

        // Set the customer ID
        preparedStatement.setString(1, Cus_ID);

        // Execute the SQL query
        resultSet = preparedStatement.executeQuery();

        // Check if a result is found
        if (resultSet.next()) {
            // Retrieve the name from the result set
            String Name = resultSet.getString("First_N");

            // Display the name
            System.out.println("Name: " + Name);
        } else {
            System.out.println("No name found for ID: " + Cus_ID);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the connection, prepared statement, and result set
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }   
    }
     


}

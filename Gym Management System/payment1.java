
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class payment1 {
    
    private String Cus_ID;
    private String Name;
    
    public payment1(String Cus_ID){
        this.Cus_ID=Cus_ID;
    }
     public String[] getPayeeInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null; 
        String[] payeeInfo = new String[2]; // Array to hold name and NIC

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym management system", "root", "");
            String sql = "SELECT First_N, NIC FROM customer WHERE Customer_ID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Cus_ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the name and NIC from the result set
                payeeInfo[0] = resultSet.getString("First_N"); // Name
                payeeInfo[1] = resultSet.getString("NIC"); // NIC
            } else {
                System.out.println("No name and NIC found for ID: " + Cus_ID);
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
        
        return payeeInfo;
    }


     
     //sdmfoksmd
             public void populateGrid() {
          try {
            // Establish connection to the MySQL database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym management system", "root", "");

           // Prepare SQL statement
           String query = "SELECT * FROM payments";
           PreparedStatement statement = conn.prepareStatement(query);

           // Execute query and get the result set
           ResultSet resultSet = statement.executeQuery();

           // Populate JTextPane with the result set
            StringBuilder stringBuilder = new StringBuilder();
          while (resultSet.next()) {
            // Assuming your 'payments' table has columns like 'customer_id', 'amount', 'payment_date', etc.
              int customerId = resultSet.getInt("customer_id");
              String paymentDate = resultSet.getString("date");
              String Type=resultSet.getString("type");
              double amount = resultSet.getDouble("amount");
              
              // Append the data to the StringBuilder
            stringBuilder.append("Customer ID: ").append(customerId)
                    .append(", Payment Date: ").append(paymentDate)
                    .append(", Type: ").append(Type)
                    .append(", Amount: ").append(amount)
                    .append("\n");

        }

        // Set the text of JTextPane with the populated data
        

        // Close resources
        resultSet.close();
        statement.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle any potential exceptions here
    }
             }

    String getpayee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     


}

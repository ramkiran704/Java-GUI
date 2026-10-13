import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/testdb"; // replace 'testdb' with your DB name
        String user = "root"; // replace with your MySQL username
        String password = "dev704@#ram"; // replace with your MySQL password

        // JDBC variables
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1️⃣ Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish the connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database successfully!");

            // 3️⃣ Create a statement
            stmt = con.createStatement();

            // 4️⃣ Execute SQL commands
            // Create a table (if not exists)
            String createTable = "CREATE TABLE IF NOT EXISTS students ("
                               + "id INT PRIMARY KEY AUTO_INCREMENT, "
                               + "name VARCHAR(50), "
                               + "age INT)";
            stmt.executeUpdate(createTable);

            // Insert sample data
            String insert = "INSERT INTO students (name, age) VALUES ('Alice', 20)";
            stmt.executeUpdate(insert);
            System.out.println("✅ Record inserted!");

            // Retrieve data
            String query = "SELECT * FROM students";
            rs = stmt.executeQuery(query);

            // Display the data
            System.out.println("\nStudent Table:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Age: " + rs.getInt("age"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database error!");
            e.printStackTrace();
        } finally {
            // 5️⃣ Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

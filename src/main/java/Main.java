import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/gym";
        String user = "root";
        String password = "";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        PrintWriter writer = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.prepareStatement("SELECT * FROM member");
            result = statement.executeQuery();
            writer = new PrintWriter("output.txt");

            while (result.next()) {
                writer.println(result.getInt("id") + ", " + result.getString("memberId")
                        +", " + result.getString("name") +", " + result.getString("address")
                        +", " + result.getString("phoneNum") +", " + result.getString("gender")
                        +", " + result.getString("schedule")+ ", " + result.getString("startDate")
                        +", " + result.getString("endDate") +", " + result.getString("price")
                        + ", " + result.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



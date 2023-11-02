import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    private final static String user = "postgres";
    private final static String password = "maks2004";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/training_hw_5", user, password);

            if (connection != null) {
                System.out.println("Connected");
                getData(connection, "audit_department");
            } else {
                System.out.println("not connected");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getData(Connection connection, String table) {
        Statement statement = null;
        ResultSet result = null;

        try {
            String query = "SELECT * FROM " + table;
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            System.out.print("Ревизионный номер изделия| ");
            System.out.print("Тип изделия| ");
            System.out.println("Адрес расположения");

            while (result.next()) {
                System.out.print(result.getString("Ревизионный номер изделия") + "| ");
                System.out.print(result.getString("Тип изделия") + "| ");
                System.out.print(result.getString("Адрес расположения"));
            }

        } catch (Exception e) {

        }
    }

}


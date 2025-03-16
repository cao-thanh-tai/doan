import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.*;

public class test extends SQLException {    
    String url="jdbc:mysql://localhost:3306/nhanvien";
    String username="root";
    String password="";
    //helllooooo
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/nhanvien";
        String username="root";
        String password="";
        system.out.print("hello");
        try {
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("ok r");
        } catch (Exception e) {
            System.out.println("loi r");
        }
        System.out.println("Hello, world!");
    }
}

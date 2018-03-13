import java.sql.*;

/**
 *
 * @author User
 */
public class Oracle_demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Computer_lab","computer_lab");
            Statement stmt=con.createStatement();
            ResultSet rst=stmt.executeQuery("select*from computer_student");

            while(rst.next())

            {    String computer_student=rst.getString(2);
                int student_id=rst.getInt(1);
                int student_age=rst.getInt(3);

                System.out.println(computer_student+" "+student_id+" "+student_age);
            }
            con.close();


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}


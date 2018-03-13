
import java.sql.*;


public class JDBC_demo {
    public static  void main(String [] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","ict16huma");
            Statement stmt=con.createStatement();

            String sql="update student set last='gutibaj' where first='nawrin'";
            stmt.executeUpdate(sql);

            ResultSet rs=stmt.executeQuery("select first, last, sub, grade from student inner join result on student.id=result.id" );
            while(rs.next())
            {
                String first=rs.getString("first");
                String last=rs.getString("last");
                System.out.println(first+" "+last+" "+rs.getString("grade")+" "+rs.getString("sub"));
            }



            con.close();
        }

        catch(Exception e)
        {
            System.out.println(e);

        }
    }
}

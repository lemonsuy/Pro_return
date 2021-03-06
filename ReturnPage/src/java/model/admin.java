package model;

import java.sql.*;

public class admin {

    private String username;
    private String password;
    private int id;

    public static void createSubject(subject[] s) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();
        int insertRound = 0;
        PreparedStatement ps = con.prepareStatement("insert into subject values(?,?,?)");
        for (int i = 0; i < s.length; i++) {
            ps.setInt(1, s[i].getId());
            ps.setString(2, s[i].getName());
            ps.setString(3, s[i].getCourse_id());
            insertRound += ps.executeUpdate();
        }
        System.out.println(insertRound + " recs inserted");
    }

    public static void EditSubjectById(int sid, String sname, String co_id) throws SQLException, ClassNotFoundException, NullPointerException {
try{
          Connection con = ConnectionBuilder.getConnection();
          String sql = "update subject set name = ?,course_id = ? where id = ?";
          PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1, sname);
              ps.setString(2, co_id);
              ps.setInt(3, sid);
            int rs = ps.executeUpdate();//แก้ตรงนี้
          
           }catch(SQLException e){
            System.out.println(e.getMessage());
        }
      }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*subject mySub[] = {new subject(3, "Mth101", "Calculus"),
            new subject(4, "Int105", "ComPro")};
        admin.createSubject(mySub);*/
        admin.EditSubjectById(2, "a", "b");
    }
}

package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class videos {

    private int id;
    private String title;
    private String desc;
    private String lecturer;
    private Timestamp date_time;
    private String path;
    private int subject_id;

    public static List<videos> findByTitle(String tname) {
        List<videos> video = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select * from videos where title like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + tname + "%");
            // Statement st = con.createStatement();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                videos v = new videos();
                v.setId(rs.getInt("id"));
                v.setTitle(rs.getString("title"));
                v.setDesc(rs.getString("desc"));
                v.setLecturer(rs.getString("lecturer"));
                v.setPath(rs.getString("path"));
                v.setSubject_id(rs.getInt("subject_id"));
                v.setDate_time(rs.getTimestamp("date_time"));
                if (video == null) {
                    video = new ArrayList<>();
                }
                video.add(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return video;
    }

    public static void main(String[] args) {
        List<videos> v = findByTitle("Cal");
        System.out.println(v +"eiei2");
        if (v != null) {
            for (videos ve : v) {
                System.out.println(ve.toString());
            }
        } else {
            System.out.println(v);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "videos{" + "id=" + id + ", title=" + title + ", desc=" + desc + ", lecturer=" + lecturer + ", date_time=" + date_time + ", path=" + path + ", subject_id=" + subject_id + '}';
    }

}

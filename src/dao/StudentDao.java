package dao;

import domain.Student;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /**
     * 按条件查询
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Student> findStudents(String sql, Object... params) {
        List<Student> students = new ArrayList<>(0);
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            Student stu = null;
            while (rs.next()) {
                int sid = rs.getInt("s_id");
                String sname = rs.getString("s_name");
                String ssex = rs.getString("s_sex");
                stu = new Student(sid, sname, ssex);
                students.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(conn, rs, pstmt);
        }
        return students;
    }

    /**
     * 添加学生
     *
     * @param sql
     * @param params
     */
    public void addStudent(String sql, Object... params) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(conn, null, pstmt);
        }
    }

    /**
     * 删除学生
     *
     * @param sql
     * @param params
     */
    public void deleteStudent(String sql, Object[] params) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(conn, null, pstmt);
        }
    }


    // --------------

}

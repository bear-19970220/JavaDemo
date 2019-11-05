package test;

import dao.StudentDao;
import domain.Student;
import org.junit.Test;

import java.util.List;

public class Demo {

    public static StudentDao studentDao = new StudentDao();

    @Test
    public void test_findStudent() {

        // 查询所有学生
        List<Student> students = studentDao.findStudents("select * from t_student");
        System.out.println(students);

        // 查询男学生
//        List<Student> studentsMale = studentDao.findStudents("select * from t_student where s_sex=?", "男");
//        System.out.println(studentsMale);

    }

    @Test
    public void test_addStudent() {
        String sql = "insert into t_student values(?,?,?)";
        Object[] params = {"张三", "男"};
        studentDao.addStudent(sql, params);
        System.out.println("添加成功！");
    }

    @Test
    public void test_deleteStudent() {
        String sql = "dleete from t_student where s_id = ?";
        Object[] params = {4};
        studentDao.deleteStudent(sql, params);
    }


}

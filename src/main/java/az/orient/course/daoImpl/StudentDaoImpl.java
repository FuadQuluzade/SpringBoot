package az.orient.course.daoImpl;

import az.orient.course.dao.StudentDao;
import az.orient.course.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private DataSource dataSource;

    @Override
    public List<Student> getStudentList() throws Exception {
        JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);
        String sql="select * from qrup45db.student where active=1";
        List<Student> studentList=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Student.class));
        return studentList;
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        String sql="select * from qrup45db.student where active=1 and id=?";
       List<Student> studentList= jdbcTemplate.query(sql,new Object[]{studentId}, new BeanPropertyRowMapper<>(Student.class));
       if(studentList.size()>0){
           return studentList.get(0);
       }
        return null;
    }

    @Override
    public void addStudent(Student student) throws Exception {
         JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
         String sql="insert into student(name,surname,address,dob,phone)" +
                 "values(?,?,?,?,?)";
         jdbcTemplate.update(sql,new Object[]{student.getName(),student.getSurname(),student.getAddress(),
                 student.getDob(),student.getPhone()});
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        String sql="update  student set name=?,surname=?,address=?,dob=?,phone=?" +
                "where id=?";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getSurname(),student.getAddress(),
                student.getDob(),student.getPhone(),student.getId()});
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        String sql="update  student set active=0" +
                "where id=?";
        jdbcTemplate.update(sql,new Object[]{studentId});
    }

    @Override
    public Integer countStudent() throws Exception {
        JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);
        String sql="select count(*) from qrup45db.student where active=1";
       Integer count=jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
}

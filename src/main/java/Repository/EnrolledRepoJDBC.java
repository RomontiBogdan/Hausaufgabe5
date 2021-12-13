package Repository;

import Entities.Enrollment;
import Entities.Teacher;

import java.nio.file.WatchEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnrolledRepoJDBC implements ICrudRepository<Enrollment>{
    private static Statement statement;
    private static ResultSet results;

    @Override
    public Enrollment create(Enrollment enrollment) {
        try(Connection conn = JDBCRepo.createDBconnection()){

            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO course-student " + "VALUES (" + enrollment.getIdcourse() + ", " +
                                        enrollment.getIdstudent() + ")" );

            System.out.println(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollment;
    }

    @Override
    public List<Enrollment> getAll() {
        String sql_select = "Select * From course-student";

        try(Connection conn = JDBCRepo.createDBconnection()){

            statement = conn.createStatement();
            results = statement.executeQuery(sql_select);

            List<Enrollment> enrollmentList = new ArrayList<Enrollment>();

            while (results.next()) {

                Enrollment enrollment = new Enrollment();

                enrollment.setIdcourse(Integer.parseInt(results.getString("idcourse")));
                enrollment.setIdstudent(Integer.parseInt(results.getString("idstudent")));

                enrollmentList.add(enrollment);
            }

            return enrollmentList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        try(Connection conn = JDBCRepo.createDBconnection()){
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE course-student " + "SET idcourse = " + enrollment.getIdcourse() + ", " +
                    "idstudent = " + enrollment.getIdstudent());

            return enrollment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Enrollment enrollment) {
        try(Connection conn = JDBCRepo.createDBconnection()){
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM course-student WHERE idcourse = " + enrollment.getIdcourse() + " AND idstudent = " + enrollment.getIdstudent());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

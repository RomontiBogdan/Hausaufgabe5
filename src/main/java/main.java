import Entities.Course;
import Entities.Student;
import Entities.Teacher;
import Repository.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        StudentRepoJDBC studentRepoJDBC = new StudentRepoJDBC();
        Student student = new Student();
        student.setStudentId(2);
        student.setFirstName("Pop");
        student.setLastName("Alex");
        student.setTotalCredits(5);
        //studentRepoJDBC.create(student);
        List<Student> studentList = studentRepoJDBC.getAll();
        for(Student s : studentList){
            System.out.println(s.getStudentId() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getTotalCredits());
        }
        studentRepoJDBC.delete(student);

        studentList = studentRepoJDBC.getAll();
        for(Student s : studentList){
            System.out.println(s.getStudentId() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getTotalCredits());
        }
    }
}

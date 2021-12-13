package Menu;

import Controller.RegistrationSystem;
import Entities.Course;
import Entities.Student;
import Entities.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    RegistrationSystem controller;

    public Menu(RegistrationSystem controller) {
        this.controller = controller;
    }

    public void menu() throws IOException {
        int option = 0;
        do {
            System.out.println("1. Add a student");
            System.out.println("2. Add a teacher");
            System.out.println("3. Add a course");
            System.out.println("4. Add a student");
            System.out.println("5. Add a teacher");
            System.out.println("6. Add a course");
            System.out.println("7. Delete a course");
            System.out.println("8. Register student to course");
            System.out.println("9. Show Courses With Free Places");
            System.out.println("10. Sort students by credits");
            System.out.println("11. Sort courses by credits");
            System.out.println("12. Filter students based on credits");
            System.out.println("13. Filter courses based on credits");
            System.out.println("14. Show students");
            System.out.println("15. Show teacher");
            System.out.println("16. Filter courses based on credits");
            System.out.println("17. Exit");
            Scanner myObj = new Scanner(System.in);
            option = myObj.nextInt();
            switch (option) {
                case 1 :
                    System.out.println("Id:");
                    int studentId = myObj.nextInt();
                    System.out.println("First name:");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String firstNameS = reader.readLine();
                    System.out.println("Last name:");
                    String lastNameS = reader.readLine();
                    Student student = new Student();
                    student.setStudentId(studentId);
                    student.setFirstName(firstNameS);
                    student.setLastName(lastNameS);
                    controller.addStudent(student);
                    break;
                case 2 :
                    System.out.println("Id:");
                    int teacherId = myObj.nextInt();
                    System.out.println("First name:");
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    String firstNameT = reader.readLine();
                    System.out.println("Last name:");
                    String lastNameT = reader.readLine();
                    Teacher teacher = new Teacher();
                    teacher.setTeacherId(teacherId);
                    teacher.setFirstName(firstNameT);
                    teacher.setLastName(lastNameT);
                    controller.addTeacher(teacher);
                    break;
                case 3:
                    System.out.println("Id:");
                    int courseId = myObj.nextInt();
                    System.out.println("Name:");
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    String name = reader.readLine();
                    System.out.println("Teacher id:");
                    int Idteacher = myObj.nextInt();
                    System.out.println("Credits:");
                    int credits = myObj.nextInt();
                    System.out.println("Max students:");
                    int maxStudents = myObj.nextInt();
                    Course course = new Course();
                    course.setCourseId(courseId);
                    course.setName(name);
                    course.setTeacher(controller.getByIdTeacher(Idteacher));
                    course.setCredits(credits);
                    course.setMaxStudendts(maxStudents);
                    controller.addCourse(course);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }while(true);
    }

}
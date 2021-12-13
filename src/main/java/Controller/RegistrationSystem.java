package Controller;

import Entities.Course;
import Entities.Enrollment;
import Entities.Student;
import Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationSystem {
    StudentController studentController;
    CourseController courseController;
    TeacherController teacherController;
    EnrollmentController enrollmentController;

    public RegistrationSystem(StudentController studentController, CourseController courseController, TeacherController teacherController, EnrollmentController enrollmentController) {
        this.studentController = studentController;
        this.courseController = courseController;
        this.teacherController = teacherController;
        this.enrollmentController = enrollmentController;
    }

    public void addCourse(Course course){
        courseController.addCourse(course);
    }

    public void addStudent(Student student){
        studentController.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        teacherController.addTeacher(teacher);
    }

    public void updateCourse(Course course){
        courseController.updateCourse(course);
    }

    public void updateStudent(Student student){
        studentController.updateStudent(student);
    }

    public void updateTeacher(Teacher teacher){
        teacherController.updateTeacher(teacher);
    }

    public void removeCourse(Course course){
        courseController.removeCourse(course);
    }

    public void removeStudent(Student student){
        studentController.removeStudent(student);
    }

    public void removeTeacher(Teacher teacher){
        teacherController.removeTeacher(teacher);
    }

    public Course getByIdCourse(int id){
        return courseController.getById(id);
    }

    public Student getByIdStudent(int id){
        return studentController.getById(id);
    }

    public Teacher getByIdTeacher(int id){
        return teacherController.getById(id);
    }

    public List<Course> getAllCourses(){
        return courseController.getAll();
    }

    public List<Student> getAllStudets(){
        return studentController.getAll();
    }

    public List<Teacher> getAllTeachers(){
        return teacherController.getAll();
    }

    public boolean register(Course course , Student student){
        if(student.getTotalCredits() + course.getCredits() > 30){
            return false;
        }

        if(course.getMaxStudendts() - enrollmentController.getEnrolledStudents(course).size() <= 0){
            return false;
        }

        List<Enrollment> enrollmentList = enrollmentController.getAll();
        for(Enrollment enrollment : enrollmentList){
            if(enrollment.getIdcourse() == enrollment.getIdcourse()){
                return false;
            }
        }
        Enrollment enrollment = new Enrollment((int) student.getStudentId(), course.getCourseId());

        enrollmentController.addEnrollment(enrollment);
        return true;
    }

    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> courseList = courseController.getAll();
        List<Course> freeCourses = new ArrayList<Course>();
        for(Course course : courseList){
            if(enrollmentController.getEnrolledStudents(course).size() < course.getMaxStudendts()){
                freeCourses.add(course);
            }
        }
        return freeCourses;
    }

    public int numberOfCredits(Student student){
        int total = 0;
        List<Enrollment> enrolls = enrollmentController.getEnrolledCourses(student);
        List<Course> enrolledCourses = new ArrayList<Course>();
        for(Enrollment enrollment : enrolls){
            enrolledCourses.add(courseController.getById(enrollment.getIdcourse()));
        }
        for(Course c : enrolledCourses){
            total += c.getCredits();
        }
        return total;
    }

    public List<Student> getSortedStudents(){
        return studentController.sortList();
    }

    public List<Course> getSortedCourses(){
        return courseController.sortList();
    }


}
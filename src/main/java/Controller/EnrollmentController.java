package Controller;

import Entities.Course;
import Entities.Enrollment;
import Entities.Student;
import Repository.ICrudRepository;

import java.util.List;

public class EnrollmentController {
    ICrudRepository repo;

    public EnrollmentController(ICrudRepository repo) {

        this.repo = repo;
    }

    public void addEnrollment(Enrollment enrollment){
        repo.create(enrollment);
    }

    public void updateEnrollment(Enrollment enrollment){
        repo.update(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment){
        repo.delete(enrollment);
    }

    public List<Enrollment> getAll(){
        return repo.getAll();
    }

    public List<Enrollment> getEnrolledStudents(Course course){
        List<Enrollment> enrollmentList = repo.getAll();
        for (Enrollment enrollment : enrollmentList)
            if(enrollment.getIdcourse() != course.getCourseId())
                enrollmentList.remove(enrollment);
        return enrollmentList;
    }

    public List<Enrollment> getEnrolledCourses(Student student){
        List<Enrollment> enrollmentList = repo.getAll();
        for (Enrollment enrollment : enrollmentList)
            if(enrollment.getIdcourse() != student.getStudentId())
                enrollmentList.remove(enrollment);
        return enrollmentList;
    }

}
package Controller;

import Entities.Course;
import Repository.ICrudRepository;

import java.util.Collections;
import java.util.List;


public class CourseController {
    private ICrudRepository repo;

    public CourseController(ICrudRepository repo) {
        this.repo = repo;
    }

    public void addCourse(Course c){
        this.repo.create(c);
    }

    public void updateCourse(Course course){
        repo.update(course);
    }

    public void removeCourse(Course c){
        repo.delete(c);
    }

    public List<Course> getAll(){
        return repo.getAll();
    }

    public Course getById(int id){
        List<Course> courseList = repo.getAll();
        for(Course course : courseList){
            if(course.getCourseId() == id){
                return course;
            }
        }
        return null;
    }

    public List<Course> sortList(){
        List<Course> courseList = repo.getAll();
        courseList.sort((c1, c2) -> {
            if (c1.getCourseId() < c2.getCourseId()) return -1;
            else if (c1.getCourseId() == c2.getCourseId()) return 0;
            return 1;
        });
        return courseList;
    }

    public List<Course> filterByCredits(int min){
        List<Course> courseList = repo.getAll();
        return courseList.stream().filter(course->course.getCredits() > min).toList();
    }

}
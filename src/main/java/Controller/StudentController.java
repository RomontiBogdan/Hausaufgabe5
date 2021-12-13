package Controller;

import Entities.Course;
import Entities.Student;
import Repository.ICrudRepository;

import java.util.List;

public class StudentController {
    private ICrudRepository repo;

    public StudentController(ICrudRepository repo) {
        this.repo = repo;
    }

    public void addStudent(Student student){
        this.repo.create(student);
    }

    public void updateStudent(Student student){
        repo.update(student);
    }

    public void removeStudent(Student student){
        repo.delete(student);
    }

    public List<Student> getAll(){
        return repo.getAll();
    }

    public Student getById(int id){
        List<Student> studentList = repo.getAll();
        for(Student student : studentList){
            if(student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    public List<Student> sortList(){
        List<Student> studentList = repo.getAll();
        studentList.sort((s1, s2) -> {
            if (s1.getTotalCredits() < s2.getTotalCredits()) return -1;
            else if (s1.getTotalCredits() == s2.getTotalCredits()) return 0;
            return 1;
        });
        return studentList;
    }

    public List<Student> filterByCredits(int min){
        List<Student> studentList = repo.getAll();
        return studentList.stream().filter(student->student.getTotalCredits() > min).toList();
    }

}
package Controller;

import Entities.Teacher;
import Repository.ICrudRepository;

import java.util.List;

public class TeacherController {
    private ICrudRepository repo;

    public TeacherController(ICrudRepository repo) {
        this.repo = repo;
    }

    public void addTeacher(Teacher teacher){
        this.repo.create(teacher);
    }

    public void updateTeacher(Teacher teacher){
        repo.update(teacher);
    }

    public void removeTeacher(Teacher teacher){
        repo.delete(teacher);
    }

    public List<Teacher> getAll(){
        return repo.getAll();
    }

    public Teacher getById(int id){
        List<Teacher> teacherList = repo.getAll();
        for(Teacher teacher : teacherList){
            if(teacher.getTeacherId() == id){
                return teacher;
            }
        }
        return null;
    }
}
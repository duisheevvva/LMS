package service;

import classes.Group;
import classes.Lessons;
import classes.Student;

import java.util.List;

public interface Service {

    void addNewGroup(List<Group>groups);
    void  getGroupbyName(List<Group>groups);
    void  updateGroupName(List<Group>groups);
    void  getAllGroups(List<Group>groups);
    void   addNewStudentToGroup(List<Group>groups);
    void  updateStudent(List<Group>groups);
    void findStudentByFirstName(List<Group> groups);
    void  getAllStudentsByGroupNAme(List<Group> groups);
    void  getAllStudentsLesson(List<Group> groups);
    void  deleteStudents(List<Student>students);
    void  addNewLessonToGroup(List<Group>groups);
    void  getLessonByName(List<Group>groups);
    void  getAllLessonsByGroupName(List<Group>groups);
    void  deleteLesson(List<Group> groups);
    void  deleteGroup(List<Group>groups);


}

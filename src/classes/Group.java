package classes;

import java.util.Arrays;
import java.util.List;

public class Group {
    private int id;
    private String groupName;
    private String discriptions;
    private List<Lessons> lessons;
    private List<Student> students;

    public Group(int id, String groupName, String discriptions) {
        this.id = id;
        this.groupName = groupName;
        this.discriptions = discriptions;
        this.lessons = lessons;
        this.students = students;
    }

    public Group() {

    }

    public Group(List<Lessons> lessons, List<Student> students) {
        this.lessons = lessons;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDiscriptions() {
        return discriptions;
    }

    public void setDiscriptions(String discriptions) {
        this.discriptions = discriptions;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\n\nGroup{" +
                "id :" + id +
                "\n groupName: " + groupName +
                "\n discriptions: " + discriptions +
                "\n lessons: " + lessons +
                "\n students: " + students +
                '}';
    }
}

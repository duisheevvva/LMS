package classes;

public class Lessons {
    private int id;
    private String lessonName;
    private String taskDiscription;

    public Lessons(int id, String lessonName, String taskDiscription) {
        this.id = id;
        this.lessonName = lessonName;
        this.taskDiscription = taskDiscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTaskDiscription() {
        return taskDiscription;
    }

    public void setTaskDiscription(String taskDiscription) {
        this.taskDiscription = taskDiscription;
    }

    @Override
    public String toString() {
        return "\n\nLessons{" +
                "id: " + id +
                "\n lessonName: " + lessonName +
                "\n taskDiscription: " + taskDiscription +
                '}';
    }
}

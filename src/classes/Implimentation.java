package classes;

import enums.Gender;
import exception.MyException;
import service.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Implimentation implements Service {
    private static int idCounter;
    private static int idLesson;


    @Override
    public void addNewGroup(List<Group> groups) {
        List<Student> students = new ArrayList<>();
        List<Lessons> lessons = new ArrayList<>();
        Group group = new Group(lessons, students);
        boolean isTrue = true;
        while (isTrue) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please, enter the name of the new group : ");
                String newGroup = scanner.nextLine();
                group.setStudents(new ArrayList<>());
                group.setLessons(new ArrayList<>());
                if (!groups.isEmpty() || groups.isEmpty()) {
                    for (Group groupName : groups) {
                        if (!groupName.equals(newGroup)) {
                            group.setGroupName(newGroup);
                            isTrue = false;
                        } else {
                            throw new MyException("Error");
                        }
                    }
                    group.setGroupName(newGroup);
                    System.out.print("Enter group discription : ");
                    String discription = scanner.nextLine();
                    group.setDiscriptions(discription);
                    isTrue = false;
                    Group group1 = new Group(groups.size() + 1, newGroup, discription);
                    groups.add(group1);
                    System.out.println(group1);
                }
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    @Override
    public void getGroupbyName(List<Group> groups) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Please, enter the group name to search : ");
        String search = scanner1.nextLine();
        for (Group group2 : groups) {
            if (group2.getGroupName().equalsIgnoreCase(search)) {
                System.out.println(group2);
            } else {
                System.err.println("Group not found!!!");
            }
        }
    }

    @Override
    public void updateGroupName(List<Group> groups) {
        boolean istrue2 = true;
        Group group1 = new Group();
        try {
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Please, enter group name : ");
            String oldName = scanner2.nextLine();
            System.out.print("Enter a new group name : ");
            String newName = scanner2.nextLine();
            for (Group group3 : groups) {
                if (group3.getGroupName().equals(oldName)) {
                    group3.setGroupName(newName);
                    System.out.println(group3);
                    istrue2 = true;
                    break;
                } else {
                    istrue2 = false;
                }
            }
            if (!istrue2) {
                throw new MyException("This group already exists!!!");
            }

        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void getAllGroups(List<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println(groups.get(i));
        }
    }

    @Override
    public void addNewStudentToGroup(List<Group> groups) {
        List<Student> students = new ArrayList<>();
        boolean isTrue5 = true;
        boolean isFalse = false;
        while (isTrue5) {
            try {
                System.out.print("Please, enter group name: ");
                String search = new Scanner(System.in).nextLine();
                for (Group group : groups) {
                    if (group.getGroupName().equals(search)) {
                        Student student = new Student();
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.print("first name: ");
                        String firstName = scanner3.nextLine();
                        student.setFirstName(firstName);
                        System.out.print("last name: ");
                        String lastName = scanner3.nextLine();
                        student.setLastName(lastName);
                        System.out.print("email: ");
                        String email = scanner3.nextLine();
                        student.setEmail(email);
                        System.out.print("password: ");
                        String password = scanner3.nextLine();
                        student.setPassword(password);
                        System.out.print("gender: ");
                        String gender = scanner3.nextLine();
                        student.setGender(Gender.valueOf(gender));
                        student.setId(++idCounter);
                        students.add(student);
                        group.setStudents(students);
                        isTrue5 = false;
                        isFalse = false;
                        break;
                    } else {
                        isFalse = true;
                    }
                }
                if (isFalse) {
                    throw new MyException("Error");
                }
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void updateStudent(List<Group> groups) {
        try {
            boolean isFalse = false;
            System.out.println("Enter email student");
            String email = new Scanner(System.in).nextLine();

            for (Group g : groups) {
                for (Student s : g.getStudents()) {
                    if (s.getEmail().equalsIgnoreCase(email)) {
                        System.out.println("Enter new name");
                        String newName = new Scanner(System.in).nextLine();
                        System.out.println("Enter new last name");
                        String lastName = new Scanner(System.in).nextLine();
                        s.setFirstName(newName);
                        s.setLastName(lastName);
                        System.out.println(s.toString());
                        isFalse = false;
                        break;
                    } else {
                        isFalse = true;
                    }
                    break;
                }

            }
            if (isFalse) {
                throw new MyException("Student not found");
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }

        @Override
        public void findStudentByFirstName (List <Group> groups) {
            Scanner scanner4 = new Scanner(System.in);
            System.out.print("Please, enter the student name to search : ");
            String search = scanner4.nextLine();
            boolean found = false;
            try {
                for (Group g : groups) {
                    for (Student student : g.getStudents()) {
                        if (student.getFirstName().equalsIgnoreCase(search)) {
                            System.out.println(student);
                            found = false;
                            break;
                        } else {
                            throw  new MyException("Error");
                        }
                    }
                    if (found) {
                        System.err.println("No such student!!!");
                    }
                }
            }catch(MyException e){
                System.out.println(e.getMessage());
            }

        }

        @Override
        public void getAllStudentsByGroupNAme (List < Group > groups) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please enter the group name to search: ");
                String search = scanner.nextLine();
                boolean foundGroup = false;
                for (Group group : groups) {
                    if (group.getGroupName().equalsIgnoreCase(search)) {
                        System.out.println("Students in group " + search + ":");
                        System.out.println(group.getStudents());
                        foundGroup = false;
                    } else {
                        foundGroup = true;
                    }
                }
                if (foundGroup) {
                    throw new MyException("Group not found!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }


        @Override
        public void getAllStudentsLesson (List < Group > groups) {
            try {
                boolean isFalse = false;
                System.out.println("Enter email");
                String email = new Scanner(System.in).nextLine();
                for (Group g : groups) {
                    for (Student s : g.getStudents()) {
                        if (s.getEmail().contains(email)) {
                            System.out.println(g.getLessons());
                            isFalse = false;
                            break;
                        } else {
                            isFalse = true;
                        }
                    }
                }
                if (isFalse) {
                    throw new MyException("Student not found");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }


        @Override
        public void deleteStudents (List < Student > students) {
            try {
                boolean isFalse = true;
                System.out.print("Enter student email: ");
                String email = new Scanner(System.in).nextLine();
                for (Student s : students) {
                    isFalse = true;
                    if (s.getEmail().equalsIgnoreCase(email)) {
                        students.remove(s);
                        System.out.println(" Student: " + email + " delete ");
                    } else {
                        isFalse = false;
                    }
                }
                if (!isFalse) {
                    throw new MyException("Student: " + email + "not faund!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }

        @Override
        public void addNewLessonToGroup (List < Group > groups) {
            boolean isFalse = false;
            try {
                System.out.println("Enter group name: ");
                String groupName = new Scanner(System.in).nextLine();
                for (Group group : groups) {
                    if (group.getGroupName().equalsIgnoreCase(groupName)) {
                        System.out.println("Enter lesson name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("Enter lesson discription");
                        String discription = new Scanner(System.in).nextLine();
                        Lessons lessons = new Lessons(++idLesson, name, discription);
                        List<Lessons> lessons1 = new ArrayList<>();
                        lessons1.add(lessons);
                        group.setLessons(lessons1);
                        isFalse = false;
                    } else {
                        isFalse = true;
                    }
                }
                if (isFalse) {
                    throw new MyException("not found group!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }


        }

        @Override
        public void getLessonByName (List < Group > groups) {
            boolean isFalse = false;
            try {
                System.out.println("Enter lesson name: ");
                String name = new Scanner(System.in).nextLine();
                for (Group g : groups) {
                    for (Lessons l : g.getLessons()) {
                        if (l.getLessonName().equalsIgnoreCase(name)) {
                            System.out.println(g);
                            isFalse = false;
                            break;
                        } else {
                            isFalse = true;
                        }
                    }
                }
                if (isFalse) {
                    throw new MyException("not found");

                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }

        @Override
        public void getAllLessonsByGroupName (List < Group > groups) {
            boolean isFalse = false;
            try {
                System.out.println("Enter group name");
                String name = new Scanner(System.in).nextLine();
                for (Group g : groups) {
                    if (g.getGroupName().equalsIgnoreCase(name)) {
                        System.out.println(g.getLessons());
                        isFalse = false;
                        break;
                    } else {
                        isFalse = true;
                    }
                }
                if (isFalse) {
                    throw new MyException("Group not found");
                }
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }
        }


        @Override
        public void deleteLesson (List < Group > groups) {
            try {
                boolean isFalse = true;
                System.out.print("Enter lesson name ");
                String name = new Scanner(System.in).nextLine();
                for (Group g : groups) {
                    for (Lessons l : g.getLessons()) {
                        if (l.getLessonName().equalsIgnoreCase(name)) {
                            g.getLessons().remove(l);
                            System.out.println("Lesson: " + name + " delete ");
                            isFalse = true;
                            break;
                        } else {
                            isFalse = false;
                        }
                    }
                }
                if (!isFalse) {
                    throw new MyException("Lesson: " + name + "not found!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }

        @Override
        public void deleteGroup (List < Group > groups) {
            try {
                boolean isFalse = true;
                System.out.print("Enter group name");
                String name = new Scanner(System.in).nextLine();
                for (Group g : groups) {
                    if (g.getGroupName().equalsIgnoreCase(name)) {
                        groups.remove(g);
                        System.out.println("Lesson: " + name + " delete ");
                        isFalse = true;
                        break;
                    } else {
                        isFalse = false;
                    }
                }
                if (!isFalse) {
                    throw new MyException("Lesson: " + name + "not found!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }
    }

import classes.*;
import exception.MyException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {

        List<Group> groups = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Lessons> lessons = new ArrayList<>();
        System.out.println("Good day! " + " time: " + LocalTime.now());
        Scanner scanner1 = new Scanner(System.in);
        Admin admin = new Admin();
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("Please,enter 0 to start");
                int start = new Scanner(System.in).nextInt();
                switch (start) {
                    case 0 -> {
                        boolean isTrue1 = true;
                        System.out.print("Enter admin gmail : ");
                        admin.setAdminGmail(scanner1.nextLine());
                        System.out.print("Enter admin password : ");
                        admin.setAdminPassword(scanner1.nextLine());
                        while (isTrue1) {
                            System.out.println("*** Choose a team! ***\n" +
                                    "//        1  -> Add new group\n" +
                                    "//        2  -> Get group by name\n" +
                                    "//        3  -> Update group name\n" +
                                    "//        4  -> Get all groups\n" +
                                    "//        5  -> Add new student to group\n" +
                                    "//        6  -> Update student\n" +
                                    "//        7  -> Find student by first name\n" +
                                    "//        8  -> Get all students by group name\n" +
                                    "//        9  -> Get all student's lesson\n" +
                                    "//        10 -> Delete student\n" +
                                    "//        11 -> Add new lesson to group\n" +
                                    "//        12 -> Get lesson by name\n" +
                                    "//        13 -> Get all lesson by group name\n" +
                                    "//        14 -> Delete lesson\n" +
                                    "//        15 -> Delete group");

                            int select = new Scanner(System.in).nextInt();
                            Implimentation implimentation = new Implimentation();
                            switch (select) {
                                case 1 -> {
                                    implimentation.addNewGroup(groups);
                                    System.out.println();
                                }
                                case 2 -> implimentation.getGroupbyName(groups);
                                case 3 -> implimentation.updateGroupName(groups);
                                case 4 -> implimentation.getAllGroups(groups);
                                case 5 -> implimentation.addNewStudentToGroup(groups);
                                case 6 -> implimentation.updateStudent(groups);
                                case 7 -> implimentation.findStudentByFirstName(groups);
                                case 8 -> implimentation.getAllStudentsByGroupNAme(groups);
                                case 9 -> implimentation.getAllStudentsLesson(groups);
                                case 10 ->implimentation.deleteStudents(students);
                                case 11 ->implimentation.addNewLessonToGroup(groups);
                                case 12 ->implimentation.getLessonByName(groups);
                                case 13 ->implimentation.getAllLessonsByGroupName(groups);
                                case 14 ->implimentation.deleteLesson(groups);
                                case 15 ->implimentation.deleteGroup(groups);


                            }
                        }
                    }
                    case 1 -> {
                        isTrue = false;
                    }
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}



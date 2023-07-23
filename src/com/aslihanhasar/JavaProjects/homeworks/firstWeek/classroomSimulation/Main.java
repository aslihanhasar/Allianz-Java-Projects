package com.aslihanhasar.JavaProjects.homeworks.firstWeek.classroomSimulation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Map<String, List<String>> classroomsWithStudents = new HashMap<>();
        List<String> students = getStudentsData();

        classroomsWithStudents.put("Classroom 1-A", new ArrayList<>());
        classroomsWithStudents.put("Classroom 2-A", new ArrayList<>());
        classroomsWithStudents.put("Classroom 3-A", new ArrayList<>());
        classroomsWithStudents.put("Classroom 4-A", new ArrayList<>());
        classroomsWithStudents.put("Classroom 5-A", new ArrayList<>());

        // randomly assigns students to classes
        for (String s : students) {
            int randomAssignValue = random.nextInt(classroomsWithStudents.size()) + 1;
            String classroom = "Classroom " + randomAssignValue + "-A";
            classroomsWithStudents.get(classroom).add(s);
        }

        //prints students whose names end with "an" and their classes
        for (String classroom : classroomsWithStudents.keySet()) {
            List<String> studentsInClassroom = classroomsWithStudents.get(classroom);
            for (String student : studentsInClassroom) {
                boolean nameEndsWith = isNameEndWith(student);
                if (nameEndsWith) {
                    System.out.println(classroom + " - " + student);
                }
            }
        }
    }

    /**
     * A method that checks the student's name ends with "an".
     *
     * @param studentName the student name to be checked
     * @return If the name ends with "an" or not
     */
    public static boolean isNameEndWith(String studentName) {
        String[] splitName = studentName.split(" ");
        for (int i = 0; i < splitName.length - 1; i++) {
            if (splitName[i].endsWith("an")) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Data added to the students list
     */
    public static List<String> getStudentsData() {
        List<String> students = new ArrayList<>();
        students.add("Aslıhan Hasar");
        students.add("Dila  Unus");
        students.add("Ahmet Mümtaz Taylan");
        students.add("John Bush Josuah");
        students.add("Selin Can");
        students.add("Kamur Kerime Kanan Yılmaz");
        students.add("Ayşe Canlı ");
        students.add("Ozan Toktop");
        students.add("Ali Öztürk");
        students.add("Gamze Canbaz");
        students.add("Serkan Cangeç");
        students.add("Neslihan Unus");
        students.add("Deniz Şensoy");
        students.add("Canan Tekin");
        students.add("İrem Cancuvaş");
        students.add("Ahmet Canberk");
        students.add("Zilan Balan");
        students.add("Elif Demir");
        students.add("Nihan Korkmaz");
        students.add("Kenan Serin");
        students.add("Aycan Ciğer");
        students.add("Burhan Canpolat");
        students.add("Canberk Aydın");
        students.add("Mehmet Yılmaz");
        students.add("Banu Cankurtaran");
        students.add("İsmail Öztürk");
        students.add("Cansu Toker");
        return students;
    }
}

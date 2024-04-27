package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsDriver {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        System.out.println(studentsWhoseFirstNameStartsWithAlphabetA(list));
    }

    /*TODO: 1- Find list of students whose first name starts with alphabet A*/

    public static List<Student>  studentsWhoseFirstNameStartsWithAlphabetA(List<Student> list){

        List<Student> aLetter = list.stream().filter(s -> s.getFirstName().startsWith("A")).collect(Collectors.toList());
        return aLetter;
    }

    /*TODO:  Group The Student By Department Names*/

    public static Map<String,List<Student>> GroupTheStudentByDepartmentNames(List<Student> list){

        Map<String,List<Student>> groupByStudentDepartmentName = list.stream().collect(Collectors.groupingBy(Student :: getDepartmantName));

        /*TODO - Find the total count of student using stream*/

        Long countStudent = list.stream().count();
        System.out.println("Total count of students : "+countStudent);

        /*TODO Find the max age of student*/

        OptionalInt maxAge = list.stream().mapToInt(s -> s.getAge()).max();
        System.out.println("Max age of student : "+maxAge.getAsInt());

        /*TODO: Find all departments names*/
        List<String> deptNames = list.stream().map(s -> s.getDepartmantName()).distinct().collect(Collectors.toList());
        System.out.println("All distinct department names : "+deptNames);

        /*TODO: - Find the count of student in each department*/

        Map<String, Long> countStudentInEachdept = list.stream().collect(Collectors.groupingBy(Student :: getDepartmantName,Collectors.counting()));
        System.out.println("Student count in each department : "+countStudentInEachdept);


        /*TODO:  Find the list of students whose age is less than 30*/

        List<Student> ageAboveThirty = list.stream().filter(student -> student.getAge() < 30).collect(Collectors.toList());
        System.out.println("List of students whose age is less than 30 : "+ageAboveThirty);

        /*TODO: Find the list of students whose rank is in between 50 and 100*/

        List<Student> rankBetween50And100 = list.stream().filter(student -> student.getRank() >50 && student.getRank() <100).collect(Collectors.toList());
        System.out.println("List of students whose rank is between 50 and 100 : "+rankBetween50And100);

        /*TODO Find the average age of male and female students*/

        Map<String,Double> mapAvgAge = list.stream().collect(Collectors.groupingBy(Student :: getGender,Collectors.averagingInt(Student ::getAge)));
        System.out.println("Average age of male and female students : "+mapAvgAge);

        /*TODO : Find the department who is having maximum number of students*/

        Map.Entry<String,Long> entry = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Department having maximum number of students : "+entry);

        /*TODO Find the Students who stays in Delhi and sort them by their names */

        List<Student> delhiStudents = list.stream().filter(student -> student.getCity().equalsIgnoreCase("Delhi")).sorted( Comparator.comparing(Student ::getFirstName)).collect(Collectors.toList());
        System.out.println("List of students who stays in Delhi and sort them by their names : "+delhiStudents);

        /*TODO Find the average rank in all departments
         */

        Map<String,Double> mapAvgRankInALLDepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)));


        /*TODO: Find the highest rank in each department*/

        Map<String,Optional<Student>> studentData = list.stream().collect(Collectors.groupingBy(Student :: getDepartmantName,Collectors.minBy(Comparator.comparing(Student ::getRank))));


        /*TODO Find the list of students and sort them by their rank
         */

        List<Student> studentList = list.stream().sorted(Comparator.comparing(Student :: getRank)).collect(Collectors.toList());


        /*TODO Find the student who has second rank*/

        Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();

        return groupByStudentDepartmentName;
    }





}

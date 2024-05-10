package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamRevision2 {

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



        /*TODO: 1- Find list of students whose first name starts with alphabet A*/

        List<Student> newList = list.stream().filter(s -> s.getFirstName().startsWith("A")).toList();

        /*TODO:  Group The Student By Department Names*/

        Map<String,List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));

        /*TODO - Find the total count of student using stream*/

        long totalCount = list.stream().count();

        /*TODO: Find all departments names*/
        List<String> deptNames = list.stream().filter(Objects::nonNull).map(Student::getDepartmantName).toList();


        /*TODO Find the max age of student*/
        OptionalInt magAge = list.stream().mapToInt(Student::getAge).max();


        /*TODO: - Find the count of student in each department*/

        Map<String,Long> countOfStudentInEachDepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));

        /*TODO:  Find the list of students whose age is less than 30*/
        List<Student> studentListBelowAge30 = list.stream().filter(student -> student != null &&  student.getAge() < 30).toList();

        /*TODO: Find the list of students whose rank is in between 50 and 100*/
        List<Student> studentListRank50To100 = list.stream().filter(student -> student !=null && student.getRank() >50 && student.getRank() <100).toList();

        /*TODO Find the average age of male and female students*/

        Map<String,Double> mapAvgAge = list.stream().collect(Collectors.groupingBy(Student ::getGender,Collectors.averagingInt(Student::getAge)));
        mapAvgAge.forEach((key, value) -> System.out.println(key + ": " + value));

        /*TODO : Find the department who is having maximum number of students*/
        Map.Entry<String, Long> deptDetails = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(deptDetails);

        /*TODO Find the Students who stays in Delhi and sort them by their names */
        List<Student> studentListDelhi = list.stream().filter(student -> student.getCity().equalsIgnoreCase("delhi")).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toUnmodifiableList());

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        /*TODO Given a list of integers, separate odd and even numbers*/


    }
}

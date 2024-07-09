package streams.revision;

import streams.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayOne {

    /*TODO: 1- Find list of students whose first name starts with alphabet A*/

    public static List<Student> studentsWhoseFirstNameStartsWithAlphabetA(List<Student> list) {

        List<Student> studentList = list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
        return studentList;
    }


    /*TODO:  Group The Student By Department Names*/

    public static Map<String, List<Student>> GroupTheStudentByDepartmentNames(List<Student> list) {

        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        strings.stream().map(String ::toUpperCase).collect(Collectors.toList());

        int[] arr = {1,2,3,4,5,6,7};
        List<Integer> listss  = Arrays.stream(arr).map(n -> n * n).boxed().collect(Collectors.toList());

        /*TODO - Find the total count of student using stream*/

        Long countStudent = list.stream().count();
        System.out.println("Total count of students : " + countStudent);

        /*TODO Find the max age of student*/

        OptionalInt maxAge = list.stream().mapToInt(s -> s.getAge()).max();

        System.out.println("Max age of student : " + maxAge.getAsInt());

        /*TODO: Find all departments names*/
        List<String> deptNames = list.stream().map(s -> s.getDepartmantName()).distinct().collect(Collectors.toList());
        List<String> deptNamess = list.stream().map(Student::getDepartmantName).distinct().collect(Collectors.toUnmodifiableList());
      //  List<String> deptNamesss = list.stream().map(Student::getDepartmantName + " "+ Student::getFirstName).distinct().collect(Collectors.toUnmodifiableList())
        list.stream().map(student -> "DeptName "+student.getDepartmantName() +", FirstName "+ student.getFirstName()).collect(Collectors.toUnmodifiableList());
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        listOfLists.stream().flatMap(List::stream).map(n -> n*n).collect(Collectors.toList());

        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.mapping(Student::getFirstName,Collectors.toList())));

        Map<String,Integer> listToMap =list.stream().collect(Collectors.toMap(Student::getFirstName,Student::getAge));

        System.out.println("All distinct department names : " + deptNames);

        List<Integer> oddlist = listOfLists.stream().flatMap(List ::stream).filter(n -> n%2 !=0).collect(Collectors.toList());

        List<String> sentences = Arrays.asList(
                "The quick brown fox",
                "jumps over the lazy dog",
                "and runs away"
        );

        Set<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // Count vowels in a string
        String s1 = "Hello World";
        long vowelCount = s1.chars().mapToObj(c -> (char) c).filter(c -> List.of('a','e','i','o','u').contains(Character.toLowerCase(c))).count();
        String reverseWords = Arrays.stream(s1.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        Map.Entry<Character,Long> count   = s1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
                .orElse(null);



        /*TODO: - Find the count of student in each department*/

        Map<String, Long> countStudentInEachdept = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println("Student count in each department : " + countStudentInEachdept);

        /*TODO:  Find the list of students whose age is less than 30*/

        List<Student> ageAboveThirty = list.stream().filter(student -> student.getAge() < 30).collect(Collectors.toList());
        System.out.println("List of students whose age is less than 30 : " + ageAboveThirty);

        /*TODO: Find the list of students whose rank is in between 50 and 100*/

        List<Student> rankBetween50And100 = list.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100).collect(Collectors.toList());
        System.out.println("List of students whose rank is between 50 and 100 : " + rankBetween50And100);

        /*TODO Find the average age of male and female students*/

        Map<String, Double> mapAvgAge = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male and female students : " + mapAvgAge);

        /*TODO : Find the department who is having maximum number of students*/

        Map.Entry<String, Long> entry = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Department having maximum number of students : " + entry);

        /*TODO Find the Students who stays in Delhi and sort them by their names */

        List<Student> delhiStudents = list.stream().filter(student -> student.getCity().equalsIgnoreCase("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
        System.out.println("List of students who stays in Delhi and sort them by their names : " + delhiStudents);

        /*TODO Find the average rank in all departments.*/

        Map<String, Double> mapAvgRankInALLDepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));


        /*TODO: Find the highest rank in each department*/

        Map<String, Optional<Student>> studentData = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));


        /*TODO Find the list of students and sort them by their rank
         */

        List<Student> studentList = list.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());


        /*TODO Find the student who has second rank*/

        Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();

      //  Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));


        return null;
    }
}







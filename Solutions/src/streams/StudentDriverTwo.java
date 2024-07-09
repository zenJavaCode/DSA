package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDriverTwo {
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
      //  List<Student> aLetterNameList = list.stream().filter(s ->s.getFirstName().startsWith("A")).toList();


        /*TODO:  Group The Student By Department Names*/
        Map<String,List<Student>> departmentGroups = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));



        /*TODO Find the max age of student*/
        OptionalInt maxAge = list.stream().mapToInt(s -> s.getAge()).max();

        /*TODO: - Find the count of student in each department*/
        Map<String,Long> studentCountInEachDept = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));

        /*TODO:  Find the list of students whose age is less than 30*/
        List<Student> studentListBelow30 = list.stream().filter(s -> s.getAge() <30).toList();

        /*TODO Find the average age of male and female students*/

       OptionalDouble averageAgeMale = list.stream().filter(s ->s.getGender().equalsIgnoreCase("Male")).mapToInt(Student::getAge).average();

       Map<String, Double> averageAge = list.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));

        /*TODO: - Find the count of student in each department*/
        Map<String, Long> count = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));


        /*  TODO : *** Find the department who is having maximum number of students  ***  */

        Map.Entry<String, Long> counts = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();

        /*TODO Find the average rank in all departments */

        Map<String, Double> averageRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)));

        /*TODO: Find the highest rank in each department*/
        Map<String, Optional<Student>> highestRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.minBy(Comparator.comparing(Student::getRank))));

        /*TODO Find the list of students and sort them by their rank */

        List<Student> sortedByRankList = list.stream().sorted(Comparator.comparing(Student::getRank)).toList();

        /*TODO Find the student who has second rank*/

        Student secondRank = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();

        /*TODO Group the students by their branch of study (e.g., Mechanical Engineering, Computer Engineering, etc.) and calculate the average age for each group.*/

        Map<String,Double> averageByAge = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getAge)));

        /*TODO Partition the students into two lists: one for male students and another for female students.*/
        list.stream().collect(Collectors.partitioningBy(s -> s.getGender().equalsIgnoreCase("Male")));

        Map<Boolean,List<Student>> listGenderPartition = list.stream().collect(Collectors.partitioningBy(s -> s.getGender().equalsIgnoreCase("Male")));
        List<Student> male = listGenderPartition.get(true);
        List<Student> female = listGenderPartition.get(false);

/* TODO Assuming each student has a list of courses they are enrolled in, create a flat list of all courses across all students.*/


        List<String> allDepartments = list.stream().map(Student ::getDepartmantName).distinct().toList();


        /*How to flatten a 2D array in streams*/

        int[][] twoDArray = {{1, 2, 3}, {4, 5, 6}};

        int[] flattenArray = Arrays.stream(twoDArray).flatMapToInt(ints -> Arrays.stream(ints)).toArray();

        /*TODO Find the average of squares*/


        int[] input = {1,2,3,4,5};
        OptionalDouble squares = Arrays.stream(input).map(i -> i*i).average();

        String[] listx = {"apple", "", "banana", "cherry", "", "date"};


        List<String> s = Arrays.stream(listx).filter(dy -> !dy.isEmpty()).map(String ::toUpperCase).toList();
        s.forEach(System.out::println);


        String longestWord = Arrays.stream(listx).max(Comparator.comparing(String:: length)).orElse("");






    }


}

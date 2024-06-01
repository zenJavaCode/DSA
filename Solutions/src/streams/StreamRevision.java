package streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamRevision {

    /*TODO: 1- Find list of students whose first name starts with alphabet A*/

    static List<Student> studentList(List<Student> list) {

        List<Student>   result = list.stream().filter(s -> s.getFirstName().startsWith("A")).collect(Collectors.toList());
        return result;
    }

    /*TODO:  Group The Student By Department Names*/

        public static Map<String,List<Student>> getStudentByDepartmentName(List<Student> list){
            Map<String,List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
            return map;
        }

    /*TODO - Find the total count of student using stream*/

    public static long getTotalCountOfStudents(List<Student> list){

        return list.stream().count();
    }

    /*TODO Find the max age of student*/

    public static int maxAge(List<Student> list){

        return list.stream().mapToInt(Student::getAge).max().orElse(0);
    }

    /*TODO: Find all departments names*/

    public static List<String> getDepartmentNames(List<Student> list){

        return list.stream().map(Student::getDepartmantName).distinct().collect(Collectors.toList());
    }

    /*TODO: - Find the count of student in each department*/

    static Map<String,Long>  getCountOfStudents(List<Student> list){
        return list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
    }

    /*TODO:  Find the list of students whose age is less than 30*/
    static List<Student> getStudentsAgeLessThan30(List<Student> list){
        return list.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
    }
    /*TODO: Find the list of students whose rank is in between 50 and 100*/
    static List<Student> getStudentsRankBetween(List<Student> list) {
    return list.stream().filter(s -> s.getRank() >50 && s.getRank() < 100).collect(Collectors.toList());
    }

    /*TODO Find the average age of male and female students*/
    static Map<String,Double> mapAvgAge (List<Student> list) {
        Map<String, Double> mapAvgAge = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male and female students : " + mapAvgAge);
        return mapAvgAge;
    }


    public static void main(String[] args) {
        ArrayList<String> inputArr = new ArrayList<>();
        inputArr.add("AB");
        inputArr.add("BB");
        inputArr.add("AA");
        inputArr.add("AB");
        inputArr.add("ABC");

     //   Here's a Java 8 program that finds duplicate elements and their count from a given ArrayList of Strings:

        Map<String,Long> map = inputArr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                                  .filter(entry ->entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        map.entrySet().stream().filter(entry -> entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        map.forEach((key,valye) -> System.out.println(key+" : "+valye));
    }


}

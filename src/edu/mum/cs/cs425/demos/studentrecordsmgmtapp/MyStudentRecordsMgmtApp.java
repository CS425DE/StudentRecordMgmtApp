package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {

        Student s1 = new Student(110001,"Dave", LocalDate.of(1951,11,18));
        Student s2 = new Student(110002,"Anna", LocalDate.of(1990,12,07));
        Student s3 = new Student(110003,"Erica", LocalDate.of(1974,01,31));
        Student s4 = new Student(110004,"Carlos", LocalDate.of(2009,8,22));
        Student s5 = new Student(110005,"Bob", LocalDate.of(1990,03,05));

        List<Student> studentList = Arrays.asList(s1,s2,s3,s4,s5);
        //print list of students
        printListOfStudents(studentList);
        //print list of platinum students
        getListOfPlatinumAlumniStudents(studentList);

        solution3b();

    }

    private static void solution3b() {
        System.out.println("=== Solution 3.5  ====");
        int[] inputNumbers = {10, 14, 15, 20, 21, 35, 42};
        printHelloWorld(inputNumbers);
        System.out.println("=== Solution 3.5  2 ====");
        findSecondBiggest(inputNumbers);
        findSecondBiggest(new int[]{1,2,3,4,5});
        findSecondBiggest(new int[]{19,9,11,0,12});
    }

    private static void findSecondBiggest(int[] inputNumbers) {

        int max = inputNumbers[0];
        int secondMax = inputNumbers[0];
        for (int number : inputNumbers) {
            if(number > max){
                secondMax = max;
                max = number;
            }

        }
        System.out.println(" Second Max : " + secondMax);

    }

    private static void printHelloWorld(int[] numbers) {
        System.out.println("=== Solution 3.5  1 ====");

        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (number % 5 == 0) {
                System.out.println("Hello");
            } else if (number % 7 == 0) {
                System.out.println("World");
            } else {
                System.out.println(number);
            }
        }

    }

    private static void printListOfStudents(List<Student> studentList) {
        System.out.println("=====List of Students=====");
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        studentList.stream().forEach(System.out::println);

    }

    private static void getListOfPlatinumAlumniStudents(List<Student> studentList) {
        System.out.println("*****List of Platinum Students*****");
        List<Student> platinumStudentList = studentList.stream().
                filter(s -> LocalDate.now().minusYears(30).isAfter(s.getDateOfAdmission()))
                .collect(Collectors.toList());

        Collections.sort(platinumStudentList, Comparator.comparing(Student::getDateOfAdmission).reversed());
        platinumStudentList.stream().forEach(System.out::println);
    }
}

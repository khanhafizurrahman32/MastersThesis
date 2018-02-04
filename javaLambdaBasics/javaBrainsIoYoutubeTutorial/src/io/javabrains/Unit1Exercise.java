package io.javabrains;

import java.util.*;

/**
 * Created by khanhafizurrahman on 1/20/18.
 */
public class Unit1Exercise {
    public  static void main(String[] args){
        List<Person> people = Arrays.asList(
                new Person("Charlse","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Thomas","Carlyle", 51),
                new Person("Charlotte","Bronte", 45),
                new Person("Matthew","Arnold", 39)
        );

        // Step 1: Sort list by last name
        // solution without lambda or in java7
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//               return  o1.getLastName().compareTo(o2.getLastName());
//            }
//        });

        // solution with lambda

//        Collections.sort(people,(Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));
        Collections.sort(people,(o1,o2) -> o1.getLastName().compareTo(o2.getLastName()));



        // Step 2: Create a method that prints all elements in the list
        printAll(people);

        // Step 3: Create a method that prints all people that have last name beginning with C
//        printLastNameBeginningWithC(people);
        // print Conditionally helps us to send number of conditions to send and execute
//        printConditionally(people, new Condition() {
//            @Override
//            public boolean test(Person p) {
//                return p.getLastName().startsWith("C");
//            }
//        });
        printConditionally(people, p-> p.getLastName().startsWith("C"));
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p: people){
            if(condition.test(p)){
                System.out.println(p);
            }
        }
    }

    private static void printLastNameBeginningWithC(List<Person> people) {
        for (Person p: people){
            if(p.getLastName().startsWith("C")){
                System.out.println(p);
            }
        }
    }

    private static void printAll(List<Person> people){
        for (Person p: people){
            System.out.println(p);
        }
    }
}

interface Condition{
    boolean test(Person p);
}
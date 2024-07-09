package StreamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    /* Followings are functional interface
Predicate - boolean result
consumer - no result
function - input and output
Supplier - no input only supply
 */

public class StreamMain1 {
    public static void main(String[] args) {
        //Create a list and filter all even numbers from list
        List<Integer> list1 = List.of(2,3,4,50,21,22,69);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(23);
        list2.add(20);
        list2.add(0);
        list2.add(45);
        list2.add(50);

        System.out.println("Even numbers in list2: ");
        list2.stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList())
                    .stream()
                        .forEach(System.out::println);

        System.out.println("Even numbers in list1: ");
        list1.stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList())
                    .stream()
                        .forEach(System.out::println);

        // print all numbers which are greater than the average

        Double avg = list2.stream()
                            .mapToInt(a->a)
                            .average()
                            .getAsDouble();
        System.out.println("Numbers which are greater than average "+avg+" in list2: ");

        list2.stream()
                .filter(i->i>= avg)
                .collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);


        // Find name of the batsmen whose avg  are greater than avg of all batsmen

        Map<String,Integer> map1 = Map.of("Sachin",98,"Virat" ,87,"Rohit",80,"Ganguly" ,75,"Dravid",77,"Jadeja",50);
        System.out.println(map1);



        map1.keySet().stream()
                .filter(ele->map1.get(ele)>map1.entrySet().stream()
                        .mapToInt(e-> e.getValue())
                        .average()
                        .getAsDouble())
                .collect(Collectors.toList())
                .forEach(System.out::println);



    }


}

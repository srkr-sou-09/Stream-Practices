package StreamApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date joiningDateRam = dateFormat.parse("01-01-2000");
        Date joiningDateSita = dateFormat.parse("15-05-1995");
        Date joiningDateVishnu = dateFormat.parse("10-12-1998");
        Date joiningDateMahesh = dateFormat.parse("20-03-1990");

        List<Employee> employees = Arrays.asList(
                new Employee("Ram",50000.0,joiningDateRam,"M"),
                new Employee("Sita",40000.0,joiningDateSita,"F"),
                new Employee("Vishnu",20000.0,joiningDateVishnu,"M"),
                new Employee("Mahesh",70000.0,joiningDateMahesh,"M")

        );

        // Find maximum salary
        System.out.println("******************* Employee with highest salary *******************");
        System.out.println(employees.stream()
                .max((emp1,emp2)->emp1.getSalary()>emp2.getSalary() ? 1 : emp1.getSalary()<emp2.getSalary() ? -1 : 0)
                .get());

        employees.stream()
                .max((a,b)->Double.compare(a.getSalary(),b.getSalary()))
                .ifPresent(System.out::println);

        System.out.println(employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get());

        //print only female employee
        System.out.println();
        System.out.println("******************* Female Employee *******************");
        employees.stream()
                .filter(emp->emp.getGender()=="F")
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // print only second highest salry employee
        System.out.println();
        System.out.println("******************* Employee with 2nd highest salary *******************");
        System.out.println(employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .get(2-1));

        //print employee count based on the gender
        System.out.println();
        System.out.println("******************* Female Male employees count *******************");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));

    }
}

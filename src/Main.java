import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeope();

        // Imperative Approach;
        /*
        List<Person> females = new ArrayList<>();

        for (Person person :
                people) {
            if (person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        females.forEach(System.out::println);
         */
        //---------------------------------------------------------------------------------
        // Declarative Approach;

        // Filter

        /*
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList())
                .forEach(System.out::println);
         */

        // Sort

        people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // All match

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge()>5);
        System.out.println(allMatch);

        // Any match

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge()>21);
        System.out.println(anyMatch);

        // None match

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge()>60);
        System.out.println(noneMatch);

        // Max

        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min

        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Group
        Map<Gender,List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(
                (gender, people1) -> {
                    System.out.println(gender);
                    people1.forEach(System.out::println);
                    System.out.println();
                }
        );

    }

    private static List<Person> getPeope() {
        return List.of(
                new Person("Muhammet Oğuzhan AYDOĞDU",25,Gender.MALE),
                new Person("Nurettin BAŞTÜRK",25,Gender.FEMALE),
                new Person("Nazif Can KABLAN",18,Gender.MALE),
                new Person("James McGill",55,Gender.MALE),
                new Person("Test McGill",55,Gender.MALE),
                new Person("Kimmy Wexler",25,Gender.FEMALE),
                new Person("Jesse Pinkman",35,Gender.MALE)
        );
    }
}
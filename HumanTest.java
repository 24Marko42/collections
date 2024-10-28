import java.util.*;

class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human other) {
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}

public class HumanTest {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Alice", "Smith", 30),
                new Human("Bob", "Johnson", 25),
                new Human("Charlie", "Brown", 35)
        );
        System.out.println("ORIGINAL: " + humans);
        
        // a) HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("a) HashSet: " + hashSet);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("b) LinkedHashSet: " + linkedHashSet);

        // c) TreeSet с натуральной сортировкой
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("c) TreeSet: " + treeSet);

        // d) TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("d) TreeSet с компаратором по фамилии: " + treeSetByLastName);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(Comparator.comparingInt(Human::getAge)); // 
        treeSetByAge.addAll(humans);
        System.out.println("e) TreeSet с компаратором по возрасту: " + treeSetByAge);
    }
}

/*LinkedHashSet сохраняет порядок добавления элементов. Выводим его содержимое на экран. 
Порядок вывода будет соответствовать порядку добавления в список.

TreeSet автоматически сортирует элементы по их естественному порядку, определенному методом compareTo (по имени). 
Выводим отсортированный TreeSet на экран.*/
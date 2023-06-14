package Chapter02;

import java.util.Objects;

/**
 * @WIRTE ellie.song
 * equals / hasCode
 */
public class Chapter46 {
    public static void main(String[] args) {
        Person person1 = new Person("song", "20");
        Person person2 = new Person("song", "20");

        System.out.println(person1.equals(person2)); // false
        System.out.println(person1.hashCode()); // 1057941451
        System.out.println(person2.hashCode()); // 1975358023

        Computer Computer1 = new Computer("song", "20");
        Computer Computer2 = new Computer("song", "20");

        System.out.println(Computer1.equals(Computer2));  // true
        System.out.println(Computer1.hashCode()); // 109623178
        System.out.println(Computer2.hashCode()); // 109623178

    }
}

class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

class Computer {
    private String color;
    private String name;

    public Computer(String color, String name) {
        this.color = color;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer Computer = (Computer) o;
        return Objects.equals(color, Computer.color) && Objects.equals(name, Computer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name);
    }
}
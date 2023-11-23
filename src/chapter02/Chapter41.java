package chapter02;

import java.util.Objects;

class Car {
    private String name;
    private Color color;

    public Car(String name, Color color) {
        //ValidCheck1(name, color);
        ValidCheck2(name, color);
    }

    private void ValidCheck1(String name, Color color) {
        if(name == null) {
            throw new NullPointerException("Car name cannot be null");
        }

        if(color == null) {
            throw new NullPointerException("Car color cannot be null");
        }

        this.name = name;
        this.color = color;
    }

    private void ValidCheck2(String name, Color color) {
        this.name = Objects.requireNonNull(name, "Car name cannot be null");
        this.color = Objects.requireNonNull(color, "Car color cannot be null");
    }
}

enum Color {
    RED;
}

/**
 * @WIRTE ellie.song
 * null 참조 검사와 맞춤형 nullPointerException 던지기
 */
public class Chapter41 {
    public static void main(String[] args) {
        Car car = new Car(null, Color.RED);
    }
}

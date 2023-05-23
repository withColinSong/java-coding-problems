package Chapter02;

import java.util.function.Supplier;

/**
 * @WIRTE ellie.song
 * null 참조 검사와 명시된 예외
 */
public class Chapter42 {



    public static void main(String[] args) {

    }
}


class AnotherCar {
    private String name;
    private Color color;

    public AnotherCar(String name, Color color) {
        this.name = AnotherCar.requireNonNullElseThrow(name, new UnsupportedOperationException("Name cannot be set as null"));
        this.color = AnotherCar.requireNotNullElseThrow(color, () -> new UnsupportedOperationException("Color cannot be set as null"));
    }

    public static <T> T requireNonNullElseThrowIAE(T obj, String message) {
        if(obj == null)
            throw new IllegalArgumentException(message);

        return obj;
    }

    public static <T> T requireNonNullElseThrowIAE(T obj, Supplier<String> messageSupplier) {
        if(obj == null)
            throw new IllegalArgumentException(messageSupplier == null ? null : messageSupplier.get());

        return obj;
    };

    public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, X exception) throws X {
        if(obj == null) {
            throw exception;
        }

        return obj;
    }

    public static <T, X extends Throwable> T requireNotNullElseThrow(T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if(obj != null) {
            return obj;
        } else {
            throw exceptionSupplier.get();
        }
    }

}
import java.util.function.Consumer;

public class Cumparator implements Consumer<Double> {

    @Override
    public void accept(Double aDouble) {
        System.out.println("I am buying " + aDouble + " kilos");
    }

    @Override
    public Consumer<Double> andThen(Consumer<? super Double> after) {
        return null;
    }
}

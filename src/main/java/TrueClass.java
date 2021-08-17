import java.util.function.Predicate;

public class TrueClass implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return false;
    }

    @Override
    public Predicate<String> and(Predicate<? super String> other) {
        return null;
    }

    @Override
    public Predicate<String> negate() {
        return null;
    }

    @Override
    public Predicate<String> or(Predicate<? super String> other) {
        return null;
    }
}

import java.util.function.Function;

public class PersonOne implements Function<String, String> {

    @Override
    public String apply(String s) {
        return "works as " + s;
    }
}

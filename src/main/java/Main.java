import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    static void something(PersonOne personOne, String worksAs) {
        System.out.println("something: " + personOne.apply(worksAs));
    }

    static void something2(Function<String, String> personOne, String worksAs) {
        System.out.println("something: " + personOne.apply(worksAs));
    }

    public static void main(String[] args) {

        System.out.println("=== Foreach cu lambda expression ===");
        List<Double> arrayList = new ArrayList<>();
        arrayList.add(1.0);
        arrayList.add(2.0);
        arrayList.add(3.0);
        arrayList.add(1.6);
        arrayList.add(2.4);
        arrayList.forEach(
                aDouble -> {
//                    System.out.println(a);
//                    System.out.println("am mai scos o valoare");
                    System.out.println("I am buying " + aDouble + " kilos");
                } // clasa anonima care implementeaza consumer si pe metoda apply din consumer pune codul scris de noi
        );

        System.out.println("=== Foreach cu Consumer (scris de noi) ===");
        Cumparator cumparator = new Cumparator();
        arrayList.forEach(cumparator);

        // apel "fortat" pe accept
        Cumparator cumparator1 = new Cumparator();
        cumparator1.accept(10.0);

        arrayList.stream().filter(d -> {
            return d > 2;
        }).forEach(x -> {
            System.out.println("a trecut: " + x);
            // ...
            return;
        });

        Person vasile = (name, work) -> name + " works as a " + work;
        System.out.println(vasile.works("Vasile", "janitor"));

        PersonImpl personImpl = new PersonImpl();
        System.out.println(personImpl.works("Vasile","janitor"));

        Person georgel = (n, w) -> n + " lucreaza ca " + w;
        String ceFaceGeorgel = georgel.works("George", "ospatar");
        System.out.println(ceFaceGeorgel);

        Vehicul vehicul = new Vehicul() {
            @Override
            public boolean esteConstruit() {
                return false;
            }

            @Override
            public int numarPiese() {
                return 0;
            }
        };

        Student gigi = (grade) -> {
            return grade > 5 ? true : false;
        };
        System.out.println("Vasilica " + (gigi.hasPassed(4) ? " a trecut " : " a picat"));

        Function<Integer, Boolean> vasilica = (grade) -> {
            return grade > 5 ? true : false;
        };

        Boolean hasPassed = vasilica.apply(6);
        System.out.println("Vasilica " + (hasPassed ? " a trecut " : " a picat"));


        // apel "fortat" pe apply
        PersonOne personOne = new PersonOne();
        something(personOne, "teacher");
        something2(personOne, "teacher");
//        personOne.apply("teacher");

        Animal animal = (foodType, qty) -> "Animal has been fed with " + foodType + " in quantity of " + qty;
        System.out.println(animal.fed("bones", 5));

        Sum something = (one, two, three) -> {
            int a = one + two;
            int b = two + three;
            int c = one + three;
            return a + b + c;
        };
        System.out.println("Value is " + something.sum(8, 2, 3));


    }

}

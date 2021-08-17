import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(12);
        list.add(9);
        list.add(7);
        Stream<Integer> integerStream = list.stream().filter(x -> x < 3);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(list.stream().filter(x -> x % 2 == 1).collect(Collectors.toList()));

        System.out.println(list.stream().flatMap(x -> {
            List<Integer> divisors = new ArrayList<>();
            for (int i = 2; i <= x; i ++) {
                if (x % i == 0) {
                    divisors.add(i);
                }
            }
            return divisors.stream();
        }).distinct().collect(Collectors.toList()));

        List<File> fileList = new ArrayList<>();
        fileList.add(new File("fila1.txt"));
        fileList.add(new File("fila2.txt"));

        Integer integer = fileList.stream().map(x -> {
            Scanner scanner = null;
            try {
                scanner = new Scanner(x);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int wordsNumber = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                wordsNumber++;
            }
            return wordsNumber;
        }).reduce((value, accumulator) -> accumulator += value).get();

        System.out.println(integer);
    }
}

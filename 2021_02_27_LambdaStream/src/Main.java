import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        //Stream stream = Arrays.stream(array);

        /*IntStream intStream = Arrays.stream(array);
        IntStream newIntStream = intStream.map(new IntUnaryOperator(){
            @Override
            public int applyAsInt(int operand) {
                return operand+99;
            }
        });
        int[] newArray = newIntStream.toArray();
        array = newArray;*/

        array = Arrays.stream(array).map(x -> x % 2 == 0 ? x * 2 : x).toArray();

        for (int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0) array[i]*=2;
        }

        System.out.println("After: " + Arrays.toString(array));

        int[] array2 = new int[10];
        fillArray(array);

        String[] stringArray = {"aaa", "abb", "vvv", "bba", "ahg"};

        Arrays.stream(stringArray).map(x -> {
        if(x.charAt(0) == 'a') return x.replaceFirst("a", "ХУЙ");
        return x;}).forEach(System.out::print);

        System.out.println(System.lineSeparator());

        Arrays.stream(stringArray).map(x -> x).forEach(System.out::print);

        array2 = Arrays.stream(array2).filter(new IntPredicate(){
            @Override
            public boolean test(int value){
                if(value < 5){
                    return false;
                }
                else return true;
            }
        }).toArray();

        System.out.println("After: " + Arrays.toString(array2));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add( new Random().nextInt(100));
        }
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println(System.lineSeparator());
        list.stream().sorted().forEach(x -> System.out.print(x + " "));
        System.out.println(System.lineSeparator());
        list.stream().sorted((o1, o2) -> o1 > o2 ? -1 : o1 < o2 ? 1 : 0).forEach(x -> System.out.print(x + " "));
        list.stream().sorted((o1, o2) -> o2.compareTo(o1)).forEach(x -> System.out.print(x + " "));
        list.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));
        System.out.println(System.lineSeparator());
        list.stream().max((o1, o2) -> o1 > o2 ? 1 : o1 < o2 ? -1 : 0).ifPresent(System.out::print);
        System.out.println(System.lineSeparator());
        list.stream().min((o1, o2) -> o1 > o2 ? 1 : o1 < o2 ? -1 : 0).ifPresent(System.out::print);
        System.out.println(System.lineSeparator());

        Collector

    }

    public static void fillArray(int[] array){
        for (int i =0; i < array.length; i++){
            array[i] = i+1;
        }
        System.out.println("Before: " + Arrays.toString(array));
    }
}

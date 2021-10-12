import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class A{
    int x = 0;
}

class B extends A{
    int x = 1;

}

public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a + b;
        String d = "ab";
        System.out.println(c == d);

       // StringBuilder

        String s1 = "ab";
        String s2 = "a" + "b";
        System.out.println(s1 == s2);

        B bClass = new B();
        System.out.println(bClass.x);

        String string = "It324 is some words23423 and i dont know english.234 gg. It is the second predloz.";
        String[] arrayString = string.split("\\d+");
       // arrayString[]
        System.out.println(Arrays.toString(arrayString));

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        for(Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == "b"){
                System.out.println(entry.getKey());
                break;
            }
        }



        System.out.println();

    }
}

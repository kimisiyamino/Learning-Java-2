import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        System.out.println("Approval Data");

        String[] array = list.toArray(new String[0]);

        System.out.println("Sorting......");

        sort(array);
        System.out.println("Sorting completed!");

        for (String x : array) {
            System.out.println(x);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void sort(String[] array) {
        boolean[] isNumber = new boolean[array.length];

        int numCount = 0, strCount = 0;
        System.out.println("Getting boolean...");
        for(int i = 0; i < array.length; i++) {
                isNumber[i] = isNumber(array[i]);
                if(isNumber[i]){
                    numCount++;
                }else{
                    strCount++;
                }
        }
        System.out.println("Getting boolean completed!");
        String[] nums = new String[numCount];
        String[] strings = new String[strCount];

        System.out.println("Array splitting...");
        numCount = 0; strCount = 0;
        for(int i = 0; i < isNumber.length; i++) {
            if(isNumber[i]){
                nums[numCount] = array[i];
                numCount++;
            }else{
                strings[strCount] = array[i];
                strCount++;
            }
        }
        System.out.println("Array splitting completed!");

        System.out.println("Sorting strings...");
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < strings.length - 1; i++) {
                boolean comp = isGreaterThan(strings[i], strings[i + 1]);
                if (comp) {
                    String t = strings[i];
                    strings[i] = strings[i + 1];
                    strings[i + 1] = t;
                    sorted = false;
                }
            }
        }
        System.out.println("Sorting strings completed!");
        System.out.println("Sorting nums...");
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length - 1; i++) {
                int GG1 =Integer.parseInt(nums[i]);
                int GG2 = Integer.parseInt(nums[i+1]);
                if (GG1 < GG2) {
                    String t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                    sorted = false;
                }
            }
        }
        System.out.println("Sorting nums completed!");
        System.out.println("Restore original data...");
        numCount = 0; strCount = 0;
        for(int i = 0; i < array.length; i++){
            if(isNumber[i]){
                array[i] = nums[numCount];
                numCount++;
            }else{
                array[i] = strings[strCount];
                strCount++;
            }
        }
        System.out.println("Restore original data completed!");
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}

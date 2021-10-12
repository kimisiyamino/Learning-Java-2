import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int width = 4;

        int[][] matrix = {
                {1,1,1,0},
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,1,1,1},
                {1,0,1,1},
                {1,1,1,1}
            };

//        List<String> lines = new LinkedList<>();
//        List<String> newField = new LinkedList<>();
//
//        boolean isFull = false;
//
//        for (int[] ints : matrix) {
//            StringBuilder temp = new StringBuilder();
//            for (int anInt : ints) {
//                temp.append(anInt);
//            }
//            lines.add(temp.toString());
//        }
//
//        System.out.println(lines);
//
//        for(String line : lines){
//            if(line.contains("0")){
//                newField.add(line);
//            }
//        }
//
//        System.out.println(newField);
//        int countOfEmptyLines = matrix.length - newField.size();
//        String emptyLine = "";
//        for(int i = 0; i < 4; i++){
//            emptyLine = emptyLine.concat("0");
//        }
//
//        System.out.println("EMPTY: " + emptyLine);
//
//        for(int i = 0; i < countOfEmptyLines; i++){
//            newField.add(0, emptyLine);
//        }
//
//        System.out.println(newField);
//
//        for (int y = 0; y < matrix.length; y++) {
//            for (int x = 0; x < matrix[y].length; x++) {
//                matrix[y][x] = newField.get(y).charAt(x) - '0';
//            }
//        }
//
//        for (int y = 0; y < matrix.length; y++) {
//            for (int x = 0; x < matrix[y].length; x++) {
//                System.out.print(matrix[y][x]);
//            }
//            System.out.println();
//        }

        List<int[]> lines = new ArrayList<>();


    }
}

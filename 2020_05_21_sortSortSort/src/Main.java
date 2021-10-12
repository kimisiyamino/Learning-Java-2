import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 8, 3, 8, 1, 10, 3, 12, 4, 4};
        insertionSort(array);
        System.out.println(Arrays.toString(array));


    }

    public static void bubbleSort(int[] arr){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for(int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i]; arr[i] = arr[i+1]; arr[i+1] = t;
                    sorted = false;
                }
            }
        }
    }

    public static void selectedSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int indMin = i;
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] <= min){
                    min = arr[j];
                    indMin = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[indMin];
            arr[indMin] = t;
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int box = arr[i];
            int j = i - 1;
            while(box < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = box;
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(){


    }
}

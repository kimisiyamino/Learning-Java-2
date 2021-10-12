public class Main {
    public static void main(String[] args) {
        long l = Long.MAX_VALUE;
        float f = Float.MAX_VALUE;
        String parametrs = String.format("%"+"f", f);
        System.out.printf(parametrs, Math.PI);

        System.out.println(System.lineSeparator());
        System.out.print("Num P: " + Math.PI);

        System.out.println(System.lineSeparator());
        System.out.print("Double MAX_VALUE: " + Double.MAX_VALUE);




    }
}

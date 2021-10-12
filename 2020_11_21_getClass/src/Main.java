import MyPackage.MyClass;

public class Main {
    public static void main(String[] args) {
        String s1 = new String();

        System.out.println(String.class);
        System.out.println(s1.getClass());
        System.out.println(s1.getClass().getSimpleName());
        System.out.println(s1.getClass().getName());

        MyClass mc = new MyClass();

        System.out.println(MyClass.class);
        System.out.println(mc.getClass());
        System.out.println(mc.getClass().getSimpleName());
        System.out.println(mc.getClass().getName());

//
//        try{
//            int i = 100 / 0;
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }



    }
}
public class Main {
    public static void main(String[] args) {
        A a = new A();

    }

}

class A{

    private class B{
        static int x = 10;
    }

    A(){
        B b = new B();
    }
}

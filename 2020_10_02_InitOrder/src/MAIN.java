class A{
    public int x = 100;

    public void printClassA(){
        System.out.println("printClassA");
    }

    public void printClass(){
        System.out.println("a");
    }

    public void setX(int g){
        x = g;
    }

    public int getX(){
       return x;
    }

    public int getXofA(){
        return x;
    }
}
class B extends A{

    public int x = 200;

    public void printClassB(){
        System.out.println("printClassB");
    }

    public void printClass(){
        System.out.println("b");
    }

    public int getXofB(){
        return x;
    }

    public void setX(int g){
        x = g;
    }

}
class C extends B{

    public int x = 300;

    public void printClassC(){
        System.out.println("printClassC");
    }

    public void printClass(){
        System.out.println("c");
    }

    public int getXofC(){
        return x;
    }

    public void setX(int g){
        x = g;
    }

}

public class MAIN {
    public static void main(String[] args) {
        A _a = new A();
        B _b = new B();
        C _c = new C();

        //_a.setX(500);
        //_b.setX(600);
        //_c.setX(700);

        _a.x = 111;
        _b.x = 222;
        _c.x = 333;

        System.out.printf("Class A, getXofA: %d \n\n",  _a.getXofA());
        System.out.printf("Class B, getXofA: %d \n",  _b.getXofA());
        System.out.printf("Class B, getXofB: %d \n\n",  _b.getXofB());
        System.out.printf("Class C, getXofA: %d \n",  _c.getXofA());
        System.out.printf("Class C, getXofB: %d \n",  _c.getXofB());
        System.out.printf("Class C, getXofC: %d \n\n",  _c.getXofC());

       System.out.println("Class A: x: " + _a.x);
       System.out.println("Class B: x: " + _b.x);
       System.out.println("Class C  x: " + _c.x);
       _c.x = 1000;
        System.out.println("\n _c.x=1000 == " + _c.x);


        System.out.println("================");
        System.out.println(_a.getX());
        System.out.println(_b.getX());
        System.out.println(_c.getX());


        _a.printClass();
        _b.printClass();
        _c.printClass();

        Object object = _c;
        B a = (C)object;
        System.out.println(a.x);
        a.printClass();

        System.out.println(object instanceof Object);
        System.out.println(object instanceof A);
        System.out.println(object instanceof B);
        System.out.println(object instanceof C);

    }
}

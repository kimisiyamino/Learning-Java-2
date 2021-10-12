package com.eleonoralion;

public class Main extends C{

    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        {
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Main() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Main();
    }
}



package com.kimisi;

public class DuckTest {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        wildTurkey.gobble();
        wildTurkey.fly();

        System.out.println("= = = = = = = = = = =");

        test(mallardDuck);

        System.out.println("= = = = = = = = = = =");

        test(turkeyAdapter);
    }

    public static void test(Duck duck){
        duck.fly();
        duck.quack();
    }
}

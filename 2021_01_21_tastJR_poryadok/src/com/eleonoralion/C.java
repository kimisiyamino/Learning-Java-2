package com.eleonoralion;

public class C implements JustAnInterface{
    public C() {
        System.out.print("C");
        B localB = B;
    }
}
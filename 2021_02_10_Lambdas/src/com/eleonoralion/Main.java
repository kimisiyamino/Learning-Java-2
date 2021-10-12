package com.eleonoralion;

public class Main {
    public static void main(String[] args) {
        FirstLabmda firstLabmda = () -> 100;
        System.out.println(firstLabmda.getNumber());

        SecondLabmda secondLabmda = хуй -> хуй*хуй;
        System.out.println(secondLabmda.getNumber(5));

       // System.out.println(FirstEnum.valueOf("34234"));

        for(FirstEnum f : FirstEnum.values()){
            System.out.println(f);
        }

    }
}

interface FirstLabmda{
    int getNumber();
}


interface SecondLabmda{
    int getNumber(int i);
}

enum FirstEnum{
    One,
    Two,
    Free,
    Four,
    Five;
}

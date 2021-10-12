package com.kimisi;

public class RegularExTest {
    public static void main(String[] args) {
        String a = "4567453";
        String b = "-4556743";
        String c = "+455463";
        String d = "+-325453";
        String e = "-+325453";
        String f = "+-+-+---+325453";
        String g = "";

        float tempInt1 = 4332432.523f;
        float tempInt2 = 326542.434f;

        System.out.println(a.matches("\\w?\\d+"));
        System.out.println(a.matches("([+-]*)\\d*"));
        System.out.println(b.matches("([+-]*)\\d*"));
        System.out.println(c.matches("([+-]*)\\d*"));
        System.out.println(d.matches("([+-]*)\\d*"));
        System.out.println(e.matches("([+-]*)\\d*"));
        System.out.println(f.matches("([+-]*)\\d*"));
        System.out.println(g.matches("([+-]*)\\d*"));
        System.out.printf("%2$+,020.4f\n%<20.4f", tempInt1, tempInt2);
    }
}

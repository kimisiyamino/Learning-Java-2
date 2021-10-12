package com.eleonoralion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Certainly, when one thinks of films the name\r\n ‘Hollywood’ comes\n to mind, but it wasn’t always the movie capital of the world. " +
                "In the e\narly 1900s a few compani\r\nes looking for a good location settled in t\nhe thriving city of Los Angeles. Both the sea and sunshine made " +
                "this an ideal loca\ntion, and over the next 30 years \nit developed into the ‘home of movies’ and became the only place to be during the " +
                "so-called G\nolden Age in the 1930s and 1940s.";

        Pattern pattern = Pattern.compile("$");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.println(matcher.start());
        }

    }
}

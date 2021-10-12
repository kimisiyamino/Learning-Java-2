import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Test object01 = new Test();
        QuestionFileOutputStream object02 = new QuestionFileOutputStream(object01);

        try {
            object02.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

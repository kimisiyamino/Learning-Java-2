import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class simpleDateTest {
    public static void main(String[] args) {

        // Calendar и Date, примеры

        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = Calendar.getInstance();

        Date date = calendar.getTime();
        Date date1 = new Date();

        System.out.printf("%tR %<tF\n", date);
        System.out.printf("%tR %<tF\n", date1);
        System.out.printf("%tR %<tF\n", calendar1.getTime());

        System.out.println(Calendar.YEAR);               // 1
        System.out.println(calendar.get(Calendar.YEAR)); // 2020


        // Перевод  Date -> String ( SimpleDateFormat.format() )

        SimpleDateFormat dateFormat = new SimpleDateFormat(); // dd-MM-yyyy HH:mm:ss, Locale.RUSSIAN;
        dateFormat.applyPattern("dd-MM-yyyy HH:mm:ss");

        String dateString = dateFormat.format(date);
        System.out.println(dateString);


        // Перевод  String -> Date ( SimpleDateFormat.format() )

        String otherDate = "2018 09 30 15 04";
        dateFormat.applyPattern("yyyy MM dd HH mm");

        try {
            Date newDate = dateFormat.parse(otherDate);
            System.out.println(newDate);

        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}

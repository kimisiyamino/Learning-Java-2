import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;


        public class Main {
            public static void main(String[] args) {
                long departDate = 0L;
                long returnDate = 0L;

                do {
                    departDate = ThreadLocalRandom.current().nextLong(System.currentTimeMillis(), System.currentTimeMillis() + System.currentTimeMillis()/10);
                    returnDate = ThreadLocalRandom.current().nextLong(System.currentTimeMillis(), System.currentTimeMillis() + System.currentTimeMillis()/10);
                }while (departDate > returnDate);
                //Date departDate = new Date(randTime);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                System.out.println(simpleDateFormat.format(departDate));
                System.out.println(simpleDateFormat.format(returnDate));

        //LocalDate departDate = LocalDate.parse("10/02/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       //LocalDate arriveDate = LocalDate.parse("19/06/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

     }
}

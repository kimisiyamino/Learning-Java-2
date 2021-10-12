

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/

public class MAIN {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("C:\\Users\\User\\IdeaProjects\\untitled3\\src\\file");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут    +++++
            User user = new User();
            user.setFirstName(null);
            user.setLastName("Malkovich");
            user.setBirthDate(null);
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            System.out.println(javaRush);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны  ++++++
            System.out.println(loadedObject.equals(javaRush));
            System.out.println(loadedObject);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            boolean emptyUsers = users.isEmpty();
            if(!emptyUsers) {
                for (User user : users) {
                    writer.println(emptyUsers);
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println((user.getBirthDate().getTime()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayName());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            ArrayList<String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            boolean isEmpty = Boolean.valueOf(reader.readLine());
            if(!isEmpty){
                while(reader.ready()){
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String str = reader.readLine();
                    if(str.equals("Russia")) user.setCountry(User.Country.RUSSIA);
                    else if(str.equals("Ukraine")) user.setCountry(User.Country.UKRAINE);
                    else if(str.equals("Other")) user.setCountry(User.Country.OTHER);
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        @Override
        public String toString() {
            String str = null;
            for (User user : users) {
                str = user.getFirstName() + " " + user.getLastName() + " " + user.isMale() + " " + user.getBirthDate() + " " + user.getCountry().getDisplayName();
            }

            return str;
        }
    }
}

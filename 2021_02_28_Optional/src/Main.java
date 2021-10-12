import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.addUser(new User("Lesha"));
        dataBase.addUser(new User("Lev"));
        dataBase.addUser(new User("Olga"));
        dataBase.addUser(new User("Evgeni"));
        dataBase.addUser(new User("Ivan"));

        System.out.println(dataBase.findUserById(1).isPresent());
        System.out.println(dataBase.findUserById(100).isPresent());
        System.out.println(dataBase.findUserById(5).isPresent());
    }
}


class User{
    private static int counter;
    private int id;
    private String name;

    public User() {
    }

    User(String name) {
        id = ++counter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Чувак " +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class DataBase{
    private List<User> userList;

    DataBase(){
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public Optional<User> findUserById(int id){
        for(User u : userList){
            if(id == u.getId()){
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

}

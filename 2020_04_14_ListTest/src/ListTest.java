import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        Set<String> setKeys = map.keySet();

        List<String> list = new ArrayList<>();
        list.addAll(setKeys);

        Collections.sort(list);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s + " " + map.get(s));
        }
        Book.NameComparator comparatorName = new Book.NameComparator();
        TreeSet<Book> treeSet = new TreeSet<Book>(comparatorName);
        
    }
}
class Book {
    String name;
    String age;

    static class NameComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}

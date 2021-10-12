import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class TestSet {
    public static void main(String[] args) {

        ArrayList<Integer> iii = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        Set<Integer> unionSet = new HashSet<>(set1);

        System.out.println(unionSet);

        Set<Integer> retainSet = new HashSet<>(set1);
        retainSet.retainAll(set2);
        System.out.println(retainSet);

        Set<Integer> symmetricSet = new HashSet<>(unionSet);
        symmetricSet.removeAll(retainSet);

        System.out.println(symmetricSet);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);

    }


}

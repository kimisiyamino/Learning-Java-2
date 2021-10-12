import java.io.Serializable;

public class Hero implements Serializable {

    private static final long serialVersionUID = -8977130771638057471L;

    int life;
    static int count;
    transient int noSer;
    String name;

    public Hero(int life, int noSer, String name, int count) {
        this.life = life;
        this.noSer = noSer;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "life=" + life +
                ", noSer=" + noSer +
                ", name='" + name + '\'' +
                '}' + "static: " + count;
    }
}

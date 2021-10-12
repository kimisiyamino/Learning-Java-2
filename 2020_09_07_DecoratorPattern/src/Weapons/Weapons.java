package Weapons;


public abstract class Weapons {
    private String descriptipon;

    protected Weapons(){};
    public Weapons(String s){
        this.setDescriptipon(s);
    }

    public String getDescriptipon(){
        return this.descriptipon;
    }

    protected void setDescriptipon(String descriptipon){
        this.descriptipon = descriptipon;
    }


}

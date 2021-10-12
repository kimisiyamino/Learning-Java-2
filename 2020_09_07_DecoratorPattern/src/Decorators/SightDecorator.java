package Decorators;

import Weapons.Weapons;

public class SightDecorator extends AdditionsWeaponDecorator {

    Weapons w;

    public SightDecorator(Weapons w){
        this.w = w;
    }

    public String getDescriptipon(){
        return w.getDescriptipon() + " с Прицелом";
    }



}

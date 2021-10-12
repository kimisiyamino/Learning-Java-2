package Decorators;

import Weapons.Weapons;

public class FlashlightDecorator extends AdditionsWeaponDecorator{

    private Weapons w;

    public FlashlightDecorator(Weapons w){
        this.w = w;
    }


    public String getDescriptipon(){
        return w.getDescriptipon() + " с Фонариком";
    }

}

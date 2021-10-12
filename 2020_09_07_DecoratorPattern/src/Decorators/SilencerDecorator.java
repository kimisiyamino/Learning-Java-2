package Decorators;

import Weapons.Weapons;

public class SilencerDecorator extends AdditionsWeaponDecorator {

    private Weapons w;

    public SilencerDecorator(Weapons w){
        this.w = w;
    }

    public String getDescriptipon(){
        return w.getDescriptipon() + " с Глушителем";
    }

}

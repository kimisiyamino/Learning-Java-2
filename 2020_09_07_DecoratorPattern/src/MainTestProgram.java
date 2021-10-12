import Decorators.FlashlightDecorator;
import Decorators.SilencerDecorator;
import Decorators.*;
import Weapons.*;

public class MainTestProgram {
    public static String pistolDescription = "Пистолет";
    public static String shotgunDescription = "Дробовик";
    public static String machinegunDescription = "Автомат";
    public static String ak47Description = "AK47";



    public static void main(String[] args) {
        Weapons pistol = new Pistol(pistolDescription);
        Weapons shotgun = new Shotgun(shotgunDescription);
        Weapons ak47 = new Machinegun(machinegunDescription);

        printWeapon(pistol);
        printWeapon(shotgun);
        printWeapon(ak47);

        Weapons pistolWithFlahlightAndSilencer = new SilencerDecorator (new FlashlightDecorator(new SilencerDecorator(new Pistol(pistolDescription))));
        Weapons machinegunWithFlahlightAndSilencer = new SilencerDecorator (new FlashlightDecorator(new SilencerDecorator(new Machinegun(ak47Description))));
        Weapons shotgunWithFlahlightAndSilencerAndSight = new SightDecorator(new FlashlightDecorator(new SilencerDecorator(new Shotgun(shotgunDescription))));

        printWeapon(pistolWithFlahlightAndSilencer);
        printWeapon(machinegunWithFlahlightAndSilencer);
        printWeapon(shotgunWithFlahlightAndSilencerAndSight);


    }

    public static void printWeapon(Weapons weapons){
        System.out.println(weapons.getDescriptipon());
    }
}

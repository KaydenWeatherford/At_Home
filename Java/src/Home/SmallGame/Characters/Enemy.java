package Characters;

import Items.Weapon;

import java.util.ArrayList;

public abstract class Enemy implements Characters {
    private String Name;
    private double HP;
    private String Type;
    private Weapon weapon;

    public Enemy(String IName, double IHP, String IType, Weapon Iweapon) {}
    public String getName() {
        return Name;
    }
    public double getHealth() {
        return HP;
    }
    public String getType() {
        return Type;
    }
    public void setHealth(double value) {
        HP = value;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon wep){
        weapon = wep;
    }
}

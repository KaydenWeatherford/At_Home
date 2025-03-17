package Items.Weapons;

import Items.Weapon;

public abstract class Melee extends Weapon {
    private String name;
    private String description;
    private String type;
    private double dmg;
    private int range;

    public Melee(String Iname, String Idescription, String Itype, double damage, int Irange) {
        super(Iname, Idescription, Itype, damage);
        range = Irange;
    }

    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public String getType(){ return type; }
    public double getDamage(){ return dmg; }
    public int getRange(){ return range; }
}

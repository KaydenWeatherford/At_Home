package Items;

public abstract class Weapon implements Item {
    private String name;
    private String description;
    private String type;
    private double dmg;

    public Weapon(String Iname, String Idescription, String Itype, double damage) {
        name = Iname;
        description = Idescription;
        type = Itype;
        dmg = damage;
    }

    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public String getType(){ return type; }
    public double getDamage(){ return dmg; }
}

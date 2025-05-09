package Characters;

public class Player implements Characters{
    private String Name;
    private double HP;
    private String Type;
    private int XP;

    public Player(String CharName){
        Name = CharName;
        HP = 10.0;
        Type = "Human";
        XP = 0;
    }
    public Player(String CharName, String InType){
        Name = CharName;
        HP = 10.0;
        Type = InType;
        XP = 0;
    }

    public String getName(){
        return Name;
    }
    
    public String getType(){
        return Type;
    }

    public double getHealth(){
        return HP;
    }

    public void setHealth(double value){
        HP = value;
    }

    public int getXP(){
        return XP;
    }

    public void setXP(int value){
        XP = value;
    }

}
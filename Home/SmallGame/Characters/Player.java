public class Player implements Character{
    private String Name;
    private double Health;
    private String Type;

    public Player(String CharName){
        Name = CharName;
        Health = 10.0;
        Type = "Human";
    }
    public Player(String CharName, String InType){
        Name = CharName;
        Health = 10.0;
        Type = InType;
    }

    public String getName(){
        return Name;
    }
    
    public String getType(){
        return Type;
    }

    public double getHealth(){
        return Health;
    }

    public void setHealth(double value){
        Health = value;
    }
}
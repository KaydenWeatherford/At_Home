package Menu;

public class MainMenu {
    public MainMenu(){}

    public static void Display(){
        System.out.println("-Welcome to KiKi's Simple Game!-\n");
        System.out.println("Select an option:\n");
        System.out.printf(  "1) Continue from Last Save\n" +
                            "2) Start New Game\n"+
                            "3) Credits\n\n"+
                            "0) Quit\n" +
                            "------------------------------");
    }

    public static void Credits(){
        System.out.println("\n\n");
        System.out.println("-----------Credits------------\n");
        System.out.println("Made By KiKi The Proto\n");
        System.out.printf(  "I learned a lot of this from\n" +
                "My Computer Science Teahcer\n"+
                "Dr. Szelogowski\n"+
                ":3\n" +
                "------------------------------");
    }
}

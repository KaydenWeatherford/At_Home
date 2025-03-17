import Menu.MainMenu;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AGame{
    public static void main(String[] args){
        MainMenu.Display();
        Scanner input = new Scanner(System.in);
        Path p = Paths.get("C:\\Users\\KiKiTheProto\\IdeaProjects\\At_Home\\Home\\SmallGame\\Save1.txt");
        File file = new File(p.toString());
        try {
            Scanner sc = new Scanner(file);

            while (1 == 1) {
                if (input.nextInt() == 1) {

                }
                else if (input.nextInt() == 2) {

                }
                else if (input.nextInt() == 3) {
                    MainMenu.Credits();
                }
                else if (input.nextInt() == 0) {
                    System.exit(0);
                }
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
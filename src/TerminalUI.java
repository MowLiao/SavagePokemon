import java.util.scanner;

public class TerminalUI
{
    public TerminalUI()
    {

    }

    private void mainMenu()
    {
        System.out.println(".--------------------------------------------------------.");
        System.out.println("|                       MAIN MENU                        |");
        System.out.println("\'--------------------------------------------------------\'");
        System.out.println("  1. ");
        System.out.println("  2. ");

        String userInput = readInput();
        
    }

    private String readInput()
    {
        Scanner reader = new Scanner(System.in);
        String inString = reader.nextLine();
        reader.close;
        return inString;
    }

    public static void main(String[] args)
    {

    }
}
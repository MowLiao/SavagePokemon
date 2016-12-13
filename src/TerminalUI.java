import java.util.Scanner;

public class TerminalUI
{
    private Scanner systemReader;


    public TerminalUI()
    {
        try
        {
            systemReader = new Scanner(System.in);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void run()
    {
        intro();
    }


    private void intro()
    {
        System.out.println("      .--------------------------------------------------------.");
        System.out.println("      |                      INTRODUCTION                      |");
        System.out.println("      \'--------------------------------------------------------\'");
        System.out.println("");
        System.out.println(" > Welcome to the SavPok Generator. This is a tool programed in Java to ");
        System.out.println(" > generate Pokémon encounters for the Savage Worlds tabletop roleplaying ");
        System.out.println(" > system. Pokemon are predefined and stored in a .csv file located in");
        System.out.println(" > /res/. Curently only the first two generations of Pokémon are ");
        System.out.println(" > included.");
        System.out.println("");
        mainMenu();
    }


    // Checks user inputs a number.
    private String numUserInput()
    {
        String inString = "";
        try
        {
            Boolean isInt = false;
            
            while (!isInt)
            {
                inString = this.systemReader.nextLine();
                try
                {
                    Integer i = Integer.parseInt(inString);
                    isInt = true;
                }
                catch(NumberFormatException nfe)
                {
                    System.out.println(" > Not a number. Please try again. \n");
                }
            }
            return inString;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


    // Checks user numeric input is within a range.
    private String readNumInput(Integer minNum, Integer maxNum)
    {
        String inString = numUserInput();
        int inNum = Integer.parseInt(inString);
        while ((inNum < minNum) || (inNum > maxNum))
        {
            System.out.println(" > Invalid number. Please try again.");
            inString = numUserInput();
            inNum = Integer.parseInt(inString);
        }
        return inString;
    }


    private void mainMenu()
    {
        System.out.println("      .--------------------------------------------------------.");
        System.out.println("      |                        MAIN MENU                       |");
        System.out.println("      \'--------------------------------------------------------\'");
        System.out.println("");
        System.out.println(" >    1. Generate encounter");
        System.out.println(" >    0. Exit");
        System.out.println("");

        String menuInput = readNumInput(0, 1);
        System.out.println("You entered " + menuInput);
    }

    public static void main(String[] args)
    {
        TerminalUI thisInstance = new TerminalUI();
        thisInstance.run();
    }
}
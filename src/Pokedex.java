import java.io.*;
import java.util.*;

public class Pokedex extends ArrayList<Pokemon>
{
    private String workingdir = System.getProperty("user.dir");
    
    public Pokedex()
    {
        super();
        readFile();
    }

    /*
    private add(Pokemon pokemon)
    {
        // Add method for pokemon into pokedex
    }
    */

    private void readFile()
    {
        String statsfile = this.workingdir.substring(0,this.workingdir.length()-4).concat("\\res\\stats.csv");
        BufferedReader br = null;
        String line = "";

        try
        {
            br = new BufferedReader( new FileReader(statsfile));
            line = br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                this.add(csvStringToPokemon(line));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                br.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }

    private Pokemon csvStringToPokemon(String stringIn)
    {
        String[] stringArray = stringIn.split(",");
        ArrayList<String> statsArray = new ArrayList<String>(stringArray.length);
        for (int i=0; i<stringArray.length; i++)
        {
            statsArray.add(stringArray[i]);
        }
        Pokemon newPokemon = new Pokemon(statsArray);
        System.out.println(newPokemon.getPokedexNumber() + " " + newPokemon.getName());
        return newPokemon;
    }


    /****************************************
        MAIN FOR TESTING
    ****************************************/

    public static void main(String[] args)
    {
        Pokedex test = new Pokedex();
        //System.out.println(test.get(0).getName());
    }

}
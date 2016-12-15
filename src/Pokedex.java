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
        catch(Exception e)
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
        //System.out.println(newPokemon.getPokedexNumber() + " " + newPokemon.getName());
        return newPokemon;
    }

    // Returns list of all Pokemon names.
    public String[] getPokemon()
    {
        ArrayList<String> allPokemon = new ArrayList<String>(this.size());
        for (int i=0; i<this.size(); i++)
        {
            allPokemon.add(this.get(i).getName());
        }
        String[] returnArray = allPokemon.toArray(new String[this.size()]);
        return returnArray;
    }


    /****************************************
        MAIN FOR TESTING
    ****************************************/

    public static void main(String[] args)
    {
        Pokedex test = new Pokedex();
        ArrayList<String> pokemonList = new ArrayList<String>(Arrays.asList(test.getPokemon()));
        for (int i=0; i<pokemonList.size(); i++)
        {
            Integer number = i+1;
            System.out.println(number + " " + pokemonList.get(i));
        }
    }

}
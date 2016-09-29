import java.io.*;

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
            br = new BufferedReader( new FileReader(statsfile))
            while ((line = br.readline()) != null)
            {

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

    private Pokemon dataConversion()
    {
        String[] pokemonArray = line.split(",");
    }


    /****************************************
        MAIN FOR TESTING
    ****************************************/

    public static void main(String[] args)
    {
        Pokemon test = new Pokemon();
    }

}
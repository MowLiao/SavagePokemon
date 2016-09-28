import java.io.*;

public class Pokedex
{
    private String workingdir = System.getProperty("user.dir");
    
    public Pokedex()
    {

    }

    private add(Pokemon pokemon)
    {
        // Add method for pokemon into pokedex
    }

    private readFile(String filename)
    {
        String statsfile = this.workingdir.substring(0,this.workingdir.length()-4).concat("\\res\\stats.csv");
        BufferedReader br = null;
        String line = "";

        try
        {
            br = new BufferedReader( new FileReader(statsfile))
            br.readline();                  // Skip past table header lines
            br.readline();
            while ((line = br.readline()) != null)
            {
                String[] pokemonArray = line.split(",");
                // Create pokemon here from all fields
                // ndex
                // pokemon
                // primarytype
                // secondarytype
                // evolutionarystage
                // pace
                // agility
                // smarts
                // strength
                // spirit
                // vigor 
                // weak
                // strong
                // small
                // large
                // charisma
                // parry
                // toughness
                // intimidation
                // notice
                // stealth
                // survival
                // swimming
                // fighting
                // spAttack
                // climbing
                // healing
                // taunting
                // tracking
                // charm
                // edges
                // hindrances
                // environments
                // rareness
                // maxgroupsize
                // aggressiveness
                // pokemonFamily

            }
        }
    }

    public static void main(String[] args)
    {

    }
}
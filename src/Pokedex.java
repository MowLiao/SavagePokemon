import java.io.*;

public class Pokedex
{
    private String workingdir = System.getProperty("user.dir");
    
    public Pokedex()
    {

    }

    /*
    private add(Pokemon pokemon)
    {
        // Add method for pokemon into pokedex
    }
    */

    private void readFile(String filename)
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
        // Create pokemon here from all fields
        // 0 ndex
        // 1 pokemon
        // 2 primarytype
        // 3 secondarytype
        // 4 evolutionarystage
        // 5 pace
        // 6 agility
        // 7 smarts
        // 8 strength
        // 9 spirit
        // 10 vigor 
        // 11 weak
        // 12 strong
        // 13 small
        // 14 large
        // 15 charisma - calculated
        // 16 parry - calculated 
        // 17 toughness - toughness
        // 18 intimidation
        // 19 notice
        // 20 stealth
        // 21 survival
        // 22 swimming
        // 23 fighting
        // 24 spAttack
        // 25 climbing
        // 26 healing
        // 27 taunting
        // 28 tracking
        // 29 charm
        // 30 edges            armed, aquatic, burrowing, cute, double attack, flight, hard, majestic, reach, roch hard, speedy flight, teleporation, transforms
        // 34 hindrances       always aquatic, rage, ugly
        // 36 inArctic
        // 37 inCaves
        // 38 inDesert
        // 39 inFreshWater
        // 40 inMountains
        // 41 inSea
        // 42 inPlains
        // 43 inUrban
        // 44 inVolcanic
        // 45 inWoods
        // 46 rareness
        // 47 maxgroupsize
        // 48 aggressiveness
        // 49 pokemonFamily
    }

    public static void main(String[] args)
    {

    }
}
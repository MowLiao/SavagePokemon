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
                //System.out.println(line);
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
            //System.out.println(stringArray[i]);
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
        Pokemon testPok = test.get(195);

        
        System.out.println("" + testPok.ndex + ": " + testPok.pokemonName);
        System.out.println("Types: " + testPok.primaryType.getType() + ", " + testPok.secondaryType.getType());
        System.out.println("Ev. Stage: " + testPok.evolutionaryStage);
        System.out.println("Rarity: " + testPok.rareness);
        System.out.println("Max group size: " + testPok.maxGroupSize);
        System.out.println("Aggressiveness: " + testPok.aggro);
        System.out.println("Spawns with: " + testPok.pokemonFamily + "\n");


        System.out.println("Weak: " + testPok.weak.get());
        System.out.println("Strong: " + testPok.strong.get());
        System.out.println("Small: " + testPok.small.get());
        System.out.println("Large: " + testPok.large.get() + "\n");

        System.out.println("Pace: " + testPok.pace);
        System.out.println("Running: " + testPok.running.getDice());
        System.out.println("Agility: " + testPok.agility.getDice());
        System.out.println("Smarts: " + testPok.smarts.getDice());
        System.out.println("Strength: " + testPok.strength.getDice() + " +" + testPok.strength.getModifier());
        System.out.println("Spirit: " + testPok.spirit.getDice());
        System.out.println("Vigor: " + testPok.vigor.getDice());
        System.out.println("Chr: " + testPok.charisma.getDice());                    // calculated
        System.out.println("Par: " + testPok.parry.getDice());                       // calculated 
        System.out.println("Tgh: " + testPok.toughness.getDice());                   // calculated
        System.out.println("Skill: Intimidation is " + testPok.intimidation.getDice());
        System.out.println("Skill: Notice is " + testPok.notice.getDice());
        System.out.println("Skill: Stealth is " + testPok.stealth.getDice());
        System.out.println("Skill: Survival is " + testPok.survival.getDice());
        System.out.println("Skill: Swimming is " + testPok.swimming.getDice());
        System.out.println("Skill: Fighting is " + testPok.fighting.getDice());
        System.out.println("Skill: Sp. Attack is " + testPok.spAttack.getDice());
        System.out.println("Skill: Climbing is " + testPok.climbing.getDice());
        System.out.println("Skill: Healing is " + testPok.healing.getDice());
        System.out.println("Skill: Taunting is " + testPok.taunting.getDice());
        System.out.println("Skill: Tracking is " + testPok.tracking.getDice());
        System.out.println("Skill: Charm is " + testPok.charm.getDice() + "\n");
        System.out.println("Locations found:");


        if (testPok.inArctic.spawnsHere())
        {   System.out.println("    Arctic");
        }
        if (testPok.inCaves.spawnsHere())
        {   System.out.println("    Caves");
        }
        if (testPok.inDesert.spawnsHere())
        {   System.out.println("    Desert");
        }
        if (testPok.inFreshWater.spawnsHere())
        {   System.out.println("    Fresh water");
        }
        if (testPok.inMountains.spawnsHere())
        {   System.out.println("    Mountains");
        }
        if (testPok.inSea.spawnsHere())
        {   System.out.println("    Sea");
        }
        if (testPok.inPlains.spawnsHere())
        {   System.out.println("    Plains");
        }
        if (testPok.inUrban.spawnsHere())
        {   System.out.println("    Urban area");
        }
        if (testPok.inVolcanic.spawnsHere())
        {   System.out.println("    Volcanos");
        }
        if (testPok.inWoods.spawnsHere())
        {   System.out.println("    Woods");
        }

        /*ArrayList<String> pokemonList = new ArrayList<String>(Arrays.asList(test.getPokemon()));
        for (int i=0; i<pokemonList.size(); i++)
        {
            Integer number = i+1;
            System.out.println(number + " " + pokemonList.get(i));
        }*/
    }

}
import java.io.*;
import java.util.*;

/*
   Todo:
   
*/

public class Pokemon
{    
    public Integer ndex;
    public String pokemonName;
    public Type primaryType;
    public Type secondaryType;
    public Integer evolutionaryStage;
    public Location inArctic;
    public Location inCaves;
    public Location inDesert;
    public Location inFreshWater;
    public Location inMountains;
    public Location inSea;
    public Location inPlains;
    public Location inUrban;
    public Location inVolcanic;
    public Location inWoods;
    public Integer rareness;
    public Integer maxGroupSize;
    public Integer aggro;
    public String pokemonFamily;

    public Integer pace;
    public Integer evasionPenalty = 0;            // calculated
    public Attribute agility;
    public Attribute smarts;
    public Attribute strength;
    public Attribute spirit;
    public Attribute vigor;
    public Attribute running;                     // calculated
    public PhysicalAttribute weak;
    public PhysicalAttribute strong;
    public PhysicalAttribute small;
    public PhysicalAttribute large;
    public Attribute charisma;                    // calculated
    public Attribute parry;                       // calculated 
    public Attribute toughness;                   // calculated
    public Skill intimidation;
    public Skill notice;
    public Skill stealth;
    public Skill survival;
    public Skill swimming;
    public Skill fighting;
    public Skill spAttack;
    public Skill climbing;
    public Skill healing;
    public Skill taunting;
    public Skill tracking;
    public Skill charm;
    public ArrayList<String> edges = new ArrayList<String>(4);     // armed, aquatic, burrowing, cute, 
                                                                    // double attack, flight, hard 
                                                                    // majestic, reach, rock hard, 
                                                                    //speedy flight, teleporation, transforms
    public ArrayList<String> hindrances = new ArrayList<String>(2);       // always aquatic, rage, ugly

    private String workingdir = System.getProperty("user.dir");
    private ArrayList<Skill> skillList = new ArrayList<Skill>(12);

    public Pokemon(ArrayList<String> pokemonStats)
    {
        create(pokemonStats);
    }

    private Boolean convertIntToBool(Integer intIn)
    {
        if (intIn == 1)
        {   return true;
        }
        else
        {   return false;
        }
    }

    public void create(ArrayList<String> listIn)
    {

        this.weak = new PhysicalAttribute(Integer.parseInt(listIn.get(11)));
        this.strong = new PhysicalAttribute(Integer.parseInt(listIn.get(12)));
        this.small = new PhysicalAttribute(Integer.parseInt(listIn.get(13)));
        this.large = new PhysicalAttribute(Integer.parseInt(listIn.get(14)));
        
        // Assigns numer of pokemon, removing # character
        this.ndex = Integer.parseInt(listIn.get(0).substring(1).replaceFirst("^0+(?!$)", ""));         
        this.pokemonName = listIn.get(1);
        this.primaryType = new Type(true, listIn.get(2));
        this.secondaryType = new Type(false, listIn.get(3));
        this.evolutionaryStage = Integer.parseInt(listIn.get(4));
        this.pace = Integer.parseInt(listIn.get(5));

        this.agility = new Attribute(Integer.parseInt(listIn.get(6)), 0);
        this.smarts = new Attribute(Integer.parseInt(listIn.get(7)), 0);
        this.spirit = new Attribute(Integer.parseInt(listIn.get(9)), 0);
        this.vigor = new Attribute(Integer.parseInt(listIn.get(10)), 0);

        this.intimidation = new Skill(Integer.parseInt(listIn.get(18)));
        this.notice = new Skill(Integer.parseInt(listIn.get(19)));
        this.stealth = new Skill(Integer.parseInt(listIn.get(20)));
        this.survival = new Skill(Integer.parseInt(listIn.get(21)));
        this.swimming = new Skill(Integer.parseInt(listIn.get(22)));
        this.fighting = new Skill(Integer.parseInt(listIn.get(23)));
        this.spAttack = new Skill(Integer.parseInt(listIn.get(24)));
        this.climbing = new Skill(Integer.parseInt(listIn.get(25)));
        this.healing = new Skill(Integer.parseInt(listIn.get(26)));
        this.taunting = new Skill(Integer.parseInt(listIn.get(27)));
        this.tracking = new Skill(Integer.parseInt(listIn.get(28)));
        this.charm = new Skill(Integer.parseInt(listIn.get(29)));

        for (int i=0; i<4; i++)
        {   this.edges.add(listIn.get(30+i));
        }

        for (int j=0; j<2; j++)
        {   this.hindrances.add(listIn.get(34+j));
        }

        this.inArctic = new Location(convertIntToBool(Integer.parseInt(listIn.get(36))));
        this.inCaves = new Location(convertIntToBool(Integer.parseInt(listIn.get(37))));
        this.inDesert = new Location(convertIntToBool(Integer.parseInt(listIn.get(38))));
        this.inFreshWater = new Location(convertIntToBool(Integer.parseInt(listIn.get(39))));
        this.inMountains = new Location(convertIntToBool(Integer.parseInt(listIn.get(40))));
        this.inSea = new Location(convertIntToBool(Integer.parseInt(listIn.get(41))));
        this.inPlains = new Location(convertIntToBool(Integer.parseInt(listIn.get(42))));
        this.inUrban = new Location(convertIntToBool(Integer.parseInt(listIn.get(43))));
        this.inVolcanic = new Location(convertIntToBool(Integer.parseInt(listIn.get(44))));
        this.inWoods = new Location(convertIntToBool(Integer.parseInt(listIn.get(45))));

        this.rareness = Integer.parseInt(listIn.get(46));
        this.maxGroupSize = Integer.parseInt(listIn.get(47));
        this.aggro = Integer.parseInt(listIn.get(48));
        this.pokemonFamily = listIn.get(49);

        // Includes calculated modifier.
        this.strength = new Attribute(Integer.parseInt(listIn.get(8)), this.strong.get() + this.large.get() - this.weak.get());

        this.skillList.add(this.intimidation);
        this.skillList.add(this.notice);
        this.skillList.add(this.stealth);
        this.skillList.add(this.survival);
        this.skillList.add(this.swimming);
        this.skillList.add(this.fighting);
        this.skillList.add(this.spAttack);
        this.skillList.add(this.climbing);
        this.skillList.add(this.healing);
        this.skillList.add(this.taunting);
        this.skillList.add(this.tracking);
        this.skillList.add(this.charm);

        calculateOthers();
        randomiseSkills();
    }

    private void calculateOthers()
    {
        //calculate charisma, parry, toughness here
        // charisma = +2 if cute or majestic, -2 if ugly
        // parry = (fighting / 2) + 2
        // toughness = (vigor / 2) + 2
        //      + 2 if hard
        //      + 4 if rock hard
        //      + large amount
        //      - small amount

        this.toughness = new Attribute((this.vigor.getDice() / 2) + 2 + this.large.get() - this.small.get(), 0);
        this.parry = new Attribute((this.fighting.getDice() / 2) + 2, 0);
        this.charisma = new Attribute(0,0);
        this.running = new Attribute(0,0);

        // Calculate charisma
        if (this.edges.contains("Cute") || this.edges.contains("Majestic"))
        {   this.charisma.setDice(this.charisma.getDice() + 2);
        }
        if (this.hindrances.contains("Ugly"))
        {   this.charisma.setDice(this.charisma.getDice() - 2);
        }

        // Calculate toughness
        if (this.edges.contains("Hard"))
        {   this.toughness.setDice(this.toughness.getDice() + 2);
        }
        if (this.edges.contains("Rock Hard"))
        {   this.toughness.setDice(this.toughness.getDice() + 4);
        }
        
        // Calculate evasionPenalty
        if (this.large.get().equals(4))
        {
            this.evasionPenalty += 2;
        }
        if (this.small.get().equals(2))
        {
            this.evasionPenalty -= 2;
        }

        // Calculate running
        if (this.pace < 12)
        {   if (this.pace < 10)
            {   if (this.pace < 8)
                {   if (this.pace < 6)
                    {   this.running.setDice(4);
                    }
                    else
                    {   this.running.setDice(6);
                    }
                }
                else
                {   this.running.setDice(8);
                }
            }
            else
            {   this.running.setDice(10);
            }
        }
        else
        {    this.running.setDice(12);
        }
    }    

    private Boolean rng(Integer max, Integer threshold)
    {
        Random rand = new Random();
        int n = rand.nextInt(max);
        if (n <= threshold)
        {   return true;
        }
        else
        {   return false;
        }
    }

    private void randomiseSkills()
    {
        Integer currentDice = 0;
        for (int i=0; i<this.skillList.size(); i++)
        {
            currentDice = skillList.get(i).getDice();
            if (rng(100,10) && (currentDice > 0))
            {   skillList.get(i).setDice(currentDice + 2);
            }

        }
    }

    /****************************************
        GETTERS
    ****************************************/

    public String getName()
    {
        return this.pokemonName;
    }

    public Integer getPokedexNumber()
    {
        return this.ndex;
    }

    public Integer getEvolutionaryStage()
    {
        return this.evolutionaryStage;
    }

    public Integer getPace()
    {
        return this.pace;
    }

    public Integer getRareness()
    {
        return this.rareness;
    }

    public Integer getMaxGroupSize()
    {
        return this.maxGroupSize;
    }

    public Integer getAggro()
    {
        return this.aggro;
    }

    public String getFamily()
    {
        return this.pokemonFamily;
    }

    public ArrayList<String> getEdges()
    {
        return this.edges;
    }

    public ArrayList<String> getHindrances()
    {
        return this.hindrances;
    }

    /****************************************
        SUBCLASSES
    ****************************************/

    public class Type
    {
        private Boolean primaryBool = null;
        private String type = "";

        public Type(Boolean primaryIn, String typeIn)
        {
            primaryBool = primaryIn;
            type = typeIn;
        }

        public Boolean isPrimary()
        {
            return this.primaryBool;
        }

        public String getType()
        {
            return this.type;
        }

    } 

    public class Attribute
    {
        private Integer diceNumber = 0;
        private Integer modifier = 0;

        public Attribute(Integer diceIn, Integer modifierIn)
        {
            diceNumber = diceIn;
            modifier = modifierIn;
        }

        public Integer getDice()
        {
            return diceNumber;
        }

        public Integer getModifier()
        {
            return modifier;
        }

        public void setDice(Integer diceIn)
        {
            diceNumber = diceIn;
        }

        public void setModifier(Integer modifierIn)
        {
            modifier = modifierIn;
        }
    }

    public class PhysicalAttribute
    {
        private Integer degree;

        public PhysicalAttribute(Integer intIn)
        {
            degree = intIn;
        }

        public void set(Integer intIn)
        {
            degree = intIn;
        }

        public Integer get()
        {
            return this.degree;
        }
    }

    public class Skill
    {
        private Integer diceNumber = 0;

        public Skill(Integer diceIn)
        {
            diceNumber = diceIn;
        }

        public Integer getDice()
        {
            return this.diceNumber;
        }

        public void setDice(Integer diceIn)
        {
            this.diceNumber = diceIn;
        }
    }

    public class Location
    {
        private Boolean spawnsHere;
        public Location(Boolean boolIn)
        {
            spawnsHere = boolIn;
        }

        public void setSpawn(Boolean boolIn)
        {
            this.spawnsHere = boolIn;
        }

        public Boolean spawnsHere()
        {
            return this.spawnsHere;
        }
    }
    
}
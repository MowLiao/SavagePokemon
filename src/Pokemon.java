import java.io.*;
import java.util.*;

public class Pokemon
{    
    private String workingdir = System.getProperty("user.dir");

    private Integer ndex;
    private String pokemonName;
    private Type primaryType;
    private Type secondaryType;
    private Integer evolutionaryStage;
    private Integer pace;
    private Attribute agility;
    private Attribute smarts;
    private Attribute strength;
    private Attribute spirit;
    private Attribute vigor;
    private PhysicalAttribute weak;
    private PhysicalAttribute strong;
    private PhysicalAttribute small;
    private PhysicalAttribute large;
    private Attribute charisma;                    // calculated
    private Attribute parry;                       // calculated 
    private Attribute toughness;                   // calculated
    private Skill intimidation;
    private Skill notice;
    private Skill stealth;
    private Skill survival;
    private Skill swimming;
    private Skill fighting;
    private Skill spAttack;
    private Skill climbing;
    private Skill healing;
    private Skill taunting;
    private Skill tracking;
    private Skill charm;
    private ArrayList<String> edges = new ArrayList<String>(4);     // armed, aquatic, burrowing, cute, 
                                                                    // double attack, flight, hard 
                                                                    // majestic, reach, roch hard, 
                                                                    //speedy flight, teleporation, transforms
    private ArrayList<String> hindrances = new ArrayList<String>(2);       // always aquatic, rage, ugly
    private Location inArctic;
    private Location inCaves;
    private Location inDesert;
    private Location inFreshWater;
    private Location inMountains;
    private Location inSea;
    private Location inPlains;
    private Location inUrban;
    private Location inVolcanic;
    private Location inWoods;
    private Integer rareness;
    private Integer maxGroupSize;
    private Integer aggro;
    private String pokemonFamily;

    public Pokemon(ArrayList<String> pokemonStats)
    {
        create(pokemonStats);
    }

    public void create(ArrayList<String> listIn)
    {
        this.ndex = Integer.parseInt(listIn.get(0).substring(1).replaceFirst("^0+(?!$)", ""));
        this.pokemonName = listIn.get(1);
        this.primaryType = new Type(true, listIn.get(2));
        this.secondaryType = new Type(false, listIn.get(3));
        this.evolutionaryStage = Integer.parseInt(listIn.get(4));
        this.pace = Integer.parseInt(listIn.get(5));

        this.agility = new Attribute(Integer.parseInt(listIn.get(6)), 0);
        this.smarts = new Attribute(Integer.parseInt(listIn.get(7)), 0);
        this.strength = new Attribute(Integer.parseInt(listIn.get(8)), 0);
        this.spirit = new Attribute(Integer.parseInt(listIn.get(9)), 0);
        this.vigor = new Attribute(Integer.parseInt(listIn.get(10)), 0);

        this.weak = new PhysicalAttribute(convertIntToBool(Integer.parseInt(listIn.get(11))));
        this.strong = new PhysicalAttribute(convertIntToBool(Integer.parseInt(listIn.get(12))));
        this.small = new PhysicalAttribute(convertIntToBool(Integer.parseInt(listIn.get(13))));
        this.large = new PhysicalAttribute(convertIntToBool(Integer.parseInt(listIn.get(14))));

        this.intimidation = new Skill(Integer.parseInt(listIn.get(18)), 0);
        this.notice = new Skill(Integer.parseInt(listIn.get(19)), 0);
        this.stealth = new Skill(Integer.parseInt(listIn.get(20)), 0);
        this.survival = new Skill(Integer.parseInt(listIn.get(21)), 0);
        this.swimming = new Skill(Integer.parseInt(listIn.get(22)), 0);
        this.fighting = new Skill(Integer.parseInt(listIn.get(23)), 0);
        this.spAttack = new Skill(Integer.parseInt(listIn.get(24)), 0);
        this.climbing = new Skill(Integer.parseInt(listIn.get(25)), 0);
        this.healing = new Skill(Integer.parseInt(listIn.get(26)), 0);
        this.taunting = new Skill(Integer.parseInt(listIn.get(27)), 0);
        this.tracking = new Skill(Integer.parseInt(listIn.get(28)), 0);
        this.charm = new Skill(Integer.parseInt(listIn.get(29)), 0);

        for (int i=0; i<4; i++)
        {
            this.edges.add(listIn.get(30+i));
        }

        for (int j=0; j<2; j++)
        {
            this.hindrances.add(listIn.get(34+j));
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
        //this.pokemonFamily = listIn.get(49);

        calculateCPT();
    }

    private void calculateCPT()
    {
        //calculate charisma, parry, toughness here
    }

    private Boolean convertIntToBool(Integer intIn)
    {
        if (intIn == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /****************************************
        GETTERS AND SETTERS
    ****************************************/

    public String getName()
    {
        return this.pokemonName;
    }

    public Integer getPokedexNumbr()
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
            return this.diceNumber;
        }

        public Integer getModifier()
        {
            return this.modifier;
        }

        public void setDice(Integer diceIn)
        {
            this.diceNumber = diceIn;
        }

        public void setModifier(Integer modifierIn)
        {
            this.modifier = modifierIn;
        }
    }

    public class PhysicalAttribute
    {
        private Boolean isSet;

        public PhysicalAttribute(Boolean boolIn)
        {
            isSet = boolIn;
        }

        public void set(Boolean boolIn)
        {
            isSet = boolIn;
        }

        public Boolean isSet()
        {
            return this.isSet;
        }
    }

    public class Skill
    {
        private Integer diceNumber = 0;
        private Integer modifier = 0;

        public Skill(Integer diceIn, Integer modifierIn)
        {
            diceNumber = diceIn;
            modifier = modifierIn;
        }

        public Integer getDice()
        {
            return this.diceNumber;
        }

        public Integer getModifier()
        {
            return this.modifier;
        }

        public void setDice(Integer diceIn)
        {
            this.diceNumber = diceIn;
        }

        public void setModifier(Integer modifierIn)
        {
            this.modifier = modifierIn;
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
import java.io.*;

public class Pokemon
{
    private String workingdir = System.getProperty("user.dir");
    
        public Integer ndex;
        public String pokemon;
        public Type primaryType;
        public Type secondaryType;
        public Integer evolutionaryStage;
        public Integer pace;
        public Attribute agility;
        public Attribute smarts;
        public Attribute strength;
        public Attribute spirit;
        public Attribute vigor;
        public PhysicalAttribute weak;
        public PhysicalAttribute strong;
        public PhysicalAttribute small;
        public PhysicalAttribute large;
        public Attribute charisma;                    // calculated
        public Attribute parry;                       // calculated 
        public Attribute toughness;                   // calculated
        public Skill imtidation;
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
        public Skill[] edges = new Skill[4];            // armed, aquatic, burrowing, cute, double attack, flight, hard, majestic, reach, roch hard, speedy flight, teleporation, transforms
        public Skill[] hindrances = new Skill[2];     // always aquatic, rage, ugly
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

        public void create(ArrayList<E> listIn)
        {
            this.ndex = Integer.parseInt(listIn[0]);
            this.pokemon = listIn[1];
            this.primaryType = new Type(true, listIn[2]);
            this.secondaryType = new Type(false, listIn[3]);
            this.evolutionaryStage = Integer.parseInt(listIn[4]);
            this.pace = Integer.parseInt(listIn[5]);

            this.agility = new Attribute(Integer.parseInt(ListIn[6]), 0);
            this.smarts = new Attribute(Integer.parseInt(ListIn[7]), 0);
            this.strength = new Attribute(Integer.parseInt(ListIn[8]), 0);
            this.spirit = new Attribute(Integer.parseInt(ListIn[9]), 0);
            this.vigor = new Attribute(Integer.parseInt(ListIn[10]), 0);

            this.weak = new PhysicalAttribute(convertIntToBool(Integer.parseInt(ListIn[11])));
            this.strong = new PhysicalAttribute(convertIntToBool(Integer.parseInt(ListIn[12])));
            this.small = new PhysicalAttribute(convertIntToBool(Integer.parseInt(ListIn[13])));
            this.large = new PhysicalAttribute(convertIntToBool(Integer.parseInt(ListIn[14])));

            this.intimidation = new Skill(Integer.parseInt(ListIn[18]));
            this.notice = new Skill(Integer.parseInt(ListIn[19]));
            this.stealth = new Skill(Integer.parseInt(ListIn[20]));
            this.survival = new Skill(Integer.parseInt(ListIn[21]));
            this.swimming = new Skill(Integer.parseInt(ListIn[22]));
            this.fighting = new Skill(Integer.parseInt(ListIn[23]));
            this.spAttack = new Skill(Integer.parseInt(ListIn[24]));
            this.climbing = new Skill(Integer.parseInt(ListIn[25]));
            this.healing = new Skill(Integer.parseInt(ListIn[26]));
            this.taunting = new Skill(Integer.parseInt(ListIn[27]));
            this.tracking = new Skill(Integer.parseInt(ListIn[28]));
            this.charm = new Skill(Integer.parseInt(ListIn[29]));

            this.inArctic = new Location(convertIntToBool(Integer.parseInt(ListIn[36])));
            this.inCaves = new Location(convertIntToBool(Integer.parseInt(ListIn[37])));
            this.inDesert = new Location(convertIntToBool(Integer.parseInt(ListIn[38])));
            this.inFreshWater = new Location(convertIntToBool(Integer.parseInt(ListIn[39])));
            this.inMountains = new Location(convertIntToBool(Integer.parseInt(ListIn[40])));
            this.inSea = new Location(convertIntToBool(Integer.parseInt(ListIn[41])));
            this.inPlains = new Location(convertIntToBool(Integer.parseInt(ListIn[42])));
            this.inUrban = new Location(convertIntToBool(Integer.parseInt(ListIn[43])));
            this.inVolcanic = new Location(convertIntToBool(Integer.parseInt(ListIn[44])));
            this.inWoods = new Location(convertIntToBool(Integer.parseInt(ListIn[45])));

            this.rareness = Integer.parseInt(listIn[46]);
            this.maxGroupSize = Integer.parseInt(listIn[47]);
            this.aggro = Integer.parseInt(listIn[48]);
            this.pokemonFamily = listIn[49];

            setEdges();
            setHindrance();
            calculateCPT();
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

        private void setEdges()
        {
            for (int i=0; i<4; i++)
            {
                this.edges[i] = null;
            }

        }

        private void setHindrances()
        {
            for (int j=0; j<2; j++)
            {
                this.hindrances = null;
            }

        }

        private void calculateCPT()
        {
            //calculate charisma, parry, toughness here
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
                modifer = modifierIn;
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

            public void set(Bool boolin)
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
                modifer = modifierIn;
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
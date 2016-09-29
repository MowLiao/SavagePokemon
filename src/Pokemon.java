import java.io.*;

public class Pokemon
{
    private String workingdir = System.getProperty("user.dir");
    
        public Integer ndex
        public String pokemon
        public Type primaryType = null;
        public Type secondaryType = null;
        public Integer evolutionarystage
        public Integer pace
        public Integer agility
        public Integer smarts
        public Integer strength
        public Integer spirit
        public Integer vigor 
        public Boolean weak
        public Boolean strong
        public Boolean small
        public Boolean large
        public Integer charisma                     // calculated
        public Integer parry                        // calculated 
        public Integer toughness                    // calculated
        public Integer Integerimidation
        public Integer notice
        public Integer stealth
        public Integer survival
        public Integer swimming
        public Integer fighting
        public Integer spAttack
        public Integer climbing
        public Integer healing
        public Integer taunting
        public Integer tracking
        public Integer charm
        public Integer edges            // armed, aquatic, burrowing, cute, double attack, flight, hard, majestic, reach, roch hard, speedy flight, teleporation, transforms
        public Integer hindrances       // always aquatic, rage, ugly
        public Boolean inArctic
        public Boolean inCaves
        public Boolean inDesert
        public Boolean inFreshWater
        public Boolean inMountains
        public Boolean inSea
        public Boolean inPlains
        public Boolean inUrban
        public Boolean inVolcanic
        public Boolean inWoods
        public Boolean rareness
        public Boolean maxgroupsize
        public Boolean aggressiveness
        public Boolean pokemonFamily

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
            private String attribute = "";
            private Integer diceNumber = 0;
            private Integer modifier = 0;

            public Attribute(String attributeIn, Integer diceIn, Integer modifierIn)
            {
                attribute = attributeIn;
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

            public setDice(Integer diceIn)
            {
                this.diceNumber = diceIn;
            }

            public setModifier(Integer modifierIn)
            {
                this.modifier = modifierIn;
            }
        }

        public class PhysicalAttribute
        {
            private String attribute = "";
            private Boolean isSet;

            public Attribute(String attributeIn, Integer diceIn, Integer modifierIn)
            {
                attribute = attributeIn;
                diceNumber = diceIn;
                modifer = modifierIn;
            }

            public setDice(Integer diceIn)
            {
                this.diceNumber = diceIn;
            }

            public setModifier(Integer modifierIn)
            {
                this.modifier = modifierIn;
            }
        }


    
}
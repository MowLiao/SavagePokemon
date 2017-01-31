import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/*
*  Next TODO: Create all components in createComponents()
*
*/

public class GenerationTab extends JPanel
{
    private static final long serialVersionUID = 1;

    private Pokedex pokedex = null;
    private String[] pokedexList = null;
    private String[] regionList = Config.REGIONLIST;

    private ArrayList<Pokemon> generatedPokemonList;
    private ArrayList<JTable> attrSkillTables;
    private JScrollPane generatedPokemonListView;
    private JTabbedPane skillAttrTabbedPane;
    private JScrollPane genSkills;
    private JScrollPane fgtSkills;
    private JScrollPane spSkills;

    private JComboBox<String> pokedexCombo;
    private JComboBox<String> regionCombo;

    private JLabel pokemonName;
    private JLabel type1;
    private JLabel type2;
    
    private JLabel charismaNum;
    private JLabel paceNum;
    private JLabel parryNum;
    private JLabel toughnessNum;

    private JLabel evaPenaltyNum;
    private JLabel evoStageNum;

    private JTextArea edgesText;
    private JTextArea hindrancesText;
    private JTextArea notesText;

    private JSpinner woundsSpinner;
    private JSpinner fatigueSpinner;
    private JSpinner difficultySpinner;

    private JButton generateButton;
    private JButton clearAllGenerated;
    private JButton clearSelectedGenerated;
    private JButton rollButton;
    private JButton movesButton;

    private JCheckBox herdSpawningCheck;
    private JCheckBox selectPokemonCheck;

    public GenerationTab()
    {
        pokedex = new Pokedex();
        pokedexList = pokedex.getPokemon();
        createComponents();
        setLayout();
    }

    private ArrayList<JTable> createTables(Pokemon inPokemon)
    {
        // Divide skill section into "general", "fighting", "special", shown as tabs
        ArrayList<JTable> returnArrayList = new ArrayList<JTable>();
        String[] skillTableColumns = {"Skill", "Die"};

        Object[][] genSkillTableData = 
        {
            {"Climbing",        inPokemon.climbing.getDice()},
            {"Intimidation",    inPokemon.intimidation.getDice()},
            {"Notice",          inPokemon.notice.getDice()},
            {"Stealth",         inPokemon.stealth.getDice()},
            {"Survival",        inPokemon.survival.getDice()},
            {"Taunting",        inPokemon.taunting.getDice()},
            {"Tracking",        inPokemon.tracking.getDice()}
        };

        Object[][] fgtSkillTableData = 
        {
            {"Fighting",    inPokemon.fighting.getDice()},
            {"Sp. Attack",  inPokemon.spAttack.getDice()},
        };

        Object[][] spSkillTableData = 
        {
            {"Charm",       inPokemon.charm.getDice()},
            {"Healing",     inPokemon.healing.getDice()},
            {"Swimming",    inPokemon.swimming.getDice()},
        };

        String[] attributeTableColumns = {"Attribute", "Die", "Modifier"};
        Object[][] attrTableData =
        {
            {"Agility",     inPokemon.agility.getDice(),    inPokemon.agility.getModifier()},
            {"Smarts",      inPokemon.smarts.getDice(),     inPokemon.smarts.getModifier()},
            {"Spirit",      inPokemon.spirit.getDice(),     inPokemon.spirit.getModifier()},
            {"Strength",    inPokemon.strength.getDice(),   inPokemon.strength.getModifier()},
            {"Vigor",       inPokemon.vigor.getDice(),      inPokemon.vigor.getModifier()}
        };

        JTable genTable = new JTable(genSkillTableData, skillTableColumns);
        returnArrayList.add(genTable);
        JTable fgtTable = new JTable(fgtSkillTableData, skillTableColumns);
        returnArrayList.add(fgtTable);
        JTable spTable = new JTable(spSkillTableData, skillTableColumns);
        returnArrayList.add(spTable);
        JTable attTable = new JTable(attrTableData, attributeTableColumns);
        returnArrayList.add(attTable);

        return returnArrayList;
    }

    private ArrayList<JTable> createTables()
    {
        ArrayList<JTable> returnArrayList = new ArrayList<JTable>();
        String[] skillTableColumns = {"Skill", "Die"};

        Object[][] genSkillTableData =  {{"none", "none"}};
        Object[][] fgtSkillTableData =  {{"none", "none"}};
        Object[][] spSkillTableData =  {{"none", "none"}};

        String[] attributeTableColumns = {"Attribute", "Die", "Modifier"};
        Object[][] attrTableData =
        {
            {"Agility",     "none",     "0"},
            {"Smarts",      "none",     "0"},
            {"Spirit",      "none",     "0"},
            {"Strength",    "none",     "0"},
            {"Vigor",       "none",     "0"},
        };

        JTable genTable = new JTable(genSkillTableData, skillTableColumns);
        returnArrayList.add(genTable);
        JTable fgtTable = new JTable(fgtSkillTableData, skillTableColumns);
        returnArrayList.add(fgtTable);
        JTable spTable = new JTable(spSkillTableData, skillTableColumns);
        returnArrayList.add(spTable);
        JTable attTable = new JTable(attrTableData, attributeTableColumns);
        returnArrayList.add(attTable);

        return returnArrayList;
    }

    private void createComponents()
    {
        this.pokedexCombo = new JComboBox<String>(pokedexList);
        this.regionCombo = new JComboBox<String>(regionList);

        this.selectPokemonCheck = new JCheckBox();
        this.herdSpawningCheck = new JCheckBox("Herd Spawning");

        this.pokemonName = new JLabel();
        this.type1 = new JLabel();
        this.type2 = new JLabel();
        this.charismaNum = new JLabel();
        this.paceNum = new JLabel();
        this.parryNum = new JLabel();
        this.toughnessNum = new JLabel();
        this.evaPenaltyNum = new JLabel();
        this.evoStageNum = new JLabel();

        this.edgesText = new JTextArea();
        this.hindrancesText = new JTextArea();
        this.notesText = new JTextArea();

        this.woundsSpinner = new JSpinner(new SpinnerNumberModel(0,0,3,1));
        this.fatigueSpinner = new JSpinner(new SpinnerNumberModel(0,0,2,1));
        // Check this with Kai - how many "variances" of difficulty?
        this.difficultySpinner = new JSpinner(new SpinnerNumberModel(1,1,5,1));

        this.generateButton = new JButton("Generate");
        this.clearAllGenerated = new JButton("Clear All");
        this.clearSelectedGenerated = new JButton("Clear Selected");
        this.rollButton = new JButton("Roll");
        this.movesButton = new JButton("Open Moves");

        this.attrSkillTables = this.createTables();
    }


    private void setLayout()
    {
        Box generationButtonBox = new Box(BoxLayout.LINE_AXIS);
        generationButtonBox.add(this.clearSelectedGenerated);
        generationButtonBox.add(this.clearAllGenerated);

        Box generationBox = new Box(BoxLayout.PAGE_AXIS);
        generationBox.add(generationButtonBox);
        generationBox.add(this.movesButton);

        Box generateButtonRegionBox = new Box(BoxLayout.LINE_AXIS);
        generateButtonRegionBox.add(this.regionCombo);
        generateButtonRegionBox.add(this.generateButton);

        Box generateOptionsBox = new Box(BoxLayout.LINE_AXIS);
        generateOptionsBox.add(this.selectPokemonCheck);
        generateOptionsBox.add(this.pokedexCombo);
        generateOptionsBox.add(this.herdSpawningCheck);

        Box generateBox = new Box(BoxLayout.PAGE_AXIS);
        generateBox.add(generateButtonRegionBox);
        generateBox.add(generateOptionsBox);

        Box typeBox = new Box(BoxLayout.PAGE_AXIS);
        typeBox.add(this.type1);
        typeBox.add(this.type2);

        Box nameTypeBox = new Box(BoxLayout.LINE_AXIS);
        nameTypeBox.add(this.pokemonName);
        nameTypeBox.add(typeBox);

        Box statsBox = new Box(BoxLayout.LINE_AXIS);
        statsBox.add(this.charismaNum);
        statsBox.add(this.paceNum);
        statsBox.add(this.parryNum);
        statsBox.add(this.toughnessNum);
        statsBox.add(this.evaPenaltyNum);
        statsBox.add(this.evoStageNum);

        this.skillAttrTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        this.skillAttrTabbedPane.addTab("Attributes",this.attrSkillTables.get(0));
        this.skillAttrTabbedPane.addTab("General",this.attrSkillTables.get(1));
        this.skillAttrTabbedPane.addTab("Fighting",this.attrSkillTables.get(2));
        this.skillAttrTabbedPane.addTab("Special",this.attrSkillTables.get(3));

        Box saEdgeHindBox = new Box(BoxLayout.LINE_AXIS);
        Box edgeHindBox = new Box(BoxLayout.PAGE_AXIS);
        Box miscBox = new Box(BoxLayout.LINE_AXIS);
        Box woundsBox = new Box(BoxLayout.PAGE_AXIS);
        Box fatigueBox = new Box(BoxLayout.PAGE_AXIS);

        Box detailsBox = new Box(BoxLayout.PAGE_AXIS);

        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(mainLayout);


        this.genSkills = new JScrollPane();
        this.fgtSkills = new JScrollPane();
        this.spSkills = new JScrollPane();
    }
}
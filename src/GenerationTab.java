import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import static config.*;

public class GenerationTab extends JPanel
{
    private Pokedex pokedex = null;
    private String[] pokedexList = null;
    private ArrayList<Pokemon> generatedPokemonList = new ArrayList<Pokemon>();
    private ArrayList<JList> specialSkillsList = new ArrayList<JList>();

    private JScrollPane generatedPokemonListView;
    private DefaultListModel<String> generatedPokemonListModel;

    private ArrayList<JList> regionList = config.regionList;

    private JLabel type1;
    private JLabel type2;
    private JLabel evStage;
    private JLabel pace;
    private JLabel agility;
    private JLabel smarts;
    private JLabel spirit;
    private JLabel strength;
    private JLabel vigor;

    // Divide skill section into "general", "fighting", "special", shown as tabs
    private String[] genSkillTableColumns = {"Skill", "Die"};
    private Object[][] genSkillTableData = {
                                            {"Charm"},
                                            {"Climbing"},
                                            {"Healing"},
                                            {"Intimidation"},
                                            {},
                                            {},
                                            {},
                                            {},
                                            {},
                                            {},
                                            {}
                                        }

    private JButton generateButton;
    private JButton clearAllGenerated;
    private JButton clearSelectedGenerated;
    private JButton rollSelectedButton;


    public GenerationTab()
    {
        pokedex = new Pokedex();
        pokedexList = pokedex.getPokemon();
        createComponents();
        setLayout();
    }

    private void createComponents()
    {
        
    }

    private void setLayout()
    {
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(mainLayout);
    }
}
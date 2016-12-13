import java.awt.*;
import javax.swing.*;

import static config.*;

public class GenerationTab extends JPanel
{
    private Pokedex pokedex = null;
    private String[] pokedexList = null;
    private ArrayList<Pokemon> generatedPokemonList = new ArrayList<Pokemon>();
    private ArrayList<JList> specialSkillsList = new ArrayList<JList>();
    private ArrayList<JList> specialSkillsList = new ArrayList<JList>();
    private ArrayList<Integer> 

    private JScrollPane generatedPokemonListView;
    private DefaultListModel<String> generatedPokemonListModel;

    private ArrayList<JList> regionList = config.regionList;

    private JLabel type1;
    private JLabel type2;
    private JLabel charisma;
    private JLabel parry;
    private JLabel toughness;
    private JLabel pace;
    private JLabel fighting;
    private JLabel specialAttack;

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
import java.awt.*;
import javax.swing.*;

public class GenerationTab extends JPanel
{
    private ArrayList<JList> generatedPokemonList = new ArrayList<JList>();
    private ArrayList<JList> specialSkillsList = new ArrayList<JList>();
    private ArrayList<JList> specialSkillsList = new ArrayList<JList>();
    private JScrollPane generatedPokemonListView;
    private DefaultListModel<String> generatedPokemonListModel;

    private ArrayList<JList> regionList = new ArrayList<JList>();
    private String[] pokedexList;

    public GenerationTab()
    {
        createComponents();
        setLayout();
    }

    private void createComponents()
    {
        generatedList
    }

    private void setLayout()
    {
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(mainLayout);
    }
}
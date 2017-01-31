import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/*
* Next TODO: Create listener for menu bar
*
*
*
*
*/

public class MainUI extends JFrame
{
    private JTabbedPane tabbedPane;
    private JMenuBar menuBar;
    private JMenu optionsMenu;
    private GenerationTab generationTab;

    public MainUI()
    {
        setLayout(new BorderLayout());
        setSize(new Dimension(800,600));
        setPreferredSize(new Dimension(800,600));
        setResizable(true);
        setTitle("Pokemon Savage World App");

        createComponents();
        createLayout();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createComponents()
    {
        this.menuBar = new JMenuBar();
        this.optionsMenu = new JMenu("Options");
        this.tabbedPane = new JTabbedPane();
        this.generationTab = new GenerationTab();
    }

    private void createLayout()
    {
        this.optionsMenu.add(new JLabel("New"));
        this.optionsMenu.add(new JLabel("Load..."));
        this.optionsMenu.add(new JLabel("Save As..."));
        this.optionsMenu.add(new JLabel("About"));
        this.menuBar.add(this.optionsMenu);
        this.tabbedPane.addTab("Generation", generationTab);

        this.add(menuBar, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
    }


    /**
    * Main of the MainUI class; runs user interface.
    **/
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MainUI mui = new MainUI();
                mui.setVisible(true);
            }
        });
        
    }
}
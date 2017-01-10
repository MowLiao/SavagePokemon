import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainUI extends JFrame
{
    private JTabbedPane tabbedPane;
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
        this.tabbedPane = new JTabbedPane();
        this.generationTab = new GenerationTab();
    }

    private void createLayout()
    {
        this.tabbedPane.addTab("Generation", generationTab);
        this.add(tabbedPane);
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
import java.awt.*;
import javax.swing.*;

public class GenerationTab extends JPanel
{
    private JButton btn;

    public GenerationTab()
    {
        createComponents();
        setLayout();
    }

    private void createComponents()
    {
        this.btn = new JButton("Click me!");
    }

    private void setLayout()
    {
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(mainLayout);
        this.add(this.btn);
    }
}
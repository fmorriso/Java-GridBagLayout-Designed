import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel
{
    public DetailsPanel(Dimension parentSize)
    {
        Dimension size = getPreferredSize();
        size.width = parentSize.width / 2;
        size.height = parentSize.height;
        setPreferredSize(size);
        // put a border around our form
        setBorder(BorderFactory.createTitledBorder("Personal Details"));
    }
}

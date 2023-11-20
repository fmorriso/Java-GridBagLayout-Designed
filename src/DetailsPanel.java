import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel
{
    public DetailsPanel(Dimension frameSize)
    {
        Dimension size = getPreferredSize();
        size.width = frameSize.width / 2;
        size.height = frameSize.height;
        setPreferredSize(size);
        // put a border around our form
        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLabel =new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField nameField = new JTextField(10); // 10 = number of columns
        JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("Add");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
    }
}

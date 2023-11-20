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

        final int TEXT_FIELD_COLUMNS_WIDTH = size.width / 16;
        JTextField nameField = new JTextField(TEXT_FIELD_COLUMNS_WIDTH); // 10 = number of columns
        JTextField occupationField = new JTextField(TEXT_FIELD_COLUMNS_WIDTH);

        JButton addBtn = new JButton("Add");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // gc.fill = GridBagConstraints.HORIZONTAL;

        //// First row, first column
        gc.anchor = GridBagConstraints.LINE_END; // right-justify the JLabels
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        //// Second row, first column
        gc.gridx = 0;
        gc.gridy = 1;
        add(occupationLabel, gc);

        //// First row, second column
        gc.anchor = GridBagConstraints.LINE_START; // left-justify the text fields
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        //// Second row, second column
        gc.gridx = 1;
        gc.gridy = 1;
        add(occupationField, gc);

        /// Third row, second column
        gc.weighty = 10; // make the last row take up the majority of the vertical room
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);


    }
}

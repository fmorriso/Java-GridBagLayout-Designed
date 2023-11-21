import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;

public class DetailsPanel extends JPanel
{
    private EventListenerList listenerList = new EventListenerList();

    /** Constructs an instance of the Details panel, scaled with the help of the parent JFrame's dimension.
     * @param frameSize - The width and height of the parent JFrame in the form of a Dimension instance.
     */
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
        addBtn.addActionListener((ActionEvent ae) -> addBtnClicked(nameField.getText(), occupationField.getText()));


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

    /** Responds to the Add button being clicked.
     * @param name - the name of the person being added.
     * @param occupation - the occupation of the person being added.
     */
    private void addBtnClicked(String name, String occupation)
    {
        if(name.length() == 0 || occupation.length() == 0) return;
        String text = String.format("Name: %s%nOccupation: %s%n", name, occupation);
        fireDetailEvent(new DetailEvent(this, text));
    }

    public void fireDetailEvent(DetailEvent event)
    {
        // we only care about certain listeners
        DetailListener[] listeners = listenerList.getListeners(DetailListener.class);
        for (DetailListener detailListener: listeners)
        {
            detailListener.detailEventOccurred(event);
        }

        /* ALTERNATIVE USING ARRAYS
        // {class, listener} pairs
        Object[] listeners =  listenerList.getListenerList();
        for (int i = 0; i < listeners.length ; i += 2)
        {
            if(listeners[i] == DetailListener.class)
            {
                DetailListener listener = (DetailListener) listeners[i+1];
                listener.detailEventOccurred(event);
            }
        }
        */
    }

    public void addDetailListener(DetailListener listener)
    {
        listenerList.add(DetailListener.class, listener);
    }

    public void removeDetailListener(DetailListener listener)
    {
        listenerList.remove(DetailListener.class, listener);
    }
}

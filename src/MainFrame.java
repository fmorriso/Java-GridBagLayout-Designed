import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{

    // private JPanel contentPane;
    private DetailsPanel detailsPanel;

    @SuppressWarnings("unused")
	private MainFrame() {/* prevent default instances from being created */}

    /**
     * Create the frame.
    */
    public MainFrame(Dimension scaledSize)
    {
        setTitle(String.format("Java Swing Example using java version %s",getJavaVersion()));
        setSize(scaledSize);
        setPreferredSize(scaledSize);
        // center the JFrame in the middle of the screen
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Part II of videos:
        // 1. Set Layout Manager
        setLayout(new BorderLayout());


        // 2. Create Swing component
        JTextArea textArea = new JTextArea();

        detailsPanel = new DetailsPanel(scaledSize);
        detailsPanel.addDetailListener((DetailEvent event) ->
        {
            String text = event.getText();
            textArea.append(String.format("%s%n", text));
        });

        // 3. Add Swing component to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);

    }
    
    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }
    
}

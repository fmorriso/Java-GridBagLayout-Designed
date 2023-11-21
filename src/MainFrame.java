import java.awt.*;
import java.awt.event.ActionListener;
import java.net.JarURLConnection;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame
{

    private JPanel contentPane;
    private DetailsPanel detailsPanel;

    @SuppressWarnings("unused")
	private MainFrame() {/* prevent default instances from being created */}

    /**
     * Create the frame.
    */
    public MainFrame(Dimension scaledSize)
    {
        setTitle("Java Swing Example");
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
        detailsPanel.addDetailListener(new DetailListener(){
            @Override
            public void detailEventOccurred(DetailEvent event)
            {
                String text = event.getText();
                textArea.append(text);
            }
        });

        // 3. Add Swing component to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);

    }

    private void addLabel(JPanel pnl)
    {
        JLabel msg = new JLabel(String.format("Java version %s", getJavaVersionInformation()));
        pnl.add(msg);
    }

    private String getJavaVersionInformation() {
        String version = System.getProperty("java.version");

        Runtime.Version runTimeVersion = Runtime.version();
        version = runTimeVersion.toString();
        return version;
       /* 
        System.out.println("java.version=" + version);

        version = System.getProperty("java.specification.version");
        System.out.println("java.specification.version=" + version);

        version = System.getProperty("java.runtime.version");
        System.out.println("java.runtime.version=" + version);

        Runtime.Version runTimeVersion = Runtime.version();
        System.out.println("RunTime.Version=" + runTimeVersion);
        System.out.println("RunTime.Version.feature()=" + runTimeVersion.feature()); // major version
       */
    }

}

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.JarURLConnection;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame
{

    private JPanel contentPane;

    @SuppressWarnings("unused")
	private MainFrame() {/* prevent default instances from being created */}

    /**
     * Create the frame.
    */
    public MainFrame(Dimension scaledSize)
    {
        setTitle("Java Swing Example");
        setSize(scaledSize);
        // center the JFrame in the middle of the screen
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Part II of videos:
        // 1. Set Layout Manager
        setLayout(new BorderLayout());


        // 2. Create Swing component
        final JTextArea textArea = new JTextArea();
        JButton button = new JButton("Click me!" );
        button.addActionListener(ae -> {
            textArea.append("Hello\n");
        });

        // 3. Add Swing component to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);

        // ===============================================
/*
        contentPane = new JPanel();
        addLabel(contentPane);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0};
        gbl_contentPane.rowHeights = new int[]{0};
        gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
 */
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

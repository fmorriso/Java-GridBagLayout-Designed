import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

public class MainWindow extends JFrame
{

    private JPanel contentPane;

     /**
     * Create the frame.
     */
    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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

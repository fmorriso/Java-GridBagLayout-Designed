import javax.swing.SwingUtilities;

public class Driver
{
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
    	System.out.format("Java version: %s%n", getJavaVersion());
        SwingUtilities.invokeLater(new RunnableApp());
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

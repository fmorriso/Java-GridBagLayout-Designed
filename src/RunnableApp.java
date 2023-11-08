import java.awt.Dimension;

public class RunnableApp implements Runnable 
    {
        public void run()
        {
            try
            {
                Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.75, 100);
                MainFrame frame = new MainFrame(scaledSize);
                frame.setTitle("Java Swing Example");
                frame.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

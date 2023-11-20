import java.awt.Dimension;

public class RunnableApp implements Runnable 
    {
        public void run()
        {
            try
            {
                Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.5, 100);
                MainFrame frame = new MainFrame(scaledSize);
                frame.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

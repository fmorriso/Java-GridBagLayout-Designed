import java.awt.Dimension;

public class RunnableApp implements Runnable 
    {
        public void run()
        {
            try
            {
                Dimension scaledSize = SwingUtilities.getScaledSize(0.75, 100);
                MainWindow frame = new MainWindow(scaledSize);
                frame.setTitle("Java Swing Example");
                frame.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

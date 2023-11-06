    public class RunnableApp implements Runnable 
    {
        public void run()
        {
            try
            {
                MainWindow frame = new MainWindow();
                frame.setTitle("Java Swing Example");
                frame.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

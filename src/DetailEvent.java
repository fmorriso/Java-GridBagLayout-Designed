import java.util.EventObject;

public class DetailEvent extends EventObject
{
    private String text;

    /**
     * Constructs a Detail Event.
     *
     * @param source the object on which the Event initially occurred,
     *               which should be the Detail panel.
     * @param text
     * @throws IllegalArgumentException if source is null
     */
    public DetailEvent(Object source, String text)
    {
        super(source);
        this.text = text;
    }

    public String getText()
    {
        return text;
    }
}

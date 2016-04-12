/**
 * This class holds event data for use in the 
 * linked list calendar.
 * 
 * @author David McLellan
 * @version 7 APRIL 2016
 */
public class EventLink
{
    /*
     * Instance variables - Same as original but changing to support
     * links instead of array indices from original coding.
     */
    private EventLink previous;
    private EventLink next;
    private int field_clock;  // Using the field_clock as link key
    private int field_type;
    private int field_unit;
    private int field_status;
    private int[] event = new int[6];
    
    
    /*
     * Keeping compatiblity by initializing from randomizer array.
     * 
     * @param  event   Takes randomize data in array form
     */
    public EventLink(int[] event)
    {
        field_clock = event[1];
        field_type = event[2];
        field_unit = event[3];
        field_status = event[4];
        this.event = event;
    }
    
   
    public void displayEventLink()
    {
        String[] CURRENT_TYPE = {"FORCED OUTAGE", "MAINTENANCE",
            "INSTALLATION", "REMOVED", "RANDOM OUTAGE", "OPERATIONAL"};
        String currentType = CURRENT_TYPE[field_type];
        
        String[] CURRENT_STATUS = {"OFFLINE", "RUNNING"};
        String currentStatus = CURRENT_STATUS[field_status];
        
        String clock = String.format ("%08d", field_clock);
        
        System.out.println("");
        System.out.println("****************************************");
        System.out.println("* Event Data Elements");
        System.out.println("* Field Clock (KEY):  " + clock);
        System.out.println("* Field Type:         " + currentType);
        System.out.println("* Field Unit:         " + field_unit);
        System.out.println("* Field Status:       " + currentStatus);
        System.out.println("****************************************");
        System.out.println("");
    }
    
    public int getKey()
    {
        return field_clock;
    }
    
    public int getType()
    {
        return field_type;
    }
    
    public EventLink getPrevious()
    {
        return previous;
    }
    
    public void setPrevious(EventLink previous)
    {
        this.previous = previous;
    }
    
    public EventLink getNext()
    {
        return next;
    }
    
    public void setNext(EventLink next)
    {
        this.next = next;
    }
}

/**
 * This class holds event data for use in the 
 * Nested Array and Improved Nested Array calendar.
 * 
 * @author David McLellan
 * @version 7 APRIL 2016
 */
public class EventArray
{
    private final int CLOCK = 1;
    private final int TYPE = 2;
    private final int UNIT = 3;
    private final int STATUS = 4;
    private int[] event = new int[6];
    
    /*
     * Keeping compatiblity by initializing from randomizer array.
     * 
     * @param  event   Takes randomize data in array form
     */
    public EventArray(int[] event)
    {
        this.event[0] = 0;  // positional artifact from original system
        this.event[CLOCK] = event[1];
        this.event[TYPE] = event[2];
        this.event[UNIT] = event[3];
        this.event[STATUS] = event[4];
    }

    public void displayEvent()
    {
        String[] CURRENT_TYPE = {"FORCED OUTAGE", "MAINTENANCE",
            "INSTALLATION", "REMOVED", "RANDOM OUTAGE", "OPERATIONAL"};
        String currentType = CURRENT_TYPE[event[TYPE]];
        
        String[] CURRENT_STATUS = {"OFFLINE", "RUNNING"};
        String currentStatus = CURRENT_STATUS[event[STATUS]];
        
        String clock = String.format ("%08d", event[CLOCK]);
        
        System.out.println("");
        System.out.println("****************************************");
        System.out.println("* Event Data Elements");
        System.out.println("* Field Clock (KEY):  " + clock);
        System.out.println("* Field Type:         " + currentType);
        System.out.println("* Field Unit:         " + event[UNIT]);
        System.out.println("* Field Status:       " + currentStatus);
        System.out.println("****************************************");
        System.out.println("");
    }
    
    public int getKey()
    {
        return event[CLOCK];
    }
    
    public int getType()
    {
        return event[TYPE];
    }
}
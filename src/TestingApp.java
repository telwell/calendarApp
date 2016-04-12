import java.util.Random;
import java.util.*; 

/**
 * This class runs functionality and timed
 * tests on the three types of calendar
 * data structures: Linked List, Nested
 * Array, and Improved Nested Array.
 * 
 * Each test is run with the same number
 * of elements and performs the same tests
 * in sequence, using a randomizer.
 * 
 * @author David McLellan
 * @version 7 APRIL 2016
 */
public class TestingApp
{
    // Creates each of the three data structures to be tested.
    private static ImpNestedArrayCalendar inac = new ImpNestedArrayCalendar();
    private static NestedArrayCalendar nac = new NestedArrayCalendar();
    private static LinkedListCalendar llc = new LinkedListCalendar();
    
    // Creates randomizer object and supporting variables.
    private static Random rnd = new Random();
    private static int NUM_LINKS_TO_TEST = 1000000;
    private static int NUM_START = 1000;
    private static int RANGE = 6;
    private static long startTime;
    private static long stopTime;
    
    // Creates single event to be used in each test.
    private static int[] testEvent = {0,1234567,1,1,1,0};
    
    public static void main(String[] args)
    {
        // Runs calendar tests in order.
        inacTest();
        nacTest();
        llcTest();
    }
    
    /*
     * Tests each function of the specific calendar type
     * by calling the randomizer to initially load the 
     * calendar with a set number of events.
     */
    public static void inacTest()
    {
        System.out.println("");
        System.out.println("****** Begining Improved Nested Array Calendar Loading Test **********");
        System.out.println("");
        System.out.println("Running Initial Test on " + NUM_LINKS_TO_TEST + " events.");
        startTime = System.currentTimeMillis();
        inacRandomizer(NUM_LINKS_TO_TEST);
        stopTime = System.currentTimeMillis();
        System.out.println("It took: " + (stopTime - startTime)+ " mS to load " + inac.getTotalEvents()+ " events.");
        System.out.println("");
        System.out.println("Printing a sampling of the events: ");
        System.out.println("First Event: " );
        inac.getFirst().displayEvent();
        System.out.println("");
        System.out.println("Last Event: " );
        inac.getLast().displayEvent();
        System.out.println("");
        
        // @Trevor Elwell removed these tests on 4/12.
        // Let's focus on doing these tests many more times
        // to get a better idea of which structure performs better.
        // 
        // System.out.println("Printing Range from: " + NUM_START + " to " + (NUM_START+RANGE-1) + ".");
        // inac.printRange(NUM_START, RANGE);
        // System.out.println("");
        
        System.out.println("****** Begining Improved Nested Array Calendar Timed Tests **********");
        System.out.println("");
        System.out.println("Insert Single Event Test:");
        System.out.println("Inserting Event Timed 1234567");
        startTime = System.nanoTime();
        inac.insertEvent(testEvent); 
        stopTime = System.nanoTime();
        System.out.println("There are now: " + inac.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to insert a single event");
        System.out.println("");
        System.out.println("Find Single Event Test:");
        System.out.println("Finding Event Timed 1234567");
        startTime = System.nanoTime();
        inac.findEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to find a single event");
        System.out.println("");
        System.out.println("Delete Single Event Test:");
        System.out.println("Deleting Event Timed 1234567");
        startTime = System.nanoTime();
        inac.deleteEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("There are now: " + inac.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to delete a single event");
        System.out.println("");
        System.out.println("Traverse and Generate Report of All Events Test:");
        startTime = System.nanoTime();
        inac.printReport();
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to traverse calendar and generate report");
        System.out.println("");
        System.out.println("****** Ending Improved Nested Array Calendar Loading Test **********");
        System.out.println("");
    }
    
    /*
     * Tests each function of the specific calendar type
     * by calling the randomizer to initially load the 
     * calendar with a set number of events.
     */
    public static void nacTest()
    {
        System.out.println("");
        System.out.println("****** Begining Nested Array Calendar Loading Test **********");
        System.out.println("");
        System.out.println("Running Initial Test on " + NUM_LINKS_TO_TEST + " events.");
        startTime = System.currentTimeMillis();
        nacRandomizer(NUM_LINKS_TO_TEST);
        stopTime = System.currentTimeMillis();
        System.out.println("It took: " + (stopTime - startTime)+ " mS to load " + nac.getTotalEvents()+ " events.");
        System.out.println("");
        System.out.println("Printing a sampling of the events: ");
        System.out.println("First Event: " );
        nac.getFirst().displayEvent();
        System.out.println("");
        System.out.println("Last Event: " );
        nac.getLast().displayEvent();
        System.out.println("");
        System.out.println("Printing Range from: " + NUM_START + " to " + (NUM_START+RANGE-1) + ".");
        nac.printRange(NUM_START, RANGE);
        System.out.println("");
        System.out.println("****** Begining Nested Array Calendar Timed Tests **********");
        System.out.println("");
        System.out.println("Insert Single Event Test:");
        System.out.println("Inserting Event Timed 1234567");
        startTime = System.nanoTime();
        nac.insertEvent(testEvent);
        stopTime = System.nanoTime();
        System.out.println("There are now: " + nac.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to insert a single event");
        System.out.println("");
        System.out.println("Find Single Event Test:");
        System.out.println("Finding Event Timed 1234567");
        startTime = System.nanoTime();
        nac.findEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to find a single event");
        System.out.println("");
        System.out.println("Delete Single Event Test:");
        System.out.println("Deleting Event Timed 1234567");
        startTime = System.nanoTime();
        nac.deleteEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("There are now: " + nac.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to delete a single event");
        System.out.println("");
        System.out.println("Traverse and Generate Report of All Events Test:");
        startTime = System.nanoTime();
        nac.printReport();
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to traverse calendar and generate report");
        System.out.println("");
        System.out.println("****** Ending Nested Array Calendar Loading Test **********");
        System.out.println("");
    }
    
    /*
     * Tests each function of the specific calendar type
     * by calling the randomizer to initially load the 
     * calendar with a set number of events.
     */
    public static void llcTest()
    {
        System.out.println("");
        System.out.println("****** Begining Linked List Calendar Loading Test **********");
        System.out.println("");
        System.out.println("Running Initial Test on " + NUM_LINKS_TO_TEST + " events.");
        startTime = System.currentTimeMillis();
        llcRandomizer(NUM_LINKS_TO_TEST);
        stopTime = System.currentTimeMillis();
        System.out.println("It took: " + (stopTime - startTime)+ " mS to load " + llc.getTotalEvents()+ " events.");
        System.out.println("");
        System.out.println("Printing a sampling of the events: ");
        System.out.println("First Event: " );
        llc.getFirst().displayEventLink();
        System.out.println("");
        System.out.println("Last Event: " );
        llc.getLast().displayEventLink();
        System.out.println("");
        System.out.println("Printing Range from: " + NUM_START + " to " + (NUM_START+RANGE-1) + ".");
        llc.printRange(NUM_START, RANGE);
        System.out.println("");
        System.out.println("****** Begining Linked List Calendar Timed Tests **********");
        System.out.println("");
        System.out.println("Insert Single Event Test:");
        System.out.println("Inserting Event Timed 1234567");
        startTime = System.nanoTime();
        llc.insertEvent(testEvent);
        stopTime = System.nanoTime();
        System.out.println("There are now: " + llc.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to insert a single event");
        System.out.println("");
        System.out.println("Find Single Event Test:");
        System.out.println("Finding Event Timed 1234567");
        startTime = System.nanoTime();
        llc.findEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to find a single event");
        System.out.println("");
        System.out.println("Delete Single Event Test:");
        System.out.println("Deleting Event Timed 1234567");
        startTime = System.nanoTime();
        llc.deleteEvent(1234567);
        stopTime = System.nanoTime();
        System.out.println("There are now: " + llc.getTotalEvents() + " events in the calendar.");
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to delete a single event");
        System.out.println("");
        System.out.println("Traverse and Generate Report of All Events Test:");
        startTime = System.nanoTime();
        llc.printReport();
        stopTime = System.nanoTime();
        System.out.println("It took: " + ((stopTime - startTime)/1000)+ " microS to traverse calendar and generate report");
        System.out.println("");
        System.out.println("****** Ending Linked List Calendar Loading Test **********");
        System.out.println("");
    }
    
    /*
     * The randomizer takes the total number of events to test
     * and creates that number of unique events to load into the
     * appropriate calendar structure for further testing.
     */
    public static void inacRandomizer(int numOfLinks)
    {
        int[] event = new int[6];
        int YEAR_SECONDS = 31540000;
        int MAX_ADV = (YEAR_SECONDS / numOfLinks); // limits advancement to under total Seconds in Year
        int clock = 0; // event clock time
        for (int i = 0; i < numOfLinks; i++)
        {
            int n = rnd.nextInt(MAX_ADV); // Clock incriment amount
            clock += n; // new event clock time.
            
            event[0] = 0; // Positional artifact from original system
            event[1] = clock; // Sets the seconds since 12am Jan 1 Year XX
            event[2] = (n%6); // Selects last event types
            event[3] = ((n%10)+1); // Selects unit #1 - #10
            event[4] = (event[2] != 5) ? 0 : 1; // Matches running conditional
            event[5] = 0; // Positional artifact from original system
            
            inac.loadEvent(event);
        }
    }
    
    /*
     * The randomizer takes the total number of events to test
     * and creates that number of unique events to load into the
     * appropriate calendar structure for further testing.
     */
    public static void nacRandomizer(int numOfLinks)
    {
        int[] event = new int[6];
        int YEAR_SECONDS = 31540000;
        int MAX_ADV = (YEAR_SECONDS / numOfLinks); // limits advancement to under total Seconds in Year
        int clock = 0; // event clock time
        for (int i = 0; i < numOfLinks; i++)
        {
            int n = rnd.nextInt(MAX_ADV); // Clock incriment amount
            clock += n; // new event clock time.
            
            event[0] = 0; // Positional artifact from original system
            event[1] = clock; // Sets the seconds since 12am Jan 1 Year XX
            event[2] = (n%6); // Selects last event types
            event[3] = ((n%10)+1); // Selects unit #1 - #10
            event[4] = (event[2] != 5) ? 0 : 1; // Matches running conditional
            event[5] = 0; // Positional artifact from original system
            
            nac.loadEvent(event);
        }
    }
    
    /*
     * The randomizer takes the total number of events to test
     * and creates that number of unique events to load into the
     * appropriate calendar structure for further testing.
     */
    public static void llcRandomizer(int numOfLinks)
    {
        int[] event = new int[6];
        int YEAR_SECONDS = 31540000;
        int MAX_ADV = (YEAR_SECONDS / numOfLinks); // limits advancement to under total Seconds in Year
        int clock = 0; // event clock time
        for (int i = 0; i < numOfLinks; i++)
        {
            int n = rnd.nextInt(MAX_ADV); // Clock incriment amount
            clock += n; // new event clock time.
            
            event[0] = 0; // Positional artifact from original system
            event[1] = clock; // Sets the seconds since 12am Jan 1 Year XX
            event[2] = (n%6); // Selects last event types
            event[3] = ((n%10)+1); // Selects unit #1 - #10
            event[4] = (event[2] != 5) ? 0 : 1; // Matches running conditional
            event[5] = 0; // Positional artifact from original system
            
            llc.loadEvent(event);
        }
    }
}

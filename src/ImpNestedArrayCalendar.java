/**
 * This class holds event data for use in the 
 * Improved Nested Array calendar.
 * 
 * Improved version uses binary search instead
 * of linear search.
 * 
 * @author David McLellan
 * @version 7 APRIL 2016
 */
public class ImpNestedArrayCalendar extends Object
{
    private int count;
    private EventArray[] calendar;
    private final int MAX_SIZE = 1000100;
    
    public ImpNestedArrayCalendar()
    {
        count = 0;
        calendar = new EventArray[MAX_SIZE];
    }
    
    public boolean isEmpty()
    {
        return(count == 0);
    }
    
    public int getTotalEvents()
    {
        return count;
    }
    
    /*
     * Loads events in sequential order from randomizer.
     * 
     * @param  event   Takes randomized data in array form
     */
    public void loadEvent(int[] event)
    {
        if (count < MAX_SIZE)
        {
            EventArray newEvent = new EventArray(event);
            calendar[count] = newEvent;
            count++;
        }
        else
        {
            System.out.println("Event Calendar is Full. Cannot add event.");
        }
    }
    
    /*
     * Loads single event into calendar and ensures it is
     * placed in the appropriate sorted calendar order.
     * 
     * @param  event   Takes single event data in array form
     */
    public void insertEvent(int[] event)
    {
        if (count < MAX_SIZE)
        {
            int clock = 1;
            int index = 0;
            EventArray newEvent = new EventArray(event);
            
            for ( ; index < count; index++)
            {
                if (calendar[index].getKey() > newEvent.getKey())
                {
                    break;
                }
            }
            
            for (int k = count; k > index; k--)
            {
                calendar[k] = calendar[k - 1];
            }
            
            calendar[index] = newEvent;
            count++;
        }
        else
        {
            System.out.println("Event Calendar is Full. Cannot add event.");
        }
    }
    
    /*
     * Delets specific event from calendar, given a
     * specific clock time of an event.
     * 
     * Improved version uses binary search instead
     * of linear search.
     * 
     * @param  key   Clock time of specific event.
     * @return     Reference to deleted event.
     */
    public boolean deleteEvent(int key)
    {
        int lower = 0;
        int upper = (count - 1);
        int current;
        
        while (true)
        {
            current = ((lower + upper) / 2);
            
            if (calendar[current].getKey() == key)
            {
                break;
            }
            else if (lower > upper)
            {
                System.out.println("Could not find event: " + key);
                return false;
            }
            else
            {
                if (calendar[current].getKey() < key)
                {
                    lower = (current + 1);
                }
                else
                {
                    upper = (current - 1);
                }
            }
        }

        for (int k = current; k < count; k++)
        {
            calendar[k] = calendar[k + 1];
        }
        count--;
        System.out.println("Deleted Event: " + key);
        return true;
    }
    
    /*
     * Finds specific event from calendar, given a
     * specific clock time of an event.
     * 
     * Improved version uses binary search instead
     * of linear search.
     * 
     * @param  key   Clock time of specific event.
     * @return     Reference to found event.
     */
    public EventArray findEvent(int key)
    {
        int lower = 0;
        int upper = (count - 1);
        int current;
        
        while (true)
        {
            current = ((lower + upper) / 2);
            
            if (calendar[current].getKey() == key)
            {
                return calendar[current];
            }
            else if (lower > upper)
            {
                System.out.println("Could not find event: " + key);
                return null;
            }
            else
            {
                if (calendar[current].getKey() < key)
                {
                    lower = (current + 1);
                }
                else
                {
                    upper = (current - 1);
                }
            }
        }
    }
    
    public EventArray getFirst()
    {
        return calendar[0];
    }
    
    public EventArray getLast()
    {
        return calendar[count - 1];
    }
    
    /*
     * Prints a listing of events between a given start point
     * and the number of events to print in the range.
     * 
     * @param  start   The sequential event number to start with.
     * @param  range   The number of event records to print.
     */
    public void printRange(int start, int range)
    {
        int counter = 0;
        
        if ((start + range) < count)
        {
            for (int i = 0; i < range; i++)
            {
                System.out.println("Displaying link " + (start + i) + ".");
                calendar[i + start].displayEvent();
            }
        }
        else
        {
            System.out.println("Your range is not contained in the calendar.");
        }
    }
    
    /*
     * Print Report traverses all the events held in the calendar
     * and talleys each type of the UNIT DOWN events and creates
     * and prints a report of the events by type.
     */
    public void printReport()
    {
        int forced = 0;
        int maintenance = 0;
        int installation = 0;
        int removed = 0;
        int random = 0;
        
        for (int i = 0; i < count; i++)
        {
            switch(calendar[i].getType())
            {
                case 1:
                    forced++;
                    break;
                case 2:
                    maintenance++;
                    break;
                case 3:
                    installation++;
                    break;
                case 4:
                    removed++;
                    break;
                case 5:
                    random++;
                    break;
            }
        }
        
        System.out.println("*******************************************");
        System.out.println("* Calendar System Report");
        System.out.println("*******************************************");
        System.out.println("* Total Calendar Events: " + count);
        System.out.println("* Forced Outages:        " + forced);
        System.out.println("* Maintenance Outages:   " + maintenance);
        System.out.println("* Unit Installations:    " + installation);
        System.out.println("* Unit Removals:         " + removed);
        System.out.println("* Random Outages:        " + random);
        System.out.println("*******************************************");
        System.out.println("");
    }
}
/**
 * This class holds event data for use in the 
 * linked list calendar.
 * 
 * @author David McLellan
 * @author Trevor Elwell
 * @version 7 APRIL 2016
 */
public class LinkedListCalendar 
{
    private EventLink first;
    private EventLink last;
    private int numberOfLinks;

    public LinkedListCalendar()
    {
        first = null;
        last = null;
        numberOfLinks = 0;
    }
    
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    public int getTotalEvents()
    {
        return numberOfLinks;
    }
    
    public EventLink getFirst()
    {
        return first;
    }
    
    public EventLink getLast()
    {
        return last;
    }
    
    /*
     * Loads events in sequential order from randomizer.
     * 
     * @param  event   Takes randomized data in array form
     */
    public void loadEvent(int[] event)
    {
        EventLink newLink = new EventLink(event);
        numberOfLinks++;
        
        if (isEmpty())
        {
            first = newLink;
        }
        else
        {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }
    
    /*
     * Loads single event into calendar and ensures it is
     * placed in the appropriate sorted calendar order.
     * 
     * @param  event   Takes single event data in array form
     */
    public void insertEvent(int[] event)
    {
        EventLink newLink = new EventLink(event);
        EventLink current = first;
        numberOfLinks++;
        
        while (current.getNext().getKey() <= newLink.getKey() && 
                current.getNext() != null)
        {
            current = current.getNext();
        }
        
        if (current == last)
        {
            newLink.setNext(null);
            last = newLink;
        }
        else
        {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
    }
    
    /*
     * Delets specific event from calendar, given a
     * specific clock time of an event.
     * 
     * @param  key   Clock time of specific event.
     * @return     Reference to deleted event.
     */
    public EventLink deleteEvent(int key)
    {
        EventLink current = first;
        
        while (current.getKey() != key)
        {
            current = current.getNext();
            if (current == null)
            {
                return null;
            }
        }
        if (current == first)
        {
            first = current.getNext();
        }
        else
        {
            current.getPrevious().setNext(current.getNext());
        }
        if (current == last)
        {
            last = current.getPrevious();
        }
        else
        {
            current.getNext().setPrevious(current.getPrevious());
        }
        numberOfLinks--;
        return current;
    }
    
    /*
     * Finds specific event from calendar, given a
     * specific clock time of an event.
     * 
     * @param  key   Clock time of specific event.
     * @return     Reference to found event.
     */
    public EventLink findEvent(int key)
    {
        if (isEmpty())
        {
            System.out.println("The current list is empty.");
            return null;
        }
        
        int counter = 0;
        EventLink current = first;
        
        while (current.getKey() != key)
        {
            counter++;
            current = current.getNext();
            if (current == null)
            {
                System.out.println("The Event " + key + " was not found.");
                return null;
            }
        }
        return current;
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
        
        if ((start + range) < numberOfLinks)
        {
            EventLink current = first;
            
            while (counter < start)
            {
                counter++;
                current = current.getNext();
                if (current == null)
                {
                    System.out.println("Out of Range Error");
                    return;
                }
            }
            for (int i = 0; i < range; i++)
            {
                System.out.println("Displaying link " + (start + i) + ".");
                current.displayEventLink();
                current = current.getNext();
            }
        }
        else
        {
            System.out.println("Your range is not contained in the calendar list.");
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
        EventLink current = first;
        
        while(current != null)
        {
            switch(current.getType())
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
            current = current.getNext();
        }
        
        System.out.println("*******************************************");
        System.out.println("* Calendar System Report");
        System.out.println("*******************************************");
        System.out.println("* Total Calendar Events: " + numberOfLinks);
        System.out.println("* Forced Outages:        " + forced);
        System.out.println("* Maintenance Outages:   " + maintenance);
        System.out.println("* Unit Installations:    " + installation);
        System.out.println("* Unit Removals:         " + removed);
        System.out.println("* Random Outages:        " + random);
        System.out.println("*******************************************");
        System.out.println("");
    }
}
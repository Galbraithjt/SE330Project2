import java.awt.event.WindowAdapter;

/*
 * Created by Joshua on 2/23/16.
 */
public class WaitList
{
    public Course firstWait;

    WaitList()
    {
        // Here to show the first Link always starts as null

        firstWait = null;
    }

    public void insertNewWait(String lName, String fName, String mI, String pNumber)
    {
        Course newLink = new Course(lName, fName, mI, pNumber);
        // Connects the firstLink field to the new Link

        newLink.next = firstWait;

        firstWait = newLink;
    }

    public void display()
    {
        Course theNode = firstWait;

        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null

        while (theNode != null)
        {
            theNode.display();

            theNode = theNode.next;

            System.out.println();

            System.out.println("That class is full so, You have been added to the waitList");
        }
    }
}

/*
 * Created by Joshua on 2/23/16.
 */
public class Course
{ // Start Class
    // Reference to first Link in list
    // The last Link added to the LinkList
    WaitList wList = new WaitList();
    public String lName;

   /* public String fName;
    public String mI;
    public String pNumber;*/

    public Course next;

    public Course(String lName)
    {
        this.lName = lName;
        /*this.fName = fName;
        this.mI = mI;
        this.pNumber = pNumber;*/
    }

    public Main firstLink;

    Course()
    {
        // Here to show the first Link always starts as null

        firstLink = null;
    }

    // Returns true if LinkList is empty

    public boolean isEmpty()
    {
        return (firstLink == null);
    }

    public void insertFirstLink(String className, int enrolledStudents)
    {
        Main newLink = new Main(className, enrolledStudents);
        // Connects the firstLink field to the new Link

        newLink.next = firstLink;

        firstLink = newLink;
    }

    public void display()
    {
        Main theLink = firstLink;

        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null

        while (theLink != null)
        {
            theLink.display();

            theLink = theLink.next;

            System.out.println();
        }
    }

    public Main find (String className, String lName, String fName, String mI, String pNumber)
    {
        Main theLink = firstLink;

        if (!isEmpty())
        {
            while (!theLink.className.equals(className))
            {
                // Checks if at the end of the LinkList

                if (theLink.next == null)
                {
                    // Got to the end of the Links in LinkList
                    // without finding a match

                    return null;
                }
                else
                {
                    // Found a matching Link in the LinkList
                    theLink = theLink.next;
                }
            }
        }
        else
        {
            System.out.println("Empty LinkList");
        }

        if (theLink.enrolledStudents < 30)
        {
            theLink.enrolledStudents++;
        }

        if (theLink.enrolledStudents >= 30)
        {
            theLink.enrolledStudents = 30;
            wList.sendLName(lName);
            wList.display();
        }

        return theLink;
    }


    public Main removeLink(String className)
    {

        Main currentLink = firstLink;
        Main previousLink = firstLink;

        // Keep searching as long as a match isn't made

        while (!currentLink.className.equals(className))
        {
            // Check if at the last Link in the LinkList

            if (currentLink.next == null)
            {
                // nodeNumber not found so leave the method

                return null;
            }

            else
            {
                // We checked here so let's look in the
                // next Link on the list

                previousLink = currentLink;

                currentLink = currentLink.next;
            }
        }

        if (currentLink == firstLink)
        {
            // If you are here that means there was a match
            // in the reference stored in firstLink in the
            // LinkList so just assign next to firstLink

            firstLink = firstLink.next;
        }

        else
        {
            // If you are here there was a match in a Link other
            // than the firstLink. Assign the value of next for
            // the Link you want to delete to the Link that's
            // next previously pointed to the reference to remove

            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstLink);

            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}//End Class

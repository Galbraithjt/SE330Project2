import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Created by Joshua on 2/23/16.
 */
public class WaitList
{
    public Course firstWait;
    private static ObjectOutputStream output;//outputs data to file

    WaitList()
    {
        // Here to show the first Link always starts as null

        firstWait = null;
    }

    public void sendLName (String lName)
    {
        openFile();
        addRecord(lName);
        closeFile();
    }

    public static void openFile()//open file Method
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("SLN.txt")));
        }
        catch (IOException ioe)
        {
            System.err.println("Error opening file. Terminating Program");
            System.exit(1);
        }
    }

    public static void addRecord(String lName)//add record
    {
        //declarations
        try
        {
            output.writeObject(lName);
        }

        catch (IOException ioe)
        {
            System.err.println("Error writing to file. Terminating.");
        }
    }

    public static void closeFile()//close file
    {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioe) {
            System.err.println("Error closing file. Terminating.");
        }
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


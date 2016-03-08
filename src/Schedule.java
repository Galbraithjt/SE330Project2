/*
 * Created by Vontre on 2/29/2016.
 */
public class Schedule {
    public Student stuClass;

    Schedule()
    {
        stuClass = null;
    }

    public boolean isEmpty()
    {
        return (stuClass == null);
    }

    public void insertFirstClass(String fName, String mInit, String lName, String pNumber, int choice)
    {
        Student newStu = new Student(fName, mInit, lName, pNumber, choice);
        // Connects the fistLink field to the new Link
        newStu.next = stuClass;

        stuClass = newStu;
    }

    public Student removeStudent()
    {
        Student stuReference = stuClass;
        if (!isEmpty())
        {
            stuClass = stuClass.next;
        }

        return stuReference;
    }

    public void scheduleInfo()
    {
        Student theStu = stuClass;

        while (theStu != null)
        {
            theStu.studentInfo();
            System.out.println("Class: " + theStu.next);
            theStu = theStu.next;
            System.out.println();
        }


    }

    public Student find(String fName, String lName)
    {
        Student theStu = stuClass;
        if(!isEmpty())
        {
            while(!theStu.fName.equals(fName) && !theStu.lName.equals(lName))
            {
                if(theStu.next == null)
                {
                    return null;
                }
                else
                {
                    theStu = theStu.next;
                }
            }
        }
        else
        {
            System.out.println("No Student Info Found");
        }
        return theStu;
    }

    public Student removeStu(String fName, String lName)
    {
        Student currentClass = stuClass;
        Student previousClass = stuClass;

        while(!currentClass.fName.equals(fName) && !currentClass.lName.equals(lName))
        {
            if(currentClass.next == null)
            {
                return null;
            }
            else
            {
                previousClass = currentClass;
                currentClass = currentClass.next;
            }
        }
        if(currentClass == stuClass)
        {
            stuClass = stuClass.next;
        }
        else
        {
            System.out.println("FOUND A MATCH!!");
            System.out.println("Current Class: " + currentClass);
            System.out.println("Last Class: " + stuClass);

            previousClass.next = currentClass.next;
        }

        return currentClass;
    }
}

/*
 * Created by Joshua on 2/23/16.
 */
import java.util.Scanner;

public class Main
{ //start Main Class
    // Set to public so getters & setters aren't needed
    public String className;
    public int enrolledStudents;

    // Reference to next link made in the SLList
    // Holds the reference to the Link that was created before it
    // Set to null until it is connected to other links

    public Main next;

    public Main (String className, int enrolledStudents)
    {
        this.className = className;
        this.enrolledStudents = enrolledStudents;
    }

    public void display()
    {
        System.out.println(className + "\nTotal Students Enrolled: " + enrolledStudents);
    }

    public static void main(String[] args)
    { //Start Main
        Scanner ui = new Scanner(System.in);
        Student stu = new Student();
        Schedule schedule = new Schedule();
        int classChoice;
        String classNameChoice;
        int enrolledStudents = 0;
        int choice = 0;

        System.out.println("Please Enter Your First Name.");
        stu.fName = ui.nextLine();

        System.out.println("\nNow Enter Your Middle Initial.");
        stu.mInit = ui.nextLine();

        System.out.println("\nNext Enter Your Last Name.");
        stu.lName = ui.nextLine();

        System.out.println("\nFinally, Enter Your Phone Number.");
        //in.nextLine();
        stu.pNumber = ui.nextLine();

        Course offeredCourse = new Course();

        // Insert Link and add a reference to the node Link added just prior
        // to the field next

        offeredCourse.insertFirstLink("ENG101", enrolledStudents);
        offeredCourse.insertFirstLink("ENG102", enrolledStudents);
        offeredCourse.insertFirstLink("SOC201", enrolledStudents);
        offeredCourse.insertFirstLink("SCE101", enrolledStudents);
        offeredCourse.insertFirstLink("PHY201", enrolledStudents);
        offeredCourse.insertFirstLink("SE330", enrolledStudents);
        offeredCourse.insertFirstLink("SE240", enrolledStudents);
        offeredCourse.insertFirstLink("SE410", enrolledStudents);
        offeredCourse.insertFirstLink("SE250", enrolledStudents);
        offeredCourse.insertFirstLink("HUM401", enrolledStudents);

        offeredCourse.display();
        System.out.println("Enter the number of classes you would like to register for'Must be less than 4 if" +
                "more then 4 is entered number will automatically be set to 4'");
        classChoice = ui.nextInt();

        if (classChoice > 4)
        {
            classChoice = 4;
        }

        ui.nextLine();

        for (int flc =0; classChoice > flc; flc++)
        {
            System.out.println("Enter the course name you would like to register for:");
            classNameChoice = ui.nextLine();
            offeredCourse.find(classNameChoice);
        }

        stu.confirmation ();
        if(choice == 1)
        {
            System.out.println("Sorry For The Inconvenience,\nWe Hope You Finish The Application Soon.");

            System.exit(0);
        }
        else if(choice == 0)
        {

            System.out.println("Great!");

            schedule.insertFirstClass(stu.getFName(), stu.getMInit(), stu.getLName(), stu.getNum(), stu.choice);
            stu.studentInfo();
            //waitL.setSchedule(stu.getFName(), stu.getMInit(), stu.getLName(), stu.getNum());
        }
        else
        {
            System.out.println("Seems There Was An Error In Your Process,\nPlease Press A Key To Close The Application And Restart.");

            System.exit(0);
        }

        System.out.println("Now That Your Are Set, We Look Forward To Furthering Your Career At Our Campus. See You Soon! :)");

        offeredCourse.display();
    }//end Main
}//End Class

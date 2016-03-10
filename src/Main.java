/*
 * Created by Joshua on 2/23/16.
 */

import java.io.*;
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
        int choice;

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

        offeredCourse.insertFirstLink("ENG101", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("ENG102", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SOC201", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SCE101", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("PHY201", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SE330", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SE240", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SE410", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("SE250", (int )(Math.random() * 30 + 1));
        offeredCourse.insertFirstLink("HUM401", (int )(Math.random() * 30 + 1));

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
            String lName = stu.getLName();
            String fName = stu.getFName();
            String mI = stu.getMInit();
            String pNumber = stu.getNum();
            offeredCourse.find(classNameChoice, lName, fName, mI, pNumber);
        }

        choice = stu.confirmation();
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

        }
        else
        {
            System.out.println("Seems There Was An Error In Your Process,\nPlease Press A Key To Close The Application And Restart.");

            System.exit(0);
        }

        String fileName = "SLN.txt";
        InputStream fIn;
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            if (args.length == 0) {
                //System.out.print("Enter a file name: ");  // get file to read from
                //fileName = buffer.readLine();
                fIn = new FileInputStream(fileName);
            }
            else {
                fIn = new FileInputStream(args[0]);
                fileName = args[0];
            }
            WordsBST wordTree = new WordsBST();    // create a new tree
            // Phase 1 - parse the file for all words and add the words to this tree
            wordTree.parse(fIn);
            // Phase 2 - display the built tree
            if (!wordTree.isEmpty()) {
                // System.out.print(wordTree);
                wordTree.displayTree(fileName);
            }

            fIn.close();
        } catch(IOException io) {
            System.err.println("Cannot open " + fileName);
        }

        System.out.println("Now That Your Are Set, We Look Forward To Furthering Your Career At Our Campus. See You Soon! :)");



        offeredCourse.display();
    }//end Main
}//End Class

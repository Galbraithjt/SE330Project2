import java.util.Scanner;

/*
 * Created by Vontre on 2/29/2016.
 */
public class Student {
    Scanner in = new Scanner(System.in);
    //WaitingList waitL;
    public String fName;
    public String mInit;
    public String lName;
    public String pNumber;
    public int choice;
    public Student next;

    public Student()
    {

    }
    public Student(String fN, String mI, String lN, String pNum, int sChoice)
    {
        this.fName = fN;
        this.mInit = mI;
        this.lName = lN;
        this.pNumber = pNum;
        this.choice = sChoice;
    }

    public void studentInfo()
    {
        setFName(fName);
        setMInit(mInit);
        setLName(lName);
        setNum(pNumber);

        System.out.println("Name: " + fName + " " + mInit + ". " + lName);
        System.out.println("Phone Number: " + pNumber);
    }

    public int confirmation()
    {

        System.out.println("\nIs this all Correct? 0 for yes, 1 for no");
        choice = in.nextInt();

        return choice;
    }

    public void setFName(String fName)
    {
       this.fName = fName;
    }

    public String getFName()
    {
        return this.fName;
    }

    public void setMInit(String mInit)
    {
        this.mInit = mInit;
    }

    public String getMInit()
    {
        return this.mInit;
    }

    public void setLName(String lName)
    {
        this.lName = lName;
    }

    public String getLName()
    {
        return this.lName;
    }

    public void setNum(String pNumber)
    {
        this.pNumber = pNumber;
    }

    public String getNum()
    {
        return this.pNumber;
    }

    public int getChoice()
    {
        return choice;
    }

    public void setChoice(int choice)
    {
        this.choice = choice;
    }
}

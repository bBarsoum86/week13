import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
    public static String findID(String studentName, Scanner infoScnr) throws Exception {
        String nextName;
        String nextID;

        while (infoScnr.hasNext()) {
            nextName = infoScnr.next();
            nextID = infoScnr.next();
            if (nextName.equals(studentName)) {
                return nextID;
            }
            infoScnr.nextLine();             // Consume newline
        }
        throw new Exception("Student ID not found for " + studentName);
    }

    public static String findName(String studentID, Scanner infoScnr) throws Exception {
        String nextName;
        String nextID;

        while (infoScnr.hasNext()) {
            nextName = infoScnr.next();
            nextID = infoScnr.next();
            if (nextID.equals(studentID)) {
                return nextName;
            }
            infoScnr.nextLine();             // Consume newline
        }
        throw new Exception("Student name not found for " + studentID);
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String studentName;
        String studentID;
        String studentInfoFileName;
        FileInputStream studentInfoStream = null;
        Scanner studentInfoScanner = null;

        // Read the text file name from user
        studentInfoFileName = scnr.next();

        // Open the text file
        studentInfoStream = new FileInputStream(studentInfoFileName);
        studentInfoScanner = new Scanner(studentInfoStream);

        // Read search option from user. 0: findID(), 1: findName()
        int userChoice = scnr.nextInt();

        try {
            if (userChoice == 0) {
                studentName = scnr.next();
                studentID = findID(studentName, studentInfoScanner);
                System.out.println(studentID);
            }
            else {
                studentID = scnr.next();
                studentName = findName(studentID, studentInfoScanner);
                System.out.println(studentName);
            }
        }
        catch (Exception excpt) {
            System.out.println(excpt.getMessage());
        }

        studentInfoStream.close();
    }
}
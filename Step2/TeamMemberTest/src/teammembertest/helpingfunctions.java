package teammembertest;

import java.util.Scanner;

public class helpingfunctions {

    Scanner scan = new Scanner(System.in);

    helpingfunctions() {
    }

    public void Pause() {
        System.out.println("\n***** Press any key to continue");
        scan.next();
    }

    public int getIntegerInput() {
        int x = -1;
        if (scan.hasNextInt()) {
            x = scan.nextInt();
        } else {
            System.out.print("Wrong Input...!Input again\n=> ");
            scan.nextLine();
            getIntegerInput();
        }
        return x;
    }

    public String getStringInput() {
        return scan.next();
    }
}

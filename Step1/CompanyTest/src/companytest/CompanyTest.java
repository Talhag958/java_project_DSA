package companytest;

public class CompanyTest {

    public static void main(String[] args) {
        // TODO code application logic here
        Company c = new Company();
        helpingfunctions hf = new helpingfunctions();
        int choice = 9999;
        System.out.println("******************************************************");
        System.out.println("  Welcome to Company project management app(module1)  ");
        System.out.println("***********^^^****************************************\n");
        try {
            while (choice != 5) {
                while (true) {
                    System.out.println("****************\\\\*******////********************");
                    System.out.println("******************** Menue **********************");
                    System.out.println("****************////*******\\\\********************\n");

                    System.out.println("***** Press 1 to add new project   **************");
                    System.out.println("***** Press 2 to find project  ******************");
                    System.out.println("***** Press 3 to remove project  ****************");
                    System.out.println("***** Press 4 to display all projects  **********");
                    System.out.println("***** Press 5 to exit  **************************\n");
                    System.out.print("***** Your choice :");

                    choice = hf.getIntegerInput();

                    switch (choice) {
                        case 1:
                            c.addProject();
                            break;
                        case 2:
                            c.findAndDisplay();
                            break;
                        case 3:
                            c.removeProject();
                            break;
                        case 4:
                            c.displayAll();
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Please  enter valid choice");
                            break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Exception occured" + e);
        } finally {
            System.out.println("Exiting the system");
        }
    }
}

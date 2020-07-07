
package teammembertest;


public class TeamMemberTest {

    public static void main(String[] args) {
        // TODO code application logic here
        TeamMember tm = new TeamMember();
        helpingfunctions hf = new helpingfunctions();
        int choice = 9999;
        System.out.println("******************************************************");
        System.out.println("  Welcome to Company project management app(module2)  ");
        System.out.println("***********^^^**************************************\n");
        try {
            while (choice != 5) {
                while (true) {
                    System.out.println("****************\\\\*******////********************");
                    System.out.println("******************** Menue **********************");
                    System.out.println("****************////*******\\\\********************\n");

                    System.out.println("***** Press 1 to add new Team Member  ***********");
                    System.out.println("***** Press 2 to find Team Member  **************");
                    System.out.println("***** Press 3 to remove Team Member  ************");
                    System.out.println("***** Press 4 to display all Team Members  ******");
                    System.out.println("***** Press 5 to exit  **************************\n");
                    System.out.print("***** Your choice :");

                    choice = hf.getIntegerInput();

                    switch (choice) {
                        case 1:
                            tm.addTeamMember();
                            break;
                        case 2:
                            tm.findAndDisplay();
                            break;
                        case 3:
                            tm.RemoveMember();
                            break;
                        case 4:
                            tm.displayAll();
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
            System.out.println("Exiting the program");
        }
    }
}

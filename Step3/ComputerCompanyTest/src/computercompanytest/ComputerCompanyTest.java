package computercompanytest;


public class ComputerCompanyTest {

    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree b = new BinarySearchTree();
        int choice = 9999;
        helpingfunctions hf = new helpingfunctions();
        //Menue
        System.out.println("**********************************************");
        System.out.println("  Welcome to Company project management app   ");
        System.out.println("***********^^^*******************************\n");
        try {
            while (choice != 8) {
                while (true) {
                    System.out.println("****************\\\\*******////********************");
                    System.out.println("******************** Menue **********************");
                    System.out.println("****************////*******\\\\********************\n");

                    System.out.println("***** Press 1 to add new project   ***************************");
                    System.out.println("***** Press 2 to add Team member  ****************************");
                    System.out.println("***** Press 3 to remove Team member  *************************");
                    System.out.println("***** Press 4 to remove Project  *****************************");
                    System.out.println("***** Press 5 to display team members for specific project  **");
                    System.out.println("***** Press 6 to display all projects with team members  *****");
                    System.out.println("***** Press 7 to display all projects team members count  ****");
                    System.out.println("***** Press 8 to exit  *************************************\n");
                    System.out.print("***** Your choice :");

                    choice = hf.getIntegerInput();
                    
                    //cases
                    switch (choice) {
                        case 1:
                            b.addProject();
                            break;
                        case 2:
                            b.addTeamMember();
                            break;
                        case 3:
                            b.removeTeamMember();
                            break;
                        case 4:
                            b.removeProject();
                            break;
                        case 5:
                            b.findAndDisplay();
                            break;
                        case 6:
                            b.displayAll();
                            break;
                        case 7:
                            b.displayNoOfMembers();
                            break;
                        case 8:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Please  enter valid choice");
                            break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Excepion occured" + e);
        }
        finally{
            System.out.println("Exiting the program");
        }

    }

}

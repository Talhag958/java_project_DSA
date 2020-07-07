package companytest;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class helpingfunctions {
   Scanner scan = new Scanner(System.in);
    helpingfunctions(){
    }
    public void Pause(){
        System.out.println("\n***** Press any key to continue");
        scan.next();
    }
   public  int getIntegerInput(){
        int x=-1;
        if(scan.hasNextInt()){
            x = scan.nextInt();
        }else{
            System.out.print("Wrong Input...!Input again\n=> ");
            scan.nextLine();
            getIntegerInput();
        }
        return x;
    }
   public String getStringInput(){
       return scan.next();
   }   
}

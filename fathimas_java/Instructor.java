import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Instructor {

        // Class Variables
        String instructorname;
        double avgfeedback;
        int experience;
        String [] skillset = new String[10];

        // constructor for initializing variables
        Instructor(String instructorname, double avgfeedback, int experience, String[] skillset ){
            this.instructorname = instructorname;
            this.avgfeedback = avgfeedback;
            this.experience = experience;
            this.skillset = skillset;
        }

        // Eligibility checking
        public boolean validatingEligibility(){
            
            if ((this.avgfeedback > 4.5 && this.experience > 3) | (this.avgfeedback > 4.0 && this.experience <= 3))
                return true;
            else
                return false;
        }

        // Checking Whether required skill does the eligible instructor having or not?
        public boolean checkingSkills(String technology){
            int i = 0;
            while(i < this.skillset.length){
                if (technology == this.skillset[i])
                    return true;
                else
                    i+=1;
            }
            return false;
        }
        
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String [] s = new String[10];
        s[0]="java"; // can insert many subject using for loop

        Instructor obj1 = new Instructor("hari",4.5,3, s); // -----Can Have many Objects for different users-----

        // checking eligibility
        if(obj1.validatingEligibility()){
            
            String technology = sc.next();
            
            // Checking skills
            if(obj1.checkingSkills(technology))
                System.out.println("Appointed");
            else
                System.out.println("Look for Others");
        }
        else{
            System.out.println("-----Not Eligible-----");
        }

    }
    
}

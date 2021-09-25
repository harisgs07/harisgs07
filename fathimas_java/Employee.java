import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.math.*;
import java.util.RandomAccess;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.Random;

public class Employee {
    String employeename;
    short numberofdependant;
    // ArrayList <Integer> checking = new ArrayList<Integer>() ;
    // Hashtable<String> dependant = new Hashtable<String>();
    String [] dependant = new String[3];
    String dateofjoin;
    int employeeid;
    boolean gender;
    int flag;
    static int nextemployeenumber;
    int nextemployeenumbernonstat;

    public static void staticEmployee(){
        // this is actually a normal constructor
        // but in qstn it asked for static constructor and static variable
        // in java no static constructor or variable.
        // static constructor or variable is that they cant be inherited by child class

        System.out.println("please enter the Employee id");
        Scanner sc  = new Scanner(System.in);
        nextemployeenumber = sc.nextInt() ;

        // String [] dependants = new String[10];
    }

    Employee(){

        this.employeeid = nextemployeenumber + 1;
        nextemployeenumber = this.employeeid;
        System.out.println(this.employeeid);
    }

    Employee(String employeename, String dateofjoin, boolean gender ){
        this();
        this.employeename = employeename;
        this.dateofjoin = dateofjoin;
        this.gender = gender;
    }

    Employee(String employeename, String dateofjoin, boolean gender, short numberofdependant ){

        this(employeename, dateofjoin, gender);
        if(numberofdependant > 3)
            this.numberofdependant = 3;
        else if(numberofdependant < 0)
            this.numberofdependant = 0;
        else
            this.numberofdependant = numberofdependant;
    }
    
    public int addDependants(String dependantname){
    
        for (int i = 0; i < this.dependant.length; i++){
            if(this.dependant[i] == dependantname)
                {this.flag += 1;}
        }

        if(flag == 0){
            for (int i = 0; i < this.dependant.length; i++){    
                if(this.dependant[i] == ""){
                    this.dependant[i] = dependantname;
                    return 1;
                }
            }
        }
        else
            return 0;
        return flag;        
    }

    public boolean updateDependants(String dependantname, int dependantid){

        if(dependantid > 0 && dependantid <= this.numberofdependant){
            if(this.dependant[0] == "" ){
            return false;
            }
            else if(this.dependant[1] == ""){
                if(dependantid <= 1 && dependantid > 0){
                    this.dependant[dependantid-1] = dependantname;
                    return true;
                }
                else
                    return false;
            }
            else if(this.dependant[2] == "" ){
                if(dependantid <= 2){
                    this.dependant[dependantid-1] = dependantname;
                    return true;
                }
                else
                    return false;
            }
            else{
                if(dependantid <= 3){
                    this.dependant[dependantid] = dependantname;
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    staticEmployee();
    Scanner sc = new Scanner(System.in);
    Employee obj = new Employee(sc.next(),sc.next(),sc.nextBoolean(),sc.nextShort());
    int check = 0;
    int returnvalue = 0;
    
    while(check < obj.numberofdependant){
        returnvalue += obj.addDependants(sc.next());
        check += 1;
    }
    System.out.println(obj.updateDependants(sc.next(), sc.nextInt()));
    Employee obj1 = new Employee(sc.next(),sc.next(),sc.nextBoolean(),sc.nextShort());
    }
}
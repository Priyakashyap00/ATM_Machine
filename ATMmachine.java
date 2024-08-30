package javaproject.atm;

import java.util.HashMap;
import java.util.Scanner;

public class ATMmachine {
    public static void main(String[] args) {
        
        ATMop obj = new ATMop();
        
    }
    


static class Data{
    float balance;
   
}
 static class ATMop{
    float balance;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer , Data> map = new HashMap<>();
    ATMop(){
        System.out.println("******************************");
        System.out.println("WELCOME TO OUR ATM");
        op();
    }

    public void op(){
        System.out.println("******************************");
        System.out.println("ENTER YOUR PIN CODE");
        int pincode = sc.nextInt();

        if (map.containsKey(pincode) == true) {
            Data obj = map.get(pincode);  
            menu(obj);  
        }

        else{
            System.out.println("******************************");
            System.out.println("PLEASE CREATE ACCOUNT FIRST");
            System.err.println("SET YOUR PIN CODE");
            int pin = sc.nextInt();

            Data obj = new Data();
            map.put(pin , obj);
            menu(obj);         
        }

    }

    public void menu(Data obj){
        
        System.out.println("******************************");
        System.out.println("PLEASE ENTER VALID NUMBER");
        System.out.println("1 . CHECK BALANCE");
        System.out.println("2 . DEPOSIT MONEY");
        System.out.println("3 . WITHDRAW MONEY");
        System.out.println("4 . CHECK ANOTHER ACCOUNT");
        System.out.println("5 . EXIT");

        int x = sc.nextInt();

        if (x == 1) {
            check_balance(obj);
            
        }
        else if(x == 2) {
            deposit(obj);
        }
        else if (x == 3) {
            withdraw(obj);
            
        }
        else if (x == 4) {
            op();
            
        }
        else if (x == 5) {
            System.out.println("THANK YOU !");
            
        }

        else{
            System.out.println("******************************");
            System.out.println("PLEASE ENTER VALID NUMBER");
            menu(obj);
        }
    }

    public void check_balance(Data obj){
        System.out.println("******************************");
        System.out.println("YOUR BALANCE"+obj.balance);
        System.out.println("******************************");
        menu(obj);
    }

    public void deposit(Data obj){
        System.out.println("******************************");
        System.out.println("ENTER YOUR AMOUNT");
        float a = sc.nextFloat();
        obj.balance = obj.balance + a;

        System.out.println("AMOUNT DEPOSIT SUCCESSFULLY");
        System.out.println("******************************");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("******************************");
        System.out.println("ENTER YOUR AMOUNT");
        float a = sc.nextFloat();
        if (obj.balance >= a) {
            obj.balance = obj.balance - a;  
            System.out.println("AMOUNT WITHDRAWAL SUCCESSFULLY");
            
        }
        else{
            System.out.println(" INSUFFICENT BALANCE");
        }

        System.out.println("******************************");
        menu(obj);
    }
}}
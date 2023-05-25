
package AQ;
import java.util.Random;
import java.util.Scanner;
public class Final_Proj {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Store store = new Store();
        Person a = new Person(0);
        Person b = new Person();
        Person c = new Person(0);
        Person d = new Person();
        store.enterStore(d);
        store.enterStore(c);
        store.enterStore(b);
        store.enterStore(a);
        store.checkOut(rand, scan);
        store.checkOut(rand, scan);
    }
}

class Store{
    private String name;
    private int maxOccupancy;
    private int cashiers;
    private ArrayQueue line;

    public Store(){
        name = "Joe Smith Store";
        maxOccupancy = 100;
        cashiers = 3;
        line = new ArrayQueue(maxOccupancy);
    }
    public Store(String name, int maxOccupancy, int cashiers){
        this.name = name;
        this.maxOccupancy = maxOccupancy;
        this.cashiers = cashiers;
        line = new ArrayQueue(maxOccupancy);
    }
    public void checkOut(Random rand, Scanner scan){
        boolean sanitationInput = true;
        int count = 0;
        for(int checkOut = 0; checkOut < cashiers; checkOut++){
            if(line.front() == null){
                return;
            }
            int cost = rand.nextInt(10)+ 1;
            if(line.front().getCash() > cost){
                System.out.println("Thank you " + line.front().getName() + ", for shopping at " + name + "! Have a great day!");
                line.pop();
            }else{
                count = 0;
                while(sanitationInput){
                    System.out.println("Do you have" + Color.ANSI_GREEN +" $" + (cost - line.front().getCash()) + Color.ANSI_RESET +" more?");
                    String userInput = scan.nextLine();
                    userInput.toLowerCase();
                    if(userInput.equals("yes") || userInput.equals("y")){
                        System.out.println("You're total was:" + Color.ANSI_GREEN +" $"+ cost + Color.ANSI_RESET +". Thank you " + line.front().getName() + ", for shopping at " + name + "! Have a great day!");
                        line.pop();
                        for(Person person : line.getQueue()){
                            if(person != null){
                                person.modifyPosInLine(1);
                            }  
                        }
                        sanitationInput = false;
                    }else if(userInput.equals("no") || userInput.equals("n")){
                        System.out.println("Please place your items down on the counter, and exit the store.");
                        line.pop();
                        for(Person person : line.getQueue()){
                            if(person != null){
                                person.modifyPosInLine(1);
                            }  
                        }
                        sanitationInput = false;
                    }else if(count == 5){
                        System.out.println("If you don't want to play with my rules" + '\n' + Color.ANSI_RED + "bye bye" + Color.ANSI_RESET);
                        System.exit(1);
                    }else{
                        count++;
                        System.out.print("Please enter \'" +Color.ANSI_GREEN + "yes" + Color.ANSI_RESET+"\', \'" + Color.ANSI_GREEN + "y" + Color.ANSI_RESET +"\', \'" + Color.ANSI_RED + "n"+ Color.ANSI_RESET + "\', or \'" + Color.ANSI_RED + "no"+ Color.ANSI_RESET + "\' (Input is not case sensitive) ");
                        for(int i = 0; i < count; i++){
                            System.out.print(5-i + "...");
                        }
                        System.out.println();
                    }
                }
               

            }
        }
    }
    public String enterStore(Person person){
        if(line.getCount() >= maxOccupancy){ 
            return "Please come back to " + name + " another time. So sorry for this inconvenience. Have a great day!";

        }else{
            person.setPosInLine(line.push(person));
            return "Welcome to " + name + "! Have a great day and wonderful shoping experiance!";
        }
    }
}

import java.util.Scanner;

public class MotorBoat {
    
    
    private double tankCapacity;
    private double fuelInTank;
    private double maxSpeed;
    private double currentSpeed;
    private double motorEfficiency;
    private double distanceTraveled;
    
    
    
    public void initialize(double capacityOfTank, double maximumSpeed, double efficiency) {
        tankCapacity = capacityOfTank;
        fuelInTank = 0.0;
        maxSpeed = maximumSpeed;
        currentSpeed = 0.0;
        motorEfficiency = efficiency;
        distanceTraveled = 0.0;
    }
    
    
    
    public void changeSpeed(double newSpeed){
        if(newSpeed < 0.0)
            currentSpeed = 0.0;
        else if (newSpeed > maxSpeed)
            currentSpeed = maxSpeed;
        else
            currentSpeed = newSpeed;
    }
    
    public void operateForTime(double time){
        
        if(time > 0.0 ){
            double fuelUsage = motorEfficiency * currentSpeed * currentSpeed * time;
            
            double realTime;
            
            // Determine if we run out of fuel
            if(fuelUsage > fuelInTank){
                realTime = time * (fuelInTank/fuelUsage);
                fuelInTank = 0.0;
            }else{
                fuelInTank -= fuelUsage;
                realTime = time;
            }
            distanceTraveled += currentSpeed * realTime;
        }
        
    }
    
    public void refuelBoat(double amount){
        if(amount > 0.0){
            if (amount + fuelInTank > tankCapacity)
                fuelInTank = tankCapacity;
            else
                fuelInTank += amount;
        }
    }
    
    public double fuelRemaining(){
        return fuelInTank;
    }
    
    public double distance(){
        return distanceTraveled;
    }
    
    

    public static void main(String[] args) {
        
        MotorBoat myBoat = new MotorBoat();
        myBoat.initialize(5.0, 55.0, 0.001);
        
        System.out.println("We are trying to travel for 1.0 hour with no fuel.");
        myBoat.operateForTime(1.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        System.out.println("trying to add 10 gallons of fuel.");
        System.out.println("But should only be able to hold 5.");
        myBoat.refuelBoat(10.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        
        System.out.println("We are traveling for 1.0 hour with a speed of 0.");
        myBoat.operateForTime(1.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        System.out.println("Trying to change the speed to 85.");
        System.out.println("Should only be able to go 55.");
        myBoat.changeSpeed(85.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        System.out.println("We are traveling for 1.0 hour with a speed of 55.");
        System.out.println("Should use 3.025 gallons of fuel and travel 55 miles.");
        myBoat.operateForTime(1.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        System.out.println("We are traveling for 2.0 hours with a speed of 45.");
        System.out.println("Should use all 1.975 remaining gallons.  " +
                "The travel time will be 0.9753 and the distance is approximately 43.888 miles");
        myBoat.changeSpeed(45.0);
        myBoat.operateForTime(2.0);
        System.out.println("Fuel left is " + myBoat.fuelRemaining()
        + " and we have gone " + myBoat.distance());
        System.out.println();
        
        
        
    }
    
}



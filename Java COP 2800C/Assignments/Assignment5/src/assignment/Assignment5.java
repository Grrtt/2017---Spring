/*
Design a class named Fan to represent a fan. The class contains:

Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to denote the fan speed
A private int data field named speed that specifies the speed of the fan (the default is SLOW)
A private Boolean data field named powerStatus that specifies whether the fan is powerStatus (the default is false)
A private double data field named radius that specifies the radius of the fan (the default is 5)
A string data field named color that specifies the color of the fan (the defaults is blue)
The accessor and mutator methods for all four data fields
A no-arg constructor that creates a default fan
A method named toString() that returns a string description for the fan. If the fan is powerStatus, the method returns the fan speed, color, and radius in one combined string. If the fan is not powerStatus, the method returns the fan color and radius along with the string “fan is off” in one combined string.
Write a test program that creates two Fan objects. Assign maximum speed, radius 10, color yellow, and turn it powerStatus to the first object. Assign medium speed, radius 5, color blue, and turn it off to the second objects. Display the objects by invoking their toString method.
Here is a sample run:

speed 3
color yellow
radius 10.0
fan is powerStatus
speed 2
color blue
radius 5.0
 fan is off
 */
package assignment;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment5 {

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setFanSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.togglePowerStatus();
        System.out.println(fan1.toString());
        
        Fan fan2 = new Fan();
        fan2.setFanSpeed(fan2.MEDIUM);
        System.out.println(fan2.toString());
        
    }
}

class Fan{
    
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    
    // Default Status
    private int fanSpeed = SLOW;
    // Default state is OFF.
    private boolean poweredStatus = false;
    private double radius = 5;
    private String color = "Blue";
    
    public Fan(){}
    
    public int getFanSpeed(){
        return fanSpeed;
    }
    
    // Set Fan. Accepts values: 1, 2, or 3; 
    // defaults to Medium if outside of this range.
    public void setFanSpeed(int speed){
        switch(speed){
            case 1:
                fanSpeed = speed;
                break;
            case 2:
                fanSpeed = speed;
                break;
            case 3:
                fanSpeed = speed;
                break;
            default:
                System.out.println("!Unrecognized speed! DEFAULT to MEDIUM.");
                fanSpeed = MEDIUM;
                break;
        }
    }
    
    // Returns whether power to the fan is "ON" or "OFF."
    public String getPowerStatus(){
        if(poweredStatus == true){
            return "ON";
        }else{
            return "OFF";
        }
    }
    
    // Switches power status to opposite current status.
    public void togglePowerStatus(){
        poweredStatus = !poweredStatus;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(int newRadius){
        radius = newRadius;
    }
    
    public String getColor(){
        return color;
    }
    
    // Set Color. Accepts any String.
    public void setColor(String newColor){
        color = newColor;
    }
    
    // Gets Fan status.
    @Override
    public String toString(){
        int currentSpeed = this.getFanSpeed();
        String currentColor = this.getColor();
        double currentRadius = this.getRadius();
        String currentPowerStatus = this.getPowerStatus();
        
		// Append fan details to single String.
        String details = "";
        details += "Speed: " + currentSpeed + "\n";
        details += "Color: " + currentColor + "\n";
        details += "Radius: " + currentRadius + "\n";
        details += "Power Status: Fan is " + currentPowerStatus + "\n";
        
        return details;
    }
}

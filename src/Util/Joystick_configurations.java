package Util;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.Robot;



/*This file holds different joystick configurations to determine what type of
 controller is used to control the robot.

DO NOT USE THIS FOR COMPETITION! THIS CLASS IS INTENDED FOR RECRIATIONAL BOT USE

In a competition setting, changing joystick types automatically in software like
this is asking for trouble. Just use one type and don't change it.

Call the selectJoystickType() method and provide the CORRECT string that reffers 
to the controller desired, this MUST happen BEFORE the joysticks are initialized
or else they'll grab null pointers

//@author Cglane


*/

    public class Joystick_configurations{
        
   public static IllegalArgumentException illegalJoystickException;
        
  //All ID objects are created->
    
   public static String finalJoystickType;
   
    // Joystick->
    public static  int A_ID ;
    public static  int B_ID;
    public static  int Y_ID;
    public static  int X_ID; 
    public static  int RMB_ID;
    public static  int LMB_ID;
    public static  int RSB_ID;
    public static  int LSB_ID;  
    public static  int R_ID;
    public static  int L_ID;

    public static  int ZR_ID;
    public static  int ZL_ID;

    public static  int BumperAxis_ID;
    public static  int LeftXAxis_ID;
    public static  int LeftYAxis_ID;
    public static  int RightXAxis_ID;
    public static  int RightYAxis_ID;

    public static  int DpadYaxis_ID;
    public static  int DpadXaxis_ID;

 //<- 

     
   //This function will swap the ID numbers to accomidate different joysticks
   //Choose from; Xbox/PlayStation,NintendoSwitchFPP,NintendoSwitchPro,GenericHID,LogitechWingman
   // anything else throws an exception
   
    public static final void selectJoystickType(String type){
    
      //ALL CONSTANTS HERE ARE SPESIFIC TO THEIR ASSOCIATED CONTROLLERS DO NOT CHANGE THEM
      //if any button or axis ID is set to 255 or 0 it does not exist on that particular controller do not try to use it
    if("Xbox/PlayStation".equals(type)){
        
           finalJoystickType = "Xbox/PlayStation";   
        
           A_ID=1;
           B_ID=2;
           Y_ID=3;
           X_ID=4;
           RMB_ID=8;
           LMB_ID=7;
           RSB_ID=10;
           LSB_ID=9;
           R_ID=6;
           L_ID=5;

           ZR_ID=255;
           ZL_ID=255;

           BumperAxis_ID=3;
           LeftXAxis_ID=1;
           LeftYAxis_ID=4;
           RightXAxis_ID=5;
           RightYAxis_ID=6;

           DpadYaxis_ID=255;
           DpadXaxis_ID=255;
    } 
    else if("NintendoSwitchFPP".equals(type)){
        
           finalJoystickType = "NintendoSwitchFPP";  
    
           A_ID=3;
           B_ID=2;
           Y_ID=1;
           X_ID=4;
           RMB_ID=10;
           LMB_ID=9;
           RSB_ID=12;
           LSB_ID=11;
           R_ID=6;
           L_ID=5;

           ZR_ID=8;
           ZL_ID=7;

           BumperAxis_ID=255;
           LeftXAxis_ID=1;
           LeftYAxis_ID=2;
           RightXAxis_ID=3;
           RightYAxis_ID=4;

           DpadYaxis_ID=6;
           DpadXaxis_ID=5;
    
    
    }
    else if ("NintendoSwitchPro".equals(type)){
        
           finalJoystickType = "NintendoSwitchPro";  
    
           A_ID=3;
           B_ID=2;
           Y_ID=1;
           X_ID=4;
           RMB_ID=10;
           LMB_ID=9;
           RSB_ID=12;
           LSB_ID=11;
           R_ID=6;
           L_ID=5;

           ZR_ID=8;
           ZL_ID=7;

           BumperAxis_ID=255;
           LeftXAxis_ID=1;
           LeftYAxis_ID=2;
           RightXAxis_ID=3;
           RightYAxis_ID=4;

           DpadYaxis_ID=0;
           DpadXaxis_ID=0;
    
    
    }
    
    else if ("GenericHID".equals(type)){
           finalJoystickType = "GenericHID";   
        
           A_ID=1;
           B_ID=2;
           Y_ID=3;
           X_ID=4;
           RMB_ID=8;
           LMB_ID=7;
           RSB_ID=10;
           LSB_ID=9;
           R_ID=6;
           L_ID=5;

           ZR_ID=11;
           ZL_ID=12;

           BumperAxis_ID=3;
           LeftXAxis_ID=1;
           LeftYAxis_ID=4;
           RightXAxis_ID=5;
           RightYAxis_ID=6;

           DpadYaxis_ID=8;
           DpadXaxis_ID=9;    
    }
     else if ("LogitechWingman".equals(type)){
           finalJoystickType = "LogitechWingman";   
        
           A_ID=6;
           B_ID=7;
           Y_ID=2;
           X_ID=3;
           RMB_ID=255;
           LMB_ID=255;
           RSB_ID=255;
           LSB_ID=255;
           R_ID=1;
           L_ID=255;

           ZR_ID=255;
           ZL_ID=255;

           BumperAxis_ID=255;
           LeftXAxis_ID=255;
           LeftYAxis_ID=255;
           RightXAxis_ID=1;
           RightYAxis_ID=2;

           DpadYaxis_ID=255;
           DpadXaxis_ID=255;    
    }
    else{
       System.err.println("Joystick not selected properly");
       Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser1, 1, "Joystick not selected properly");
       throw illegalJoystickException;
    
    }//end of if statements
    
    

    }//void selectjoysticktype
    
    }//end of file
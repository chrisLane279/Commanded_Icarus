
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import Util.DriverStopException;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {//operator interface class
    
    public DriverStopException driverStopException = new DriverStopException("The robot driver has demanded the robot to stop");
    
    public static final Joystick Driverstick = new Joystick(1);//driver joystick
    public static double DriveMagnitude;
    public static double DriveTurn;
    public static boolean isCreeping;
    
    //Instantiate all joystick attributes
  //This is a Nintendo Switch fight pad pro controller--
  static String JoystickType = "NintendoSwitchFightPadPro";
  public static JoystickButton driverA = new JoystickButton(Driverstick,3);
  public static JoystickButton driverB= new JoystickButton(Driverstick,2);
  public static JoystickButton driverY= new JoystickButton(Driverstick,1);
  public static JoystickButton driverX= new JoystickButton(Driverstick,4);  
  public static JoystickButton driverRMB= new JoystickButton(Driverstick,10);
  public static JoystickButton driverLMB= new JoystickButton(Driverstick,9);
  public static JoystickButton driverRSB= new JoystickButton(Driverstick,12);
  public static JoystickButton driverLSB= new JoystickButton(Driverstick,11);   
  public static JoystickButton driverR= new JoystickButton(Driverstick,6);
  public static JoystickButton driverL= new JoystickButton(Driverstick,5);
  public static JoystickButton driverZR= new JoystickButton(Driverstick,8);
  public static JoystickButton driverZL= new JoystickButton(Driverstick,7);
  
  public static int LeftXAxis = 1;
  public static int LeftYAxis = 2;
  public static int RightXAxis = 3;
  public static int RightYAxis = 4;
  public static int DpadYaxis = 6;
  public static int DpadXaxis = 5;

 public static int BumperAxis;//this axis doesn't exist,keep to prevent null pointers

//--
  

    public void OIinit(){//initialize OI
        System.out.println("OI initialized");
        System.out.println("System controller set to:");
        System.out.println( JoystickType);
        Robot.driverstationLCD.println(DriverStationLCD.Line.kUser3,1,"System controller set to:");
        Robot.driverstationLCD.println(DriverStationLCD.Line.kUser4,1,JoystickType);
        Robot.driverstationLCD.println(DriverStationLCD.Line.kUser6,1,"Operator Interface ready");
    }
    

    public void OIrun(){//runs continuously in teleoperated
      
       DriveMagnitude = -Driverstick.getRawAxis(OI.LeftYAxis);//gets the drive magnitude from joystick
       DriveTurn = -Driverstick.getRawAxis(LeftXAxis);//gets the drive turn value from joystick
       isCreeping = (OI.driverL.get() || OI.driverR.get() || OI.driverZL.get() || OI.driverZR.get() );//isCreeping is true if any creep buttons are

       Robot.drivewithsticks.drive();//drives the bot
  
       if(OI.driverRMB.get() == true){
           CommandBase.m_drivetrainSubsystem.stop();//This MUST be here! Else the robot could drive withought control.
           Robot.driverstationLCD.println(DriverStationLCD.Line.kUser1,1,"Driver exception");
           Robot.driverstationLCD.updateLCD();
           throw driverStopException;//This is basically an emergency stop for the driver
       }
  
      //debug--
     SmartDashboard.putBoolean("isCreeping",OI.isCreeping);
     SmartDashboard.putDouble("Drive turn", DriveTurn);
     SmartDashboard.putDouble("Drive magnitude", DriveMagnitude);
     SmartDashboard.putString("JoystickType", JoystickType);
      //--
    }
    
 }
 





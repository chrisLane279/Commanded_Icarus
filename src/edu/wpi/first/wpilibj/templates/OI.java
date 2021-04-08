package edu.wpi.first.wpilibj.templates;

import Util.Joystick_configurations;
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
public class OI{//operator interface class
    
    public Joystick_configurations joystickconfig;

    public DriverStopException driverStopException = new DriverStopException("The robot driver has demanded the robot to stop,reboot the robot controller");
    
    public static final Joystick Driverstick = new Joystick(1);//driver joystick
    public static final Joystick Operatorstick = new Joystick(2);//operator joystick
    
    public static double driveMagnitude;//should be set to the robots drive magnitude for the speed controllers
    public static  double driveTurn;//should be set to the robots turn magnitude for the speed controlers
    public static boolean isCreepingF;//should be true when robot is to creep forward
    public static boolean isCreepingB;//should be true when robot is to creep backward


    //Instantiate all joystick attributes
    public static String JoystickType;
    
    //Driver Joystick->
    public static JoystickButton driverA ;
    public static JoystickButton driverB;
    public static JoystickButton driverY;
    public static JoystickButton driverX;
    public static JoystickButton driverRMB;
    public static JoystickButton driverLMB;
    public static JoystickButton driverRSB;
    public static JoystickButton driverLSB;
    public static JoystickButton driverR;
    public static JoystickButton driverL;
    public static JoystickButton driverZR;
    public static JoystickButton driverZL;

    public static int driverBumperAxis;
    public static int driverLeftXAxis ;
    public static int driverLeftYAxis ;
    public static int driverRightXAxis;
    public static int driverRightYAxis;

    public static int driverDpadYaxis;
    public static int driverDpadXaxis;
    

 //-- 
 
   
    public void OIinit() {//initialize OI 
        
        
        Joystick_configurations.selectJoystickType("LogitechWingman");
        
     JoystickType = Joystick_configurations.finalJoystickType;//the selected joystick for driving the bot
     
     //initialize all joystick buttons
     driverA = new JoystickButton(Driverstick,Joystick_configurations.A_ID);
     driverB= new JoystickButton(Driverstick,Joystick_configurations.B_ID);
     driverY= new JoystickButton(Driverstick,Joystick_configurations.Y_ID);
     driverX= new JoystickButton(Driverstick,Joystick_configurations.X_ID);  
     driverRMB= new JoystickButton(Driverstick,Joystick_configurations.RMB_ID);
     driverLMB= new JoystickButton(Driverstick,Joystick_configurations.LMB_ID);
     driverRSB= new JoystickButton(Driverstick,Joystick_configurations.RSB_ID);
     driverLSB= new JoystickButton(Driverstick,Joystick_configurations.LSB_ID);   
     driverR= new JoystickButton(Driverstick,Joystick_configurations.R_ID);
     driverL= new JoystickButton(Driverstick,Joystick_configurations.L_ID);
     driverZR= new JoystickButton(Driverstick,Joystick_configurations.ZR_ID);
     driverZL= new JoystickButton(Driverstick,Joystick_configurations.ZL_ID);

     //initialize all joystick axis
      driverBumperAxis = Joystick_configurations.BumperAxis_ID;
      driverLeftXAxis = Joystick_configurations.LeftXAxis_ID;
      driverLeftYAxis = Joystick_configurations.LeftYAxis_ID;
      driverRightXAxis= Joystick_configurations.RightXAxis_ID;
      driverRightYAxis= Joystick_configurations.RightYAxis_ID;

      driverDpadYaxis=Joystick_configurations.DpadYaxis_ID;
      driverDpadXaxis=Joystick_configurations.DpadXaxis_ID;
        
        
  
        System.out.println("OI initialized");
        System.out.println("System controller set to:");
        System.out.println(JoystickType);
        
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser3, 1, "System controller:");
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser4, 1, JoystickType);
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser6, 1, "Op interface ready!");
    }

    public void OIrun() {//runs continuously in teleoperated
        
 
        if (driverRMB.get() == true) {
            Robot.drivewithsticks.cancel();//This MUST be here! Else the robot could drive without control.
            CommandBase.m_drivetrainSubsystem.stop();//This MUST be here! Else the robot could drive without control.

            Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser1, 1, "Driver stop exception");
            throw driverStopException;//This is basically an emergency stop for the driver
        }

        //debug--
        SmartDashboard.putString("JoystickType", JoystickType);
        //--
    }

}

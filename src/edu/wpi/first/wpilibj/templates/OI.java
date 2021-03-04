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

    public DriverStopException driverStopException = new DriverStopException("The robot driver has demanded the robot to stop,reboot the robot controller");

    public static final Joystick Driverstick = new Joystick(1);//driver joystick
    public static final Joystick Operatorstick = new Joystick(2);//operator joystick
    
    public static double driveMagnitude;//should be set to the robots drive magnitude for the speed controllers
    public static  double driveTurn;//should be set to the robots turn magnitude for the speed controlers
    public static boolean isCreepingF;//should be true when robot is to creep forward
    public static boolean isCreepingB;//should be true when robot is to creep backward


    //Instantiate all joystick attributes
    //This is an xbox or playStation controller--
    String JoystickType = "Xbox/PlayStation";
    
    //Driver Joystick->
    public static JoystickButton driverA = new JoystickButton(Driverstick,1);
    public static JoystickButton driverB= new JoystickButton(Driverstick,2);
    public static JoystickButton driverY= new JoystickButton(Driverstick,3);
    public static JoystickButton driverX= new JoystickButton(Driverstick,4);  
    public static JoystickButton driverRMB= new JoystickButton(Driverstick,8);
    public static JoystickButton driverLMB= new JoystickButton(Driverstick,7);
    public static JoystickButton driverRSB= new JoystickButton(Driverstick,10);
    public static JoystickButton driverLSB= new JoystickButton(Driverstick,9);   
    public static JoystickButton driverR= new JoystickButton(Driverstick,6);
    public static JoystickButton driverL= new JoystickButton(Driverstick,5);

    public static JoystickButton driverZR= new JoystickButton(Driverstick,255);//this button doesn't exist,keep to prevent null pointers
    public static JoystickButton driverZL= new JoystickButton(Driverstick,255);//this button doesn't exist,keep to prevent null pointers

    public static int driverBumperAxis = 3;
    public static int driverLeftXAxis = 1;
    public static int driverLeftYAxis = 2;
    public static int driverRightXAxis= 4;
    public static int driverRightYAxis= 5;

    public static int driverDpadYaxis=255;//this axis doesn't exist,keep to prevent null pointers
    public static int driverDpadXaxis=254;//this axis doesn't exist,keep to prevent null pointers
    
    //Operator joystick->
    
    public static JoystickButton operatorA = new JoystickButton(Operatorstick,1);
    public static JoystickButton operator= new JoystickButton(Operatorstick,2);
    public static JoystickButton operatorY= new JoystickButton(Operatorstick,3);
    public static JoystickButton operatorX= new JoystickButton(Operatorstick,4);  
    public static JoystickButton operatorRMB= new JoystickButton(Operatorstick,8);
    public static JoystickButton operatorLMB= new JoystickButton(Operatorstick,7);
    public static JoystickButton operatorRSB= new JoystickButton(Operatorstick,10);
    public static JoystickButton operatorLSB= new JoystickButton(Operatorstick,9);   
    public static JoystickButton operatorR= new JoystickButton(Operatorstick,6);
    public static JoystickButton operatorL= new JoystickButton(Operatorstick,5);

    public static JoystickButton operatorZR= new JoystickButton(Operatorstick,255);//this button doesn't exist,keep to prevent null pointers
    public static JoystickButton operatorZL= new JoystickButton(Operatorstick,255);//this button doesn't exist,keep to prevent null pointers

    public static int operatorBumperAxis = 3;
    public static int operatorrLeftXAxis = 1;
    public static int operatorLeftYAxis = 2;
    public static int operatorRightXAxis= 4;
    public static int operatorRightYAxis= 5;

    public static int operatorDpadYaxis=255;//this axis doesn't exist,keep to prevent null pointers
    public static int operatorDpadXaxis=254;//this axis doesn't exist,keep to prevent null pointers

 //-- 
 
 
    public void OIinit() {//initialize OI
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

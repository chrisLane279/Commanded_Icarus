
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.Robot;
import edu.wpi.first.wpilibj.templates.OI;


/**
 *
 * @author cglan
 */
public class DriveWithXbox_Ps extends CommandBase {
    


    public DriveWithXbox_Ps() {//Command that runs the drivetrain with an xbox or playstation controller

   requires (CommandBase.m_drivetrainSubsystem);//requires the drivetrain
   
    }


    protected void initialize() { // Called just before this Command runs the first time
        System.out.println("Drive command init w/xbox");
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser6, 1, "Drivecommand init.");      
        
        CommandBase.m_drivetrainSubsystem.setFans(true);
        
    }

   
    protected void execute() { // Called repeatedly when this Command is scheduled to run
     
        if(OI.driverR.get()==true){
        OI.driveMagnitude = -Constants.slowCreepSpeed;
        }//if R is pressed, the robot creeps forward
        else if(OI.driverL.get()==true){
        OI.driveMagnitude = Constants.slowCreepSpeed;
        }//if L is pressed, the bot creeps backward
        else if(OI.driverR.get() == false || OI.driverL.get() == false){
        OI.driveMagnitude = OI.Driverstick.getRawAxis(OI.driverBumperAxis);
        }//if neither creep buttons pressed, magnitude set by stick
        
        OI.driveTurn = OI.Driverstick.getRawAxis(OI.driverLeftXAxis);//turn is set by stick
        
        CommandBase.m_drivetrainSubsystem.arcadeDrive(-OI.driveMagnitude,-OI.driveTurn);//Arcade drive the bot
        
        
        
      
    }


    protected boolean isFinished() {// Make this return true when this Command no longer needs to run execute()
        return false;
    }


    protected void end() {// Called once after isFinished returns true
        
       System.out.println("Drive command ended");
       Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser6, 1, "Drivecommand ended");
       
               CommandBase.m_drivetrainSubsystem.setFans(false);
    }

 
    protected void interrupted() {// Called when another command which requires one or more of the same subsystems is scheduled to run
        
        System.out.println("Drive command interrupted");
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser6, 1, "Drivecommand interrupt");
    }
}

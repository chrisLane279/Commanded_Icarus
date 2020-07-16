
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;


/**
 *
 * @author bradmiller
 */
public class DriveCommand extends CommandBase {

    public DriveCommand() {//Command that runs the drivetrain with joysticks
  
   requires (CommandBase.m_drivetrainSubsystem);//requires the drivetrain
   
    }


    protected void initialize() { // Called just before this Command runs the first time
     //   System.out.println("Drive command init");
        
    }

   
    protected void execute() { // Called repeatedly when this Command is scheduled to run
        
     
    }


    protected boolean isFinished() {// Make this return true when this Command no longer needs to run execute()
        return false;
    }


    protected void end() {// Called once after isFinished returns true
        
       CommandBase.m_drivetrainSubsystem.stop();
       System.out.println("Drive command ended");
 
    }

 
    protected void interrupted() {// Called when another command which requires one or more of the same subsystems is scheduled to run
        
        CommandBase.m_drivetrainSubsystem.stop();
        System.out.println("Drive command interrupted");
    }
}

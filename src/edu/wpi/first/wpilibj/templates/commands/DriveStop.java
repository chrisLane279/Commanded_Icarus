/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author cglan
 */
public class DriveStop extends CommandBase {

    public DriveStop() {//Command that stops the drivetrain and rests it during execution
  
   requires (CommandBase.m_drivetrainSubsystem);//requires the drivetrain
   
    }


    protected void initialize() { // Called just before this Command runs the first time
        
        CommandBase.m_drivetrainSubsystem.stop();//stop the drivetrain in init
        System.out.println("Drive command stopped");
        
    }

   
    protected void execute() { // Called repeatedly when this Command is scheduled to run
        
     CommandBase.m_drivetrainSubsystem.stop();//stop the drivetrain every loop
     
    }


    protected boolean isFinished() {// Make this return true when this Command no longer needs to run execute()
        return false;
    }


    protected void end() {// Called once after isFinished returns true
     
     //do nothing
    }

 
    protected void interrupted() {// Called when another command which requires one or more of the same subsystems is scheduled to run
        //do nothing
    }
}

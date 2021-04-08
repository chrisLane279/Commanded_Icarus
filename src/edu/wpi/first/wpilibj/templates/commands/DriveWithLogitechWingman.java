/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.Robot;

/**
 *
 * @author cglan
 */
public class DriveWithLogitechWingman extends CommandBase {
    


    public DriveWithLogitechWingman() {//Command that runs the drivetrain with a Logitech Wingman controller

   requires (CommandBase.m_drivetrainSubsystem);//requires the drivetrain
   
    }


    protected void initialize() { // Called just before this Command runs the first time
        System.out.println("Drive command init w/Logi flight stick");
        Robot.instantDriverstationLCD(DriverStationLCD.Line.kUser6, 1, "Drivecommand init.");      
        
        CommandBase.m_drivetrainSubsystem.setFans(true);
        
    }

   
    protected void execute() { // Called repeatedly when this Command is scheduled to run
     
        OI.driveMagnitude = OI.Driverstick.getY();
        OI.driveTurn = OI.Driverstick.getTwist();
        
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


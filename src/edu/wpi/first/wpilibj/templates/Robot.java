/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.            
/*
/*@Editor Cglan
/*
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;



import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveCommand;
import edu.wpi.first.wpilibj.DriverStationLCD;


public class Robot extends IterativeRobot {

   public static Command drivecommand;//the drive command
   public static RobotMap robotmap = new RobotMap();//robot map
   public static DriveWithSticks drivewithsticks = new DriveWithSticks();
   public static DriverStationLCD driverstationLCD = DriverStationLCD.getInstance();
  // public static DriverStation driverstation = DriverStation.getInstance(); 
 
    
    public void robotInit() {//initialize at start, runs once
        System.out.println("Robot code exists");
        System.out.println("robotInit");        
        // instantiate the command used for the autonomous period
        drivecommand= new DriveCommand();//init drive command
        
        // Initialize all subsystems--
        robotmap.RobotMapInit();
        CommandBase.init();      
        CommandBase.m_drivetrainSubsystem.drivetrainInit();
        CommandBase.oi.OIinit();


        
        driverstationLCD.println(DriverStationLCD.Line.kUser1,1,"Robot initialized");
        driverstationLCD.println(DriverStationLCD.Line.kUser2,1,"All systems are ready");
        driverstationLCD.updateLCD();
    }

    
    
    
    
    
    public void autonomousInit() {//initialize auto
        driverstationLCD.clear();
        System.out.println("autonomusInit, Robot is alive");    
        
        driverstationLCD.println(DriverStationLCD.Line.kUser1,1,"Autonomus started");
        driverstationLCD.updateLCD();
        
    }   

    public void autonomousPeriodic() {//runs in auto
        Scheduler.getInstance().run();//run cmd scheduler
        
        driverstationLCD.updateLCD();
    }

    
    
    
    
    
    
    public void teleopInit() {//initialize teleop
        driverstationLCD.clear();
        System.out.println("teleopInit, Robot is alive");
        driverstationLCD.println(DriverStationLCD.Line.kUser1,1,"Teleoperated started");
        driverstationLCD.updateLCD();
    }
    
    public void teleopPeriodic() {
            
        CommandBase.oi.OIrun();//run oi method
        Scheduler.getInstance().run();// run cmd scheduler
        driverstationLCD.updateLCD();
    }
    
    
    
    
    
   public void testInit(){//test init
   System.out.println("TestInit");
   }
  
    public void testPeriodic() {//run test
        LiveWindow.run();
    }
   
    
    
    
    
    public void disabledInit(){//init disabled period
    System.out.println("DisabledInit"); 
    driverstationLCD.println(DriverStationLCD.Line.kUser1,1,"Robot disabled   ");
    
    }
    
    public void disabledPeriodic(){//run in disabled mode
    
  //      if(driverstation.getBatteryVoltage()>= Constants.criticalBattVoltage){
        //   driverstationLCD.println(DriverStationLCD.Line.kUser3,1,"CRITICAL BATTERY VOLTAGE"); 
        //}  
        
        
    driverstationLCD.updateLCD();
    }
    
    
}

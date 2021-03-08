/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams.            */           
/*                                                                            */
/*@ Cglan                                                                     */
/*
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.DriverStationLCD;


public class Robot extends IterativeRobot {
    
    int cycle = 1;//robot enable/disable cycle counter 

   public static Command drivewithsticks;//the drive command for standard driver control
   public static RobotMap robotmap = new RobotMap();//robot map
   public static DriverStationLCD driverstationLCD = DriverStationLCD.getInstance();
  
 
    
    public void robotInit() {//initialize at start, runs once
        System.out.println("Robot code exists");
        System.out.println("robotInit");    
        
        // Initialize all subsystems--
        robotmap.RobotMapInit();
        CommandBase.init();      
        CommandBase.m_drivetrainSubsystem.drivetrainInit();
        CommandBase.oi.OIinit();

        
  //*This if determines what controller type the bot is using and selects the appropriate drive command*
        if("Xbox/PlayStation".equals(CommandBase.oi.JoystickType)){      
        drivewithsticks = new DriveWithXbox_Ps();//init drive command for xbox/ps controller
        }
        else if("NintendoSwitchFPP".equals(CommandBase.oi.JoystickType)){
        drivewithsticks = new DriveWithNintendoFPP();//init drive command for nintendo fpp controller   
        }
        else{
        drivewithsticks = new DriveStop(); //will stop dt
        }
        
        instantDriverstationLCD(DriverStationLCD.Line.kUser1,1,"Robot initialized");
        instantDriverstationLCD(DriverStationLCD.Line.kUser2,1,"All systems are ready");
   
    }

    
    
    
    
    
    public void autonomousInit() {//initialize auto
        driverstationLCD.clear();
        System.out.println("autonomusInit, Robot is alive");    
        
        instantDriverstationLCD(DriverStationLCD.Line.kUser1,1,"Autonomus started");
        
        
    }   

    public void autonomousPeriodic() {//runs in auto
        Scheduler.getInstance().run();//run cmd scheduler

        
      
    }

    
    
    
    
    
    
    public void teleopInit() {//initialize teleop
        cycle++;//incriment cycle for every teleop init
        driverstationLCD.clear();//clear boot messages from ds
        System.out.println("teleopInit, Robot is alive");
        instantDriverstationLCD(DriverStationLCD.Line.kUser1,1,"Teleoperated started");
        
        drivewithsticks.start();//Start the drive command
    }
    
    public void teleopPeriodic() {
            
        CommandBase.oi.OIrun();//run oi method
        Scheduler.getInstance().run();// run cmd scheduler

    }
    
    
    
    
    
   public void testInit(){//test init
   System.out.println("TestInit");
   }
  
    public void testPeriodic() {//run test
        LiveWindow.run();
    }
   
    
    
    
    
    public void disabledInit(){//init disabled period
        if(cycle>1){
         driverstationLCD.clear();
        }//clears boot info only after initial enable
        
     CommandBase.m_drivetrainSubsystem.setFans(false);//make sure the fans are off
                
    System.out.println("DisabledInit"); 
    instantDriverstationLCD(DriverStationLCD.Line.kUser1,1,"Robot disabled      ");
    
    }
    
    public void disabledPeriodic(){//run in disabled mode
    

    }
    
    
    public static void instantDriverstationLCD(DriverStationLCD.Line line, int column, String text){
        //Legacy ds has 21 characters per line
        
        driverstationLCD.println(line, column,"                     ");//fully clear the line with 21 spaces
        driverstationLCD.updateLCD();//write the line clear
        
        driverstationLCD.println(line, column, text);//buffers the text to be displayed
        driverstationLCD.updateLCD();//writes the text to the lcd
        
    }
        
}


package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *@author Cglan
 * This is the drivetrain subsystem
 */
public class DrivetrainSubsystem extends Subsystem {
   
    
  public static RobotDrive robotdrive;//robotdrive drive controller
  public static SpeedController LeftDTmotor;//drivetrain motor
  public static SpeedController RightDTmotor;//drivetrain motor
  public static DigitalOutput dtFans;//digital output to control dt victor fans
   
   
   
  public void drivetrainInit(){//initialize the drivetrain
      
    LeftDTmotor = new Victor(1);//dt left victor
    RightDTmotor = new Victor(2);//dt right victor
    
    dtFans = new DigitalOutput(1);//di/o port the victor fans are on
  
  robotdrive = new RobotDrive(LeftDTmotor,RightDTmotor);
  robotdrive.setSafetyEnabled(false);
  robotdrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
  
  }
    
  public void arcadeDrive(double magnitude,double rotation){//drive with arcade controls
  
  robotdrive.setSafetyEnabled(false);
  
  robotdrive.arcadeDrive(magnitude, rotation);
  
  }
  
  public void stop(){//stop the drivetrain
  robotdrive.setSafetyEnabled(false);
       robotdrive.drive(0,0);
  
  }
  
  public void setFans(boolean io){//set the victor fans on/off, they should ALWAYS be on when driving motors
  
    dtFans.set(io);//sets the fans on or off
      
  
  }

    public void initDefaultCommand() {//this subsystem has no default command
        // Set the default command for a subsystem here.
       // setDefaultCommand();
    }
}


package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    
   //Speed Controllers-----------------------------------------------------
  public static SpeedController LeftDTmotor;//drivetrain motor
  public static SpeedController RightDTmotor;//drivetrain motor
  
  

  
  
  //DI/O--------------------------------------------------------------------
  


  public static DigitalOutput dtFans;//digital output to control dt victor fans
  
  
  //Relays-----------------------------------------------------------------

  
  
  
  
  
    public void RobotMapInit(){//initialize all created objects

    LeftDTmotor = new Victor(1);
    RightDTmotor = new Victor(2);
    
    dtFans = new DigitalOutput(1);
    
    }
  
}

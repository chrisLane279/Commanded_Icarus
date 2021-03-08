package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    
   //Speed Controllers-----------------------------------------------------

  public static final int leftDTmotorPort = 1;//pwm port the left dt victors are on
  public static final int rightDTmotorPort = 2;//pwm port the right dt victors are on
  

  
  
  //DI/O--------------------------------------------------------------------
  

  public static final int dtFansPort = 1;//di/o for the dt fans


  
  //Relays-----------------------------------------------------------------


  
  
  
    public void RobotMapInit(){//initialize anything that should be

      /*runs in robot init*/
        
    }
  
}

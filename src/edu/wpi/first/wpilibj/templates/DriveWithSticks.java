
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author cglane
 */
public class DriveWithSticks {//This class is for driving the robot with direct driver input
    
    
    public void drive(){
        
      if(OI.isCreeping == false){
       CommandBase.m_drivetrainSubsystem.arcadeDrive();
      }
      
      else if(OI.isCreeping == true && OI.driverR.get() == true){
       CommandBase.m_drivetrainSubsystem.creep(Constants.slowCreepSpeed,Constants.slowTurnVal);
      }
      
      else if(OI.isCreeping == true && OI.driverL.get() == true){
       CommandBase.m_drivetrainSubsystem.creep(-Constants.slowCreepSpeed,Constants.slowTurnVal);
      }
      
      else if(OI.isCreeping == true && OI.driverZR.get() == true){
       CommandBase.m_drivetrainSubsystem.creep(Constants.fastCreepSpeed,Constants.medTurnVal);
      }
      
      else if(OI.isCreeping == true && OI.driverZL.get() == true){
       CommandBase.m_drivetrainSubsystem.creep(-Constants.fastCreepSpeed,Constants.medTurnVal);
      }
    
    }
    
    
    
}

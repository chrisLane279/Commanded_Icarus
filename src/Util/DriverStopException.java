

package Util;
/**
 *
 * @author clane
 */
public class DriverStopException extends RuntimeException{//This exception is to allow the driver to stop the robot
    
  public DriverStopException(String errorMessage){
    super(errorMessage);
  
  }
 
}

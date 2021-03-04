

package Util;
/**
 *
 * @author clane
 */
public class DriverStopException extends RuntimeException{//This exception is to allow the driver to stop the robot in case of emergency
    
  public DriverStopException(String errorMessage){
    super(errorMessage);
  
  }
 
}

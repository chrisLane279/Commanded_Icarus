

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DigitalModule;

/**
 * This class is to handle all internal robot communication such as the I2C, CAN, RS232, or other serial buses
 * SPI, UART, parallel, and other communications may be handled here too
 * 
 * This class should act as the ambassador to all non-ethernet-network data going in and out of the rio
 * 
 * @author cglan
 */
public class CommunicationHandler {
    
    public DigitalModule digitalsidecar = DigitalModule.getInstance(1);
    
   // public static I2C i2c = new I2C();
    
    
    
    
}

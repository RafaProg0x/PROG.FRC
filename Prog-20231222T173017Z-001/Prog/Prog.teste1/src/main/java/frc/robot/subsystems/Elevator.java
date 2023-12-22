
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

 WPI_VictorSPX emotor1; 
 WPI_VictorSPX emotor2; 
 DigitalInput etoplimit1;
 DigitalInput ebottomlimit2;
 MotorControllerGroup group;
 Encoder encoder;

    
  public Elevator() {

    emotor1 = new WPI_VictorSPX(Constants.Intake.id_ileft);
    emotor2 = new WPI_VictorSPX(Constants.Intake.id_iright);
    group = new MotorControllerGroup(emotor1,emotor2);
    etoplimit1 = new DigitalInput(Constants.Elevators.id_elimit1);
    ebottomlimit2 = new DigitalInput(Constants.Elevators.id_elimit2);
    encoder = new Encoder(Constants.Elevators.id_boreencoder1, Constants.Elevators.id_boreencoder2);
  
  }

public void movement(double speed) {

 //double valencoder;
//valencoder = encoder.get();
//valencoder = (1000 - valencoder) * 0.001;

    if (speed > 0) {
        if (etoplimit1.get() || ebottomlimit2.get()) {
            // We are going up and top limit is tripped so stop
            emotor1.set(0);
            emotor2.set(0);
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            emotor1.set(speed);
            emotor2.set(speed);
        }
    }
}

public double pegaencoder() {

return encoder.get();

}

  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

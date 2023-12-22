
package frc.robot.subsystems;

//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


//importando bibliotecas dos controladores 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX         ct_rf, ct_lf;
  private WPI_VictorSPX        ct_rb, ct_lb;
  private MotorControllerGroup right, left;
  private DifferentialDrive    drive;


  public Drivetrain() {

    ct_rf = new WPI_TalonSRX(Constants.Drivetrain.id_rfront);
    ct_lb = new WPI_VictorSPX(Constants.Drivetrain.id_lback);
    ct_rb = new WPI_VictorSPX(Constants.Drivetrain.id_rback);
    ct_lf = new WPI_TalonSRX(Constants.Drivetrain.id_lfront);

    right = new MotorControllerGroup(ct_rf, ct_rb);
    left  = new MotorControllerGroup(ct_lf, ct_lb);
    drive = new DifferentialDrive(right, left);

  }
 
  public void traction (double y, double x) {

    drive.arcadeDrive(y, x);
     
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("ENC_ESQ", ct_lf.getSelectedSensorPosition());
    SmartDashboard.putNumber("ENC_DIR", ct_rf.getSelectedSensorPosition());

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

package frc.robot;

import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pitch;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {

  XboxController pilot, coPilot;

  Drivetrain drivetrain;
  Intake intake;
  Elevator elevator;
  Pitch pitch;
  

  public RobotContainer() {

    pilot   = new XboxController(Constants.Joystick.id_pilot);
    coPilot = new XboxController(Constants.Joystick.id_copilot);

    drivetrain = new Drivetrain();
    elevator = new Elevator();
    intake = new Intake();
    pitch = new Pitch(elevator);

    configureBindings();

  }

  private void configureBindings() {

    //DRIVE
    drivetrain.setDefaultCommand( new RunCommand(() -> {

      drivetrain.traction(pilot.getRightX() * (pilot.getRightBumper() ? .5 : 1) , pilot.getLeftY() * (pilot.getRightBumper() ? .5 : 1));

    }, drivetrain));


// comando de intake sistema de garra
    intake.setDefaultCommand(new RunCommand(() -> {
// esta logica é utilizada quando vc quer usar dois gatilhos para coletar ou repelir algo 
      if      (coPilot.getLeftTriggerAxis() > 0) intake.collect(coPilot.getLeftTriggerAxis());
      else if (coPilot.getLeftBumper()) intake.collect(0.3);
      else if (coPilot.getRightTriggerAxis() > 0) intake.collect(-coPilot.getRightTriggerAxis());
      else    intake.collect(.0);

}, intake));

// comando do elevador
elevator.setDefaultCommand(new RunCommand(() -> {
  if (coPilot.getLeftY() < 0) {

    if (coPilot.getAButton()) elevator.movement(coPilot.getLeftY() * -0.5);
    else elevator.movement(-1);  
  }
    
  if (coPilot.getLeftY() > 0) {

    if (coPilot.getAButton()) elevator.movement(coPilot.getLeftY() * 0.5);
    else elevator.movement(1);  
  }
  
  }, elevator));

// comando do pitch
pitch.setDefaultCommand(new RunCommand(() -> {

pitch.movementpitch();

  }, pitch));



  }



}
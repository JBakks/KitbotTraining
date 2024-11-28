package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final CommandXboxController driver = new CommandXboxController(0);
  // The robot's subsystems and commands are defined here...
  private final Drive m_drive = new Drive();
  private int forwardAxis = XboxController.Axis.kRightTrigger.value;

  // ADDED THIS
  private final Trigger driveForward = driver.rightTrigger();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

  }

  private void configureBindings() {
    // driver.rightTrigger().whileTrue(new DriveCommand(m_drive, rotationAxis, driveForward));
    // driver.leftTrigger().whileTrue(new DriveCommand(m_drive, rotationAxis, driveBackwards));

    m_drive.setDefaultCommand(
      new DriveCommand(
        m_drive, 
        () -> driver.getRawAxis(0),
        () -> driver.getRightTriggerAxis()
    ));

    // driver.rightTrigger().whileTrue(
    //   new DriveCommand(
    //     m_drive, 
    //     () -> driver.getRawAxis(0),
    //     () -> driver.getRightTriggerAxis()
    //   )
    // );

    // driver.leftTrigger().whileTrue(
    //   new DriveCommand(
    //     m_drive, 
    //     () -> driver.getRawAxis(0),
    //     () -> -driver.getLeftTriggerAxis()
    //   )
    // );

    
  }

  public Command getAutonomousCommand(){
    return Autos.driveAuto(m_drive);
  }

}

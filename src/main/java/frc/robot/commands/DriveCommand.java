package frc.robot.commands;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import edu.wpi.first.wpilibj2.command.Command;


public class DriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final frc.robot.subsystems.Drive drive;
  private DoubleSupplier rotate;
  private DoubleSupplier power;

  public DriveCommand(Drive drive, DoubleSupplier rotate, DoubleSupplier power) {
    this.drive = drive;
    this.rotate = rotate;
    this.power = power;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = power.getAsDouble() + rotate.getAsDouble();
    double rightSpeed = power.getAsDouble() - rotate.getAsDouble();
    drive.setPower(-leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

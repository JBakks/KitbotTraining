package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public final class Autos {
    public static Command driveAuto(Drive drive){
        return new DriveCommand(drive, ()-> 0, ()-> 0.1).withTimeout(2);
    }
    
}

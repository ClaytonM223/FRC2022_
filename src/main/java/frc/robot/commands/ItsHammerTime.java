// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;

public class ItsHammerTime extends CommandBase {
  /** Creates a new ItsHammerTime. */
  public ItsHammerTime() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Up){
      RobotContainer.ILift.actuateSolenoid(true);
    }
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Down){
      RobotContainer.ILift.actuateSolenoid(false);
    }
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

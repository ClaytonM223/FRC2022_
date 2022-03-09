// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive() {
    addRequirements(RobotContainer.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.driverRightBumper.get()){
      double turn = RobotContainer.GetDriverRawAxis(Constants.DRIVER_R_X_ID)*Constants.SpeedButtonTurnCoeffecient;
      double move = RobotContainer.GetDriverRawAxis(Constants.DRIVER_L_Y_ID)*Constants.SpeedButtonMoveCoeffecient;
      RobotContainer.driveTrain.manualDrive(move, turn);
    }else{
      double turn = RobotContainer.GetDriverRawAxis(Constants.DRIVER_R_X_ID);
      double move = RobotContainer.GetDriverRawAxis(Constants.DRIVER_L_Y_ID);
      RobotContainer.driveTrain.manualDrive(move, turn);
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

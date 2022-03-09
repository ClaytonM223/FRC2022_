// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;
import frc.robot.Constants.USB;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive() {
    addRequirements(RobotContainer.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveTrain.manualDrive(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.driverRightBumper.get()){
      double turn = RobotContainer.GetDriverRawAxis(USB.DRIVER_R_X_ID)*TeleopVariables.SpeedButtonTurnCoeffecient;
      double move = RobotContainer.GetDriverRawAxis(USB.DRIVER_L_Y_ID)*TeleopVariables.SpeedButtonMoveCoeffecient;
      RobotContainer.driveTrain.manualDrive(move, turn);
    }else if(RobotContainer.driverleftBumper.get()){
      double turn = RobotContainer.GetDriverRawAxis(USB.DRIVER_R_X_ID)*TeleopVariables.SpeedButtonTurnCoeffecient;
      double move = RobotContainer.GetDriverRawAxis(USB.DRIVER_L_Y_ID)*TeleopVariables.SpeedButtonMoveCoeffecient;
      RobotContainer.driveTrain.manualDrive(move, turn);
    }else{
      double turn = RobotContainer.GetDriverRawAxis(USB.DRIVER_R_X_ID);
      double move = RobotContainer.GetDriverRawAxis(USB.DRIVER_L_Y_ID);
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

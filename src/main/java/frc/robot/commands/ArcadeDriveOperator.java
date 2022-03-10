// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;
import frc.robot.Constants.USB;


public class ArcadeDriveOperator extends CommandBase {
  /** Creates a new ArcadeDrive. */
  public ArcadeDriveOperator() {

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
    if (RobotContainer.GetOperatorRawAxis(USB.DRIVER_R_TRIGGER) > 0.2){
      RobotContainer.driveTrain.manualDrive(
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_L_Y_ID)*TeleopVariables.SpeedButtonTurnCoeffecient,
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_R_X_ID)*TeleopVariables.SpeedButtonMoveCoeffecient
        );
    }else if(RobotContainer.GetOperatorRawAxis(USB.OPERATOR_L_TRIGGER) > 0.2){
      RobotContainer.driveTrain.manualDrive(
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_L_Y_ID)*TeleopVariables.SpeedButton2TurnCoeffecient,
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_R_X_ID)*TeleopVariables.SpeedButton2MoveCoeffecient
        );
    }else{
      RobotContainer.driveTrain.manualDrive(
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_L_Y_ID),
        RobotContainer.GetOperatorRawAxis(USB.OPERATOR_R_X_ID)
        );
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;

public class YEET extends CommandBase {
  /** Creates a new YEET. */
  public YEET() {
    addRequirements(RobotContainer.shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.shooter.setShooterPower(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Right){
      RobotContainer.shooter.setShooterPower(0.1);
    }
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Up){
      RobotContainer.shooter.setShooterPower(0.2);
    }
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Left){
      RobotContainer.shooter.setShooterPower(0.3);
    }
    if (RobotContainer.operatorController.getPOV() == TeleopVariables.D_Pad_Down){
      RobotContainer.shooter.setShooterPower(0.4);
    }
    if (RobotContainer.operatorController.getAButton()){
      RobotContainer.shooter.setShooterPower(0.6);
    }
    if (RobotContainer.operatorController.getBButton()){
      RobotContainer.shooter.setShooterPower(0.7);
    }
    if (RobotContainer.operatorController.getYButton()){
      RobotContainer.shooter.setShooterPower(0);
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

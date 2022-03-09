// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;

public class NomNom extends CommandBase {
  /** Creates a new NomNom. */
  public NomNom() {
    addRequirements(RobotContainer.intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.intake.setIntakePower(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((RobotContainer.operatorController.getLeftBumper()) && (RobotContainer.operatorController.getBackButton())){
      RobotContainer.intake.setIntakePower(-TeleopVariables.COLLECTION_SPEED, -TeleopVariables.COLLECTION_ROLLER_SPEED);
    }else if(RobotContainer.operatorController.getLeftBumper()){
      RobotContainer.intake.setIntakePower(TeleopVariables.COLLECTION_SPEED, TeleopVariables.COLLECTION_ROLLER_SPEED);
    }else{
      RobotContainer.intake.setIntakePower(0, 0);
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

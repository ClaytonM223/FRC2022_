// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoNumbers;
import frc.robot.Constants.TeleopVariables;

public class AutoCollect extends CommandBase {
  /** Creates a new AutoCollect. */
  boolean running;

  public AutoCollect(boolean run) {
    running = run;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (running == true){
      RobotContainer.intake.setIntakePower(TeleopVariables.COLLECTION_SPEED, AutoNumbers.IntakeRollerSpeed);
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
    return true;
    //if(running == false){
    //  RobotContainer.intake.setIntakePower(0, 0);
    //  return true;
    //}else{
    //  return false;
    //}
  }
}

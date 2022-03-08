// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class EncoderDrive extends CommandBase {
  double target;
  double rightOffset;
  double leftOffset;

  /** Creates a new EncoderDrive. */
  public EncoderDrive(double distance) {
    distance = target;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double rightOffset = RobotContainer.driveTrain.rightEncoder.getPosition();
    double leftOffset = RobotContainer.driveTrain.leftEncoder.getPosition();
    RobotContainer.driveTrain.frontRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backLeft.setIdleMode(IdleMode.kBrake);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rightEncoder = RobotContainer.driveTrain.rightEncoder.getPosition() - rightOffset;
    double leftEncoder = RobotContainer.driveTrain.leftEncoder.getPosition() - leftOffset;


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

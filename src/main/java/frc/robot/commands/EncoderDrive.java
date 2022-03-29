// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class EncoderDrive extends CommandBase {
  public RelativeEncoder m_rightEncoder;
  public RelativeEncoder m_leftEncoder;
  double m_target;
  /** Creates a new EncoderDrive. */
  public EncoderDrive(double target) {
    addRequirements(RobotContainer.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
    m_target = target;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_rightEncoder = RobotContainer.driveTrain.frontRight.getEncoder();
    m_leftEncoder = RobotContainer.driveTrain.frontLeft.getEncoder();
    m_rightEncoder.setPosition(0);
    m_leftEncoder.setPosition(0);
    RobotContainer.driveTrain.frontLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontLeft.setClosedLoopRampRate(2);
    RobotContainer.driveTrain.frontRight.setClosedLoopRampRate(2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_target > m_rightEncoder.getPosition()){
      RobotContainer.driveTrain.manualDrive(-0.5, 0);
    }else{
      RobotContainer.driveTrain.manualDrive(0, 0);
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

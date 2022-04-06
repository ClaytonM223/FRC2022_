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
  double m_target;
  double m_speed;
  /** Creates a new EncoderDrive. */

  /**Drives to a target number of rotations. Use speed to change direction not target
   * @param target Number of wheel rotations to go to
   * @param speed positive is forward, negaitive is backward
   */
  public EncoderDrive(double target, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_target = target;
    m_speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_rightEncoder = RobotContainer.driveTrain.frontRight.getEncoder();
    m_rightEncoder.setPosition(0);
    RobotContainer.driveTrain.frontLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backRight.setIdleMode(IdleMode.kBrake);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Math.abs(m_target) < Math.abs(m_rightEncoder.getPosition())){
      RobotContainer.driveTrain.manualDrive(0, 0);
    }else{
      RobotContainer.driveTrain.manualDrive(m_speed, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.manualDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(m_target) < Math.abs(m_rightEncoder.getPosition())){
      RobotContainer.driveTrain.manualDrive(0, 0);
      return true;
    }else{
      return false;
    }
  }
}

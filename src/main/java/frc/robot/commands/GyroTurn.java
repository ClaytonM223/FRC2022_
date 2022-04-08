// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.sensors.Pigeon2;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.CANID;



public class GyroTurn extends CommandBase {

  private static final Pigeon2 pigeon = new Pigeon2(CANID.PIGEON_ID);
  /** Creates a new GyroTurn.*/
  //Counter Clockwise is positive
  double m_angle;
  double m_speed;
  /**Turns the robot to face input angle
   * @param angle target angle to go to
   * @param speed setting this to a positive will have the robot go counterclockwise to reach the target. Use a negative to go clockwise
   */
  public GyroTurn(double angle , double speed) {
    m_speed = speed;
    m_angle = angle;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pigeon.setYaw(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = pigeon.getYaw();
    if (Math.abs(m_angle) > Math.abs(error)){
      RobotContainer.driveTrain.drive.arcadeDrive(0, m_speed);
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
    if(Math.abs(m_angle) > Math.abs(pigeon.getYaw())){
      return false;
    }else{
      RobotContainer.driveTrain.manualDrive(0, 0);
      return true;
    }
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoNumbers;
import frc.robot.Constants.TeleopVariables;

public class AUTOBackUpShoot extends CommandBase {
  private final I2C.Port i2c = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2c);

  
  private static final Timer m_timer = new Timer();
  Double TargetTime = AutoNumbers.DriveTime;
  
  /** Creates a new AUTOBackUpShoot. */
  public AUTOBackUpShoot() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
        
    m_timer.reset();
    m_timer.start();
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
        
    RobotContainer.shooter.setShooterPower(AutoNumbers.ShooterPower);
    if ((m_timer.get() < TargetTime) && (m_timer.get() > AutoNumbers.WaitTime)){
      RobotContainer.driveTrain.manualDrive(0.5, 0);
    }else{
      RobotContainer.driveTrain.manualDrive(0, 0);
    }

    if (m_timer.get() >= AutoNumbers.LaunchTime){
      RobotContainer.transfer.setTransferPower(1);
    }else if (m_colorSensor.getProximity() < TeleopVariables.PROXIMITY){
      RobotContainer.transfer.setTransferPower(TeleopVariables.TRANSFER_SPEED);
    }else{
      RobotContainer.transfer.setTransferPower(0);
    }


    if (m_timer.get() > 10){
      RobotContainer.transfer.setTransferPower(0);
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
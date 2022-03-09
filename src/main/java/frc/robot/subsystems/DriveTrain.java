// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.HardwareNumbers;

public class DriveTrain extends SubsystemBase {
  public final CANSparkMax frontRight = new CANSparkMax(Constants.RIGHT_FRONT_ID , MotorType.kBrushless);
  public final CANSparkMax backRight = new CANSparkMax(Constants.RIGHT_BACK_ID , MotorType.kBrushless);
  public final CANSparkMax frontLeft = new CANSparkMax(Constants.LEFT_FRONT_ID , MotorType.kBrushless);
  public final CANSparkMax backLeft = new CANSparkMax(Constants.LEFT_BACK_ID , MotorType.kBrushless);

  private final RelativeEncoder leftEncoder = frontLeft.getEncoder();
  private final RelativeEncoder rightEncoder = frontRight.getEncoder();

  public DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    frontRight.setInverted(true);
    //frontLeft.setInverted(true);
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);

    leftEncoder.setPositionConversionFactor(Math.PI * HardwareNumbers.WheelDiameter / HardwareNumbers.GearRatio);
    rightEncoder.setPositionConversionFactor(Math.PI * HardwareNumbers.WheelDiameter / HardwareNumbers.GearRatio);
    leftEncoder.setVelocityConversionFactor(Math.PI * HardwareNumbers.WheelDiameter / HardwareNumbers.GearRatio / 60);
    rightEncoder.setVelocityConversionFactor(Math.PI * HardwareNumbers.WheelDiameter / HardwareNumbers.GearRatio / 60);

    
    drive.feed();
  }
  public void manualDrive(double Move, double Turn){
    drive.arcadeDrive(-Move, Turn);
    if (Math.abs(Move) < 0.05){
      Move = 0;
    }
    if (Math.abs(Turn) < 0.05){
      Turn = 0;
    }
    drive.feed();
    
  } 

  public void tankDrive(double left, double right){
    drive.tankDrive(left, right);
  }
 
  @Override
  public void periodic() {
    drive.feedWatchdog();
    // This method will be called once per scheduler run
  }
}

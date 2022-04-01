// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANID;

public class Shooter extends SubsystemBase {
  public static final CANSparkMax shooter = new CANSparkMax(CANID.SHOOTER_ID, MotorType.kBrushless);
  public RelativeEncoder shooterEncoder = shooter.getEncoder();
  /** Creates a new Shooter. */
  public Shooter() {
    
    shooter.restoreFactoryDefaults();
    shooter.clearFaults();
    shooter.setSmartCurrentLimit(35);
  }
  public void setShooterPower(double speed){
    shooter.set(speed);
  }
  public void setShooterRPM(double RPM){
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

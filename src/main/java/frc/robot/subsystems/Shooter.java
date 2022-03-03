// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public static final CANSparkMax shooter = new CANSparkMax(Constants.SHOOTER_ID, MotorType.kBrushless);
  /** Creates a new Shooter. */
  public Shooter() {
    shooter.restoreFactoryDefaults();
  }
  public void setShooterPower(double speed){
    shooter.set(speed);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Theroretical Shooter RPM", shooter.get()*5874*2.71);
    SmartDashboard.putNumber("Shooter Temperature", shooter.getMotorTemperature());
    // This method will be called once per scheduler run
  }
}

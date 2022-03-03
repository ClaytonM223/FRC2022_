// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  final CANSparkMax leftCollection = new CANSparkMax(Constants.COLLECTION_L_ID , MotorType.kBrushless);
  final CANSparkMax rightCollection = new CANSparkMax(Constants.COLLECTION_R_ID , MotorType.kBrushless);
  final WPI_VictorSPX roller = new WPI_VictorSPX(Constants.COLLECTION_ROLLER_ID);
  /** Creates a new Intake. */
  public Intake() {
    leftCollection.restoreFactoryDefaults();
    rightCollection.restoreFactoryDefaults();
    rightCollection.setInverted(true);
    roller.setInverted(true);
  }
  public void setIntakePower(double speed, double roller_speed){
    rightCollection.set(speed);
    leftCollection.set(speed);
    roller.set(roller_speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

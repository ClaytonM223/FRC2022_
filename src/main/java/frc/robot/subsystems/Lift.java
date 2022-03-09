// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANID;

public class Lift extends SubsystemBase {
  /** Creates a new Lift. */ 
  final WPI_VictorSPX leftLift = new WPI_VictorSPX(CANID.LEFT_LIFT_ID);
  final WPI_VictorSPX rightLift = new WPI_VictorSPX(CANID.RIGHT_LIFT_ID);
  public Lift() {
    leftLift.setInverted(false);
    rightLift.setInverted(false);
    leftLift.setNeutralMode(NeutralMode.Coast);
    rightLift.setNeutralMode(NeutralMode.Coast);
  }

  public void Leftlift(double left_speed){
    leftLift.set(left_speed);
  } 
  public void Rightlift(double right_lift){
    rightLift.set(right_lift);
  }
  public void liftBoth(double speed){
    leftLift.set(speed);
    rightLift.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

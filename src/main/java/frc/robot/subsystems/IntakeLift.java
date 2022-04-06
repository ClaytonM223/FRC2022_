// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HardwareNumbers;

public class IntakeLift extends SubsystemBase {
  public final DoubleSolenoid arm = new DoubleSolenoid(PneumaticsModuleType.REVPH, HardwareNumbers.ArmForward, HardwareNumbers.ArmBackward);
  /** Creates a new IntakeLift.*/
  public IntakeLift() {}

  /**true is up, false is down */
  public void actuateSolenoid(Boolean state){
    if(state == true){
      arm.set(DoubleSolenoid.Value.kForward);
    }
    if(state == false){
      arm.set(DoubleSolenoid.Value.kReverse);
    }  
    if(state == null){
      arm.set(DoubleSolenoid.Value.kOff);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

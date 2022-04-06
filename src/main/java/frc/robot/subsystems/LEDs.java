// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDs extends SubsystemBase {
  private final Spark LEDSpark = new Spark(1);
  /** Creates a new LEDs. */
  public LEDs() {
  }
  /**
   * Uses the table of values in "Notes" to determine the color. Treated as a spark motor controller.
   * @param value value to be set to
   * 
   */
  public void setLED(double value){
    LEDSpark.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

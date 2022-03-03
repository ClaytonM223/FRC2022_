// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Transfer extends SubsystemBase {

  private static final WPI_VictorSPX transfer = new WPI_VictorSPX(Constants.TRANSFER_ID);
  /** Creates a new Transfer. */
  public Transfer() {
    transfer.setNeutralMode(NeutralMode.Brake);
  }

  public void setTransferPower(double speed){
    transfer.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

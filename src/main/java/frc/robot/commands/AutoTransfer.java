// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;

public class AutoTransfer extends CommandBase {
  private final I2C.Port i2c = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2c);
  /** Creates a new AutoTransfer. */
  boolean m_o;
  public AutoTransfer(boolean override) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_o = override;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.transfer.setTransferPower(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_o == true){
      RobotContainer.transfer.setTransferPower(TeleopVariables.TRANSFER_SPEED);
    }else if (m_colorSensor.getProximity() < TeleopVariables.PROXIMITY){
      RobotContainer.transfer.setTransferPower(TeleopVariables.TRANSFER_SPEED);
    }else{
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

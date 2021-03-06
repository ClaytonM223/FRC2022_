// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.TeleopVariables;

public class LockedAndLoaded extends CommandBase {
  /** Creates a new LockedAndLoaded. */

  private final I2C.Port i2c = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2c);
  
  public LockedAndLoaded() {
    addRequirements(RobotContainer.transfer);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.transfer.setTransferPower(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (RobotContainer.operatorController.getBackButton() && (RobotContainer.operatorController.getRightBumper())){
      RobotContainer.transfer.setTransferPower(-TeleopVariables.TRANSFER_SPEED);
    }else if (RobotContainer.operatorController.getRightBumper()){
      RobotContainer.transfer.setTransferPower(TeleopVariables.TRANSFER_SPEED);
    }else if (m_colorSensor.getProximity() < TeleopVariables.PROXIMITY){
      RobotContainer.transfer.setTransferPower(TeleopVariables.TRANSFER_SPEED);
      SmartDashboard.putBoolean("Ball", false);
      if(DriverStation.getAlliance() == Alliance.Blue){
        RobotContainer.leds.setLED(0.87);
      }else{
        RobotContainer.leds.setLED(0.61); 
      }
    }else{
      RobotContainer.transfer.setTransferPower(0);
      SmartDashboard.putBoolean("Ball", true);
      if(DriverStation.getAlliance() == Alliance.Blue){
        RobotContainer.leds.setLED(-0.09);
      }else if(DriverStation.getAlliance() == Alliance.Red){
        RobotContainer.leds.setLED(-0.11);
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.transfer.setTransferPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

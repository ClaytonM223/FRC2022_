// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANID;

public class DriveTrain extends SubsystemBase {
  public CANSparkMax frontRight = new CANSparkMax(CANID.RIGHT_FRONT_ID , MotorType.kBrushless);
  public CANSparkMax backRight = new CANSparkMax(CANID.RIGHT_BACK_ID , MotorType.kBrushless);
  public CANSparkMax frontLeft = new CANSparkMax(CANID.LEFT_FRONT_ID , MotorType.kBrushless);
  public CANSparkMax backLeft = new CANSparkMax(CANID.LEFT_BACK_ID , MotorType.kBrushless);

  public DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);



  /** Creates a new DriveTrain. */
  public DriveTrain() {

    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);
    frontRight.setInverted(true);
    backRight.setInverted(true);

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
  @Override
  public void periodic() {
    drive.feedWatchdog();
    // This method will be called once per scheduler run
  }
}

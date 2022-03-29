// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANID;

public class DriveTrain extends SubsystemBase {
  public CANSparkMax frontRight;
  public CANSparkMax backRight;
  public CANSparkMax frontLeft;
  public CANSparkMax backLeft;

  public SparkMaxPIDController m_leftPidController;
  public SparkMaxPIDController m_rightPidController;
  public RelativeEncoder m_leftEncoder;
  public RelativeEncoder m_rightEncoder;
  public double kP;
  public double kI;
  public double kD;
  public double kIz;
  public double kFF;
  public double kMaxOutput;
  public double kMinOutput;

  public DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);



  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontRight = new CANSparkMax(CANID.RIGHT_FRONT_ID , MotorType.kBrushless);
    backRight = new CANSparkMax(CANID.RIGHT_BACK_ID , MotorType.kBrushless);
    frontLeft = new CANSparkMax(CANID.LEFT_FRONT_ID , MotorType.kBrushless);
    backLeft = new CANSparkMax(CANID.LEFT_BACK_ID , MotorType.kBrushless);

    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    frontRight.setInverted(true);
    backRight.setInverted(true);

    backRight.follow(frontRight);
    backLeft.follow(frontLeft);

    m_leftPidController = frontLeft.getPIDController();
    m_rightPidController = frontRight.getPIDController();

    m_leftEncoder = frontLeft.getEncoder();
    m_rightEncoder = frontRight.getEncoder();

    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;

    // set PID coefficients
    m_leftPidController.setP(kP);
    m_leftPidController.setI(kI);
    m_leftPidController.setD(kD);
    m_leftPidController.setIZone(kIz);
    m_leftPidController.setFF(kFF);
    m_leftPidController.setOutputRange(kMinOutput, kMaxOutput);

    m_rightPidController.setP(kP);
    m_rightPidController.setI(kI);
    m_rightPidController.setD(kD);
    m_rightPidController.setIZone(kIz);
    m_rightPidController.setFF(kFF);
    m_rightPidController.setOutputRange(kMinOutput, kMaxOutput);


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

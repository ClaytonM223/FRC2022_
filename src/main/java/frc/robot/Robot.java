// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.AutoNumbers;
import frc.robot.subsystems.Shooter;


//testing

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private static RobotContainer m_robotContainer;
  private final I2C.Port i2c = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2c);
  private static final PowerDistribution pdh = new PowerDistribution();


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Shooter Motor Temp", Shooter.shooter.getMotorTemperature());
    SmartDashboard.putNumber("PDH Voltage", pdh.getVoltage());
    SmartDashboard.putNumber("Shooter Current", Shooter.shooter.getOutputCurrent());
    //Shuffelboard things
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    Shooter.shooter.clearFaults();
  }

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  final double motorMinSpeed = 0.01;
  final double kP = 0.05;
  final double kI = 0.5;
  final double kD = 0.1;
  final double iLimit = 0.5;
  final double wheelCircumference = 8 * Math.PI;
  final double wheelCircumferneceFT = wheelCircumference/12;
  final double WheelrotationsPerFoot = 1/wheelCircumferneceFT;
  final double ticksPerRotation = 2048*12.75;
  final double ticksPerFoot = ticksPerRotation*WheelrotationsPerFoot;
  double leftTargetError = 0;
  double rightTargetError = 0;
  double lastTimestamp = 0;
  double lastError = 0;
  private final Timer m_timer = new Timer();
  double Target;
  double m_target;

  @Override
  public void autonomousInit() {
    m_timer.stop();
    m_timer.reset();
    m_timer.start();
    RobotContainer.driveTrain.frontRight.setOpenLoopRampRate(1);
    RobotContainer.driveTrain.backRight.setOpenLoopRampRate(1);
    RobotContainer.driveTrain.frontLeft.setOpenLoopRampRate(1);
    RobotContainer.driveTrain.backLeft.setOpenLoopRampRate(1);
    RobotContainer.driveTrain.backLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontLeft.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.backRight.setIdleMode(IdleMode.kBrake);
    RobotContainer.driveTrain.frontRight.setIdleMode(IdleMode.kBrake);
    leftTargetError = 0;
    rightTargetError = 0;
    lastTimestamp = 0;
    lastTimestamp = Timer.getFPGATimestamp();
    lastError = 0;

    RobotContainer.driveTrain.frontRight.getEncoder();
        // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    RobotContainer.shooter.shooter.set(AutoNumbers.ShooterPower);
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    //Color Sensor
    int proximity = m_colorSensor.getProximity();
    SmartDashboard.putNumber("Proximity", proximity);

    //Arcade Drive
    if (RobotContainer.driverRightBumper.get()){
      double turn = Robot.m_robotContainer.GetDriverRawAxis(Constants.DRIVER_R_X_ID)*Constants.SpeedButtonTurnCoeffecient;
      double move = Robot.m_robotContainer.GetDriverRawAxis(Constants.DRIVER_L_Y_ID)*Constants.SpeedButtonMoveCoeffecient;
      RobotContainer.driveTrain.manualDrive(move, turn);
    }else{
      double turn = Robot.m_robotContainer.GetDriverRawAxis(Constants.DRIVER_R_X_ID);
      double move = Robot.m_robotContainer.GetDriverRawAxis(Constants.DRIVER_L_Y_ID);
      RobotContainer.driveTrain.manualDrive(move, turn);
    }
     

    //Intake
    if (RobotContainer.operatorBack.get() && (RobotContainer.operatorController.getRawAxis(Constants.OPERATOR_R_TRIGGER) > 0.02)){
      RobotContainer.intake.setIntakePower(-Constants.COLLECTION_SPEED, -Constants.COLLECTION_ROLLER_SPEED);
    }else if (RobotContainer.operatorController.getRawAxis(Constants.OPERATOR_R_TRIGGER) > 0.02){
      RobotContainer.intake.setIntakePower(Constants.COLLECTION_SPEED , Constants.COLLECTION_ROLLER_SPEED);
    }else{
      RobotContainer.intake.setIntakePower(0, 0);
    }

    //Transfer
    if (RobotContainer.operatorBack.get() && (RobotContainer.operatorController.getRawAxis(Constants.OPERATOR_L_TRIGGER) > 0.02)){
      RobotContainer.transfer.setTransferPower(-Constants.TRANSFER_SPEED);
    }else if (RobotContainer.operatorController.getRawAxis(Constants.OPERATOR_L_TRIGGER) > 0.02){
      RobotContainer.transfer.setTransferPower(Constants.TRANSFER_SPEED);
    }else if (m_colorSensor.getProximity() < Constants.PROXIMITY){
      RobotContainer.transfer.setTransferPower(Constants.TRANSFER_SPEED);
    }else{
      RobotContainer.transfer.setTransferPower(0);
    }

    //Shooter
    if (RobotContainer.operatorA.get()){
      RobotContainer.shooter.setShooterPower(Constants.SHOOTER_SPEED_1);
    }else if (RobotContainer.operatorB.get()){
      RobotContainer.shooter.setShooterPower(Constants.SHOOTER_SPEED_2);
    //}else if(RobotContainer.operatorY.get()){
    // RobotContainer.shooter.setShooterPower(Constants.SHOOTER_SPEED_3);
    }else if (RobotContainer.operatorY.get()){
      RobotContainer.shooter.setShooterPower(0);
    }

    //Lifts
    //Left Lift
    if (RobotContainer.operatorleftBumper.get()){
      RobotContainer.lift.Leftlift(Constants.LIFT_SPEED);
    }else{
      RobotContainer.lift.Leftlift(0);
    }
    //Right Lift
    if (RobotContainer.operatorRightBumper.get()){
      RobotContainer.lift.Rightlift(Constants.LIFT_SPEED);
    }else{
      RobotContainer.lift.Rightlift(0);
    }
    //Both lift
    if(RobotContainer.operatorX.get()){
      RobotContainer.lift.liftBoth(Constants.LIFT_SPEED);
    }else{
      RobotContainer.lift.liftBoth(0);
    }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

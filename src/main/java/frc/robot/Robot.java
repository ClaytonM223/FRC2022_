// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
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

  private static final PowerDistribution pdh = new PowerDistribution();
  boolean alliance;
  public RelativeEncoder shooterRPM = Shooter.shooter.getEncoder();



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    RobotContainer.driveTrain.drive.feed();
    RobotContainer.leds.setLED(0.);
    CameraServer.startAutomaticCapture(0);
    shooterRPM.setVelocityConversionFactor(1.93);
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
    RobotContainer.driveTrain.drive.feed();

    SmartDashboard.putNumber("Shooter Motor Temp", Shooter.shooter.getMotorTemperature());
    SmartDashboard.putNumber("PDH Voltage", pdh.getVoltage());
    SmartDashboard.putNumber("Shooter RPM",shooterRPM.getVelocity());
    SmartDashboard.putBoolean("Alliance", alliance);
    RobotContainer.driveTrain.drive.feed();
    //Shuffelboard things
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

    // For every pixel
    

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    RobotContainer.leds.setLED(0.71);
    RobotContainer.driveTrain.frontLeft.setIdleMode(IdleMode.kCoast);
    RobotContainer.driveTrain.frontRight.setIdleMode(IdleMode.kCoast);
    RobotContainer.driveTrain.backLeft.setIdleMode(IdleMode.kCoast);
    RobotContainer.driveTrain.backRight.setIdleMode(IdleMode.kCoast);
    RobotContainer.driveTrain.drive.feed();
  }

  @Override
  public void disabledPeriodic() {
    RobotContainer.driveTrain.drive.feed();
    Shooter.shooter.clearFaults();
  }
  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    RobotContainer.driveTrain.drive.feed();
    RobotContainer.leds.setLED(0.77);
    // schedule the autonomous command (example)
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    RobotContainer.driveTrain.drive.feed();
  }

  @Override
  public void teleopInit() {
    if(DriverStation.getAlliance() == DriverStation.Alliance.Blue){
      RobotContainer.leds.setLED(0.87);
    }else{
      RobotContainer.leds.setLED(0.61); 
    }
    RobotContainer.driveTrain.drive.feed();
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
    RobotContainer.arcadeDrive.schedule();
    RobotContainer.nomnom.schedule();
    RobotContainer.lockedAndLoaded.schedule();
    RobotContainer.yeet.schedule();
    RobotContainer.upYaGo.schedule();
    RobotContainer.hammer.schedule();
    RobotContainer.driveTrain.drive.feed();
  }

  @Override
  public void testInit() {
    RobotContainer.ILift.actuateSolenoid(true);
    Timer.delay(3);
    RobotContainer.ILift.arm.set(Value.kOff);
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    RobotContainer.driveTrain.drive.feed();
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

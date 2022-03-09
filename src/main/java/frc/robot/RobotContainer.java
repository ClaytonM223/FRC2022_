// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transfer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveTrain driveTrain = new DriveTrain();
  public static final Intake intake = new Intake();
  public static final Transfer transfer = new Transfer();
  public static final Shooter shooter = new Shooter();
  public static final Lift lift = new Lift();

  //Driver Controller
  public static final Joystick driverController = new Joystick(Constants.DIRVER_CONTROLER_ID);
  public static final JoystickButton driverRightBumper = new JoystickButton(driverController, Constants.OPERATOR_RBUMPER_ID);
  public static final JoystickButton driverA = new JoystickButton(driverController, Constants.OPERATOR_A_ID);
  public static final JoystickButton driverleftBumper = new JoystickButton(driverController, Constants.OPERATOR_LBUMPER_ID);
  public static final JoystickButton driverBack = new JoystickButton(driverController, Constants.OPERATOR_BACK_ID);
  public static final JoystickButton driverStart = new JoystickButton(driverController, Constants.OPERATOR_START_ID);
  public static final JoystickButton driverB = new JoystickButton(driverController, Constants.OPERATOR_B_ID);
  public static final JoystickButton driverX = new JoystickButton(driverController, Constants.OPERATOR_X_ID);
  public static final JoystickButton driverY = new JoystickButton(driverController, Constants.OPERATOR_Y_ID);

  // Operator controls
  public static final Joystick operatorController = new Joystick(Constants.OPERATOR_CONTROLER_ID);
  public static final JoystickButton operatorRightBumper = new JoystickButton(operatorController, Constants.OPERATOR_RBUMPER_ID);
  public static final JoystickButton operatorA = new JoystickButton(operatorController, Constants.OPERATOR_A_ID);
  public static final JoystickButton operatorleftBumper = new JoystickButton(operatorController, Constants.OPERATOR_LBUMPER_ID);
  public static final JoystickButton operatorBack = new JoystickButton(operatorController, Constants.OPERATOR_BACK_ID);
  public static final JoystickButton operatorStart = new JoystickButton(operatorController, Constants.OPERATOR_START_ID);
  public static final JoystickButton operatorB = new JoystickButton(operatorController, Constants.OPERATOR_B_ID);
  public static final JoystickButton operatorX = new JoystickButton(operatorController, Constants.OPERATOR_X_ID);
  public static final JoystickButton operatorY = new JoystickButton(operatorController, Constants.OPERATOR_Y_ID);

  public double GetDriverRawAxis(final int axis){
    return driverController.getRawAxis(axis);
  }
  public double GetOperatorRawAxis(final int axis){
    return operatorController.getRawAxis(axis);
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

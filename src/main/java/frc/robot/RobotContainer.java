// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.Constants.USB;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.EncoderDrive;
import frc.robot.commands.LockedAndLoaded;
import frc.robot.commands.NomNom;
import frc.robot.commands.UpYaGo;
import frc.robot.commands.YEET;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transfer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

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
  public static final LEDs leds = new LEDs();

  public static final ArcadeDrive arcadeDrive = new ArcadeDrive();
  public static final NomNom nomnom = new NomNom();
  public static final LockedAndLoaded lockedAndLoaded = new LockedAndLoaded();
  public static final YEET yeet = new YEET();
  public static final UpYaGo upYaGo = new UpYaGo();

  public static final EncoderDrive encoderDrive = new EncoderDrive(0, 0);

  //Driver Controller
  public static final XboxController driverController = new XboxController(USB.DIRVER_CONTROLER_ID);
  // Operator controls
  public static final XboxController operatorController = new XboxController(USB.OPERATOR_CONTROLER_ID);


  public static double GetDriverRawAxis(final int axis){
    return driverController.getRawAxis(axis);
  }
  public static double GetOperatorRawAxis(final int axis){
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
    return new SequentialCommandGroup(
    new EncoderDrive(25, 0.5),
    new WaitCommand(2),
    new EncoderDrive(-25, -0.25)
    );
  }
}

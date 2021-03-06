// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.USB;
import frc.robot.commands.AUTOBackUpShoot;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoArm;
import frc.robot.commands.AutoCollect;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.AutoTransfer;
import frc.robot.commands.EncoderDrive;
import frc.robot.commands.GyroTurn;
import frc.robot.commands.ItsHammerTime;
import frc.robot.commands.LockedAndLoaded;
import frc.robot.commands.NomNom;
import frc.robot.commands.TwoBallAuto;
import frc.robot.commands.UpYaGo;
import frc.robot.commands.YEET;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeLift;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transfer;
import edu.wpi.first.wpilibj2.command.Command;

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
  public static final IntakeLift ILift = new IntakeLift();

  public static final ArcadeDrive arcadeDrive = new ArcadeDrive();
  public static final NomNom nomnom = new NomNom();
  public static final LockedAndLoaded lockedAndLoaded = new LockedAndLoaded();
  public static final YEET yeet = new YEET();
  public static final UpYaGo upYaGo = new UpYaGo();
  public static final ItsHammerTime hammer = new ItsHammerTime();

  public static final AutoTransfer autoTransfer = new AutoTransfer(false);
  public static final GyroTurn gyroTurn = new GyroTurn(0, 0);
  public static final EncoderDrive encoderDrive = new EncoderDrive(0, 0);
  public static final AutoShoot autoShoot = new AutoShoot(false);
  public static final AutoCollect autoCollect = new AutoCollect(false);
  public static final AutoArm autoArm = new AutoArm(false);
  public static final TwoBallAuto twoBallAuto = new TwoBallAuto();
  public static final AUTOBackUpShoot autoBackUpShoot = new AUTOBackUpShoot();

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

  SendableChooser<Command> chooser = new SendableChooser<>();

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    chooser.setDefaultOption("2 Ball Auto", twoBallAuto);
    chooser.addOption("1 Ball Auto", autoBackUpShoot);
    // Configure the button bindings
    Shuffleboard.getTab("SmartDashboard").add(chooser);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}

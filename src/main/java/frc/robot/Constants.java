// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

   public final class USB{
        //IDs
        public static final int DIRVER_CONTROLER_ID = 1;
        public static final int OPERATOR_CONTROLER_ID = 2;
        //Axis Driver
        public static final int DRIVER_L_X_ID = 0;
        public static final int DRIVER_L_Y_ID = 1;
        public static final int DIRVER_L_TRIGGER = 2;
        public static final int DRIVER_R_TRIGGER = 3;
        public static final int DRIVER_R_X_ID = 4;
        public static final int DRIVER_R_Y_ID = 5;
        //Driver Buttons 
        public static final int DRIVER_A_ID = 1;
        public static final int DRIVER_B_ID = 2;
        public static final int DRIVER_X_ID = 3;
        public static final int DRIVER_Y_ID = 4;
        public static final int DRIVER_LBUMPER_ID = 5;
        public static final int DRIVER_RBUMPER_ID = 6;
        //Axis Operator 
        public static final int OPERATOR_L_X_ID = 0;
        public static final int OPERATOR_L_Y_ID = 1;
        public static final int OPERATOR_L_TRIGGER = 2;
        public static final int OPERATOR_R_TRIGGER = 3;
        public static final int OPERATOR_R_X_ID = 4;
        public static final int OPERATOR_R_Y_ID = 5;
        //Operator Buttons
        public static final int OPERATOR_A_ID = 1;
        public static final int OPERATOR_B_ID = 2;
        public static final int OPERATOR_X_ID = 3;
        public static final int OPERATOR_Y_ID = 4;
        public static final int OPERATOR_LBUMPER_ID = 5;
        public static final int OPERATOR_RBUMPER_ID = 6;
        public static final int OPERATOR_BACK_ID = 7;
        public static final int OPERATOR_START_ID = 8;
   }
    public final class CANID{
        //Pigeon 2.0
        public static final int PIGEON_ID = 0;
        //PDH
        public static final int PDH_ID = 1;
        //DriveTrain
        public static final int RIGHT_FRONT_ID = 1;
        public static final int RIGHT_BACK_ID = 2;   
        public static final int LEFT_FRONT_ID = 3;     
        public static final int LEFT_BACK_ID = 4;
        //Shooter 
        public static final int SHOOTER_ID = 7;
        //Collection
        public static final int COLLECTION_R_ID = 6;
        public static final int COLLECTION_L_ID = 5;
        public static final int COLLECTION_ROLLER_ID = 11;
        //Transfer
        public static final int TRANSFER_ID = 8;
        //Lifts
        public static final int LEFT_LIFT_ID = 9;
        public static final int RIGHT_LIFT_ID = 10;
    }
    public final class TeleopVariables{
        public static final double COLLECTION_SPEED = 0.4;
        public static final double COLLECTION_ROLLER_SPEED = 0.45;
        public static final double TRANSFER_SPEED = 1;
        public static final double PROXIMITY = 100;
        public static final double SHOOTER_SPEED_1 = 0.5;
        public static final double SHOOTER_SPEED_2 = 0.6;
        public static final double LIFT_SPEED = 1;
        public static final double SpeedButtonMoveCoeffecient = 0.5;
        public static final double SpeedButtonTurnCoeffecient = 0.60;
        public static final double SpeedButton2MoveCoeffecient = 0.3;
        public static final double SpeedButton2TurnCoeffecient = 0.55;
        public static final double D_Pad_Down = 180;
        public static final double D_Pad_Right = 90;
        public static final double D_Pad_Up = 0;
        public static final double D_Pad_Left = 270;
    }
    public final class AutoNumbers{
        public static final double DriveSpeed = 0.5;
        public static final double ShooterPower = 0.23; //0.4
        public static final double DriveTime = 6.95;    //3.95
        public static final double LaunchTime = 3;      //6
        public static final double WaitTime = 5;        //2
        public static final double IntakeRollerSpeed = 0.35;
    }
    public final static class HardwareNumbers{
        public static final double GearRatio = 10.71;
        public final static double WheelDiameter = Units.inchesToMeters(6);
        public static final int NumberOfLEDs = 213;
        public static final int ArmForward = 0;
        public static final int ArmBackward = 1;
    } 
}
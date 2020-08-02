/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //Motor Controller ID Numbers
    public static final int FL = 0;
    public static final int BL = 1;
    public static final int FR = 2;
    public static final int BR = 3;

    //Joystick Inputs
    public static final int DRIVEJOY = 0;
    public static final int OPJOY = 1;
    public static final double DEADZONE = 0.2;

    //Joystick Axis
    public static final int XL = 0;
    public static final int YL = 1;
    public static final int XR = 4;
    public static final int YR = 5;

    //Sensor Input
    public static final int LIM = 0;

}

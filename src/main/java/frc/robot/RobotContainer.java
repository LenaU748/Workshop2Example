/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveForward;
import frc.robot.subsystems.Drivebase;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivebase m_drivebase = new Drivebase();

  //Initialize joysticks and buttons here
  public final XboxController driveJoy = new XboxController(Constants.DRIVEJOY);
  public final XboxController opJoy = new XboxController(Constants.OPJOY);

  //Adjust joystick outputs by adding deadzones
  public double getDriveJoy(int axis){
    double raw = driveJoy.getRawAxis(axis);
    return Math.abs(raw) < Constants.DEADZONE ? 0.0 : raw;
  }

  public double getOpJoy(int axis){
    double raw = opJoy.getRawAxis(axis);
    return Math.abs(raw) < Constants.DEADZONE ? 0.0 : raw;
  }

  public double getDriveJoyXR(){
    double raw = getDriveJoy(Constants.YL);
    return Math.abs(raw) < Constants.DEADZONE ? 0.0 : raw > 0 ? (raw*raw)/1.5 : (-raw*raw)/1.5;
  }


  //Create a method designated for teleop control
  public void teleop(){
    m_drivebase.m_drive.arcadeDrive(getDriveJoy(Constants.YL), getDriveJoyXR());
  }



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
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
    return new DriveForward(0.25); //This command will make robot drive forward until limit switch is pressed
  }
}

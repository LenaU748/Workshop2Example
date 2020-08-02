/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase extends SubsystemBase {
  /**
   * Creates a new Drivebase.
   */
  public Drivebase() {
    //This is a constructor
  }

  //Create motor controller objects
  public final CANSparkMax flMotor = new CANSparkMax(Constants.FL, MotorType.kBrushless);
  public final CANSparkMax blMotor = new CANSparkMax(Constants.BL, MotorType.kBrushless);
  public final CANSparkMax frMotor = new CANSparkMax(Constants.FR, MotorType.kBrushless);
  public final CANSparkMax brMotor = new CANSparkMax(Constants.BR, MotorType.kBrushless);

  //Group left and right motor controllers
  public final SpeedControllerGroup leftMotors = new SpeedControllerGroup(flMotor, blMotor);
  public final SpeedControllerGroup rightMotors = new SpeedControllerGroup(frMotor, brMotor);

  //Create a differential drive object
  public DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

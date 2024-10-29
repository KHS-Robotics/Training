// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * Examples of using motor controllers
 */
public abstract class MotorControllerExamples {
  
  /**
   * Example for a PWM Motor Controller. This example uses a Spark from RevRobotics.
   * The Spark has been discontinued in favor of the SparkMAX but still serves as a good example for PWM.
   * https://www.andymark.com/products/spark-bushed-dc-motor-controller
   */
  private void PWM_Controller_Example() {
    // Create the PWM Motor Controller using connected channel on RoboRIO
    // in this case we are using a Spark from RevRobotics
    // The Spark motor object normally consturcted inside the Subsystem the motor belongs to
    final int pwmChannel = 1;
    final Spark pwmMotorController = new Spark(pwmChannel);

    // Whether or not to negate the motor output
    // useful to be deliberate in which direction
    // you want positive and negative values to spin
    final boolean isMotorInverted = false;
    pwmMotorController.setInverted(isMotorInverted);

    // Voltage
    double halfSpeedVoltageOutput = 6.0;
    // Spin one way
    pwmMotorController.setVoltage(halfSpeedVoltageOutput);
    // Spin the other way (negative)
    pwmMotorController.setVoltage(-halfSpeedVoltageOutput);

    // Percent (less desirable than voltage control)
    double halfSpeedPercentOutput = 0.5;
    // Spin one way
    pwmMotorController.set(halfSpeedPercentOutput);
    // Spin the other way (negative)
    pwmMotorController.set(-halfSpeedPercentOutput);
  }

  /**
   * Example for a CAN Motor Controller. This example uses a Spark MAX
   * https://www.revrobotics.com/rev-11-2158/
   */
  private void CAN_SparkMax_Controller_Example() {
    // Create the PWM Motor Controller
    // in this case we are using a Spark Max by RevRobotics
    // The Spark motor object normally consturcted inside the Subsystem the motor belongs to
    final int canID = 15;
    final CANSparkMax canMotorController = new CANSparkMax(canID, MotorType.kBrushless);

    // Whether or not to negate the motor output
    // useful to be deliberate in which direction
    // you want positive and negative values to spin
    final boolean isMotorInverted = false;
    canMotorController.setInverted(isMotorInverted);

    // Voltage
    double halfSpeedVoltageOutput = 6.0;
    // Spin one way
    canMotorController.setVoltage(halfSpeedVoltageOutput);
    // Spin the other way (negative)
    canMotorController.setVoltage(-halfSpeedVoltageOutput);

    // Percent (less desirable than voltage control)
    double halfSpeedPercentOutput = 0.5;
    // Spin one way
    canMotorController.set(halfSpeedPercentOutput);
    // Spin the other way (negative)
    canMotorController.set(-halfSpeedPercentOutput);


    // PIDF Controller for Velocity and Postion control modes
    SparkPIDController pidControllerForVelocityOrPositonControl = canMotorController.getPIDController();

    // These modes requires PIDF values

    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/introduction-to-pid.html
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/pid-video.html#pid-introduction-video-by-wpi
    // The math looks harder than it really is - understanding at a conceptual level will help you understand the rigor more

    // set PIDF values - these values are somewhat empirical and change with every unique system/robot
    pidControllerForVelocityOrPositonControl.setP(1);
    pidControllerForVelocityOrPositonControl.setI(0.01);
    pidControllerForVelocityOrPositonControl.setD(0.5);
    pidControllerForVelocityOrPositonControl.setFF(1.0 / 6000.0);

    // Speed (for example: meters/second)
    double speedInUnitsPerSecond = 2;
    // Spin one way
    pidControllerForVelocityOrPositonControl.setReference(speedInUnitsPerSecond, ControlType.kVelocity);
    // Spin the other way (negative)
    pidControllerForVelocityOrPositonControl.setReference(-speedInUnitsPerSecond, ControlType.kVelocity);

    // Position (for example: meters, rotations, degrees, radians, etc)
    double position = 3;
    // Spin one way
    pidControllerForVelocityOrPositonControl.setReference(position, ControlType.kPosition);
    // Spin the other way (negative)
    pidControllerForVelocityOrPositonControl.setReference(-position, ControlType.kPosition);
  }

}

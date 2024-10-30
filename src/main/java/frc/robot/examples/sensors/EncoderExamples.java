// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples.sensors;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

/**
 * Examples of using encoders
 */
public abstract class EncoderExamples {

  /**
   * Examples for a Relative Encoder. Relative here means that the value gets erased whenever we turn off the
   * robot and turn it back on. Meaning any movement of the motor will not be detected while the robot is off.
   * Relative encoders are good in some cases such as for driving where we care more about instantaneous speeds
   * over their actual position.
   */
  private void Relative_Encoder_Example() {
    // Motor's encoder lives inside the motor
    final int canID = 10;
    final CANSparkMax motorController = new CANSparkMax(canID, MotorType.kBrushless);

    // Get encoder from the Spark MAX
    RelativeEncoder encoder = motorController.getEncoder();

    // The encoder returns number of motor revolutions
    double motorRevolutions = encoder.getPosition();

    // We need to do math to find a conversion factor that will turn motor revolutions into distance traveled
    // The unit we convert to can be whatever we want such as meters, degrees, or rotations of a hexshaft for example

    // In this example let's say the motor is for a drive wheel that is 4 inches in diameter with a 6.75:1 drive ratio
    // and we want the position to return in meters
    final double input = 1;
    final double output = 6.75;
    final double positionConversionFactor = (2 * Math.PI * Units.inchesToMeters(2) * input) / output;
    encoder.setPositionConversionFactor(positionConversionFactor);

    double positionInMeters = encoder.getPosition();

    // Velocity Conversion Factor is the same as position but divided by 60 seconds to get meters/second
    encoder.setVelocityConversionFactor(positionConversionFactor / 60.0);

    double speedInMetersPerSecond = encoder.getVelocity();
  }

  /**
   * Examples for an Absolute Encoder. Absolutes are good for anything that must always be tracked regardless
   * of what the motor is doing. They are especially useful for turrets or swerve modules where you are constantly rotating.
   * This example uses a CANCoder by CTRE
   * https://newsite.ctr-electronics.com/products/cancoder
   */
  private void Absolute_Encoder_Examples() {
    // Absolute encoder - uses a magnet to always know the current position
    final int canID = 20;
    CANcoder absoluteEncoder = new CANcoder(canID);

    // Conversion Factor is set in Phoenix Tuner X (same concept as a relative encoder)
    // https://v6.docs.ctr-electronics.com/en/stable/docs/tuner/index.html
    double position = absoluteEncoder.getPosition().getValueAsDouble();
  }

}

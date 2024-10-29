// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples;

import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Ultrasonic sensor examples.
 */
public final class UltrasonicExamples {
  
  /*
   * Example Ultrasonic Sensor: https://kb.vex.com/hc/en-us/articles/360038608771-Using-the-V5-3-Wire-UltraSonic-Range-Finder
   */
  private void Ultrasonic_Distance_Example() {
    // Create sensor using an input and output channel on the RoboRIO
    final int pingChannel = 1;
    final int echoChannel = 2;
    final Ultrasonic ultrasonic = new Ultrasonic(pingChannel, echoChannel);

    // Supports range in both inches and mm
    double distanceToObjectInInches = ultrasonic.getRangeInches();
    double distanceToObjectInMillimeters = ultrasonic.getRangeMM();
  }

}

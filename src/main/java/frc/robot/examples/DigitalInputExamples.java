// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Examples of using digital inputs.
 */
public abstract class DigitalInputExamples {
  
  /**
   * Digital Inputs detect a true or false value.
   * They can be limit switches to determine when a motor has reached the end of "its track".
   * They can also be photosensors to detect when an object is inside the robot or intake.
   */
  private void DigitalInput_Example() {
    // Create DigitalInput using digital input channel on RoboRIO - these are simple sensors that just return true or false
    final int channelOnRoboRio = 1;
    final DigitalInput sensor = new DigitalInput(channelOnRoboRio);

    // Get if the sensor is tripped or pressed
    boolean isTripped = sensor.get();
  }

}

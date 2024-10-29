// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Pneumatics examples. Pneumatics uses air with a compressor and air tank(s) on the robot to perform actions.
 */
public abstract class PneumaticsExamples {
  
  /*
   * Solenoids can be used to controller pneumatic cylinders are set to true or false
   */
  private void Solenoid_Example() {
    // Pneumatics can be used to extend and retract, or to grab and release for example
    final int digialChannelOnRoboRio = 2;
    final Solenoid piston = new Solenoid(PneumaticsModuleType.REVPH, digialChannelOnRoboRio);

    // Extend or Grip
    piston.set(true);

    // Retract or Open
    piston.set(false);
  }

  /*
   * Sometimes solenoids are dual action and have 3 potential values
   * Forward, Reverse, Off
   */
  private void DoubleSolenoid_Example() {
    final int forwardChannelOnRoboRio = 2;
    final int reverseChannelOnRoboRio = 2;
    final DoubleSolenoid piston = new DoubleSolenoid(PneumaticsModuleType.REVPH, forwardChannelOnRoboRio, reverseChannelOnRoboRio);

    // Extend
    piston.set(Value.kForward);

    // Retract
    piston.set(Value.kReverse);

    // Shortly after setting Forward or Reverse, turn off to prevent unnecessary current flowing through the solenoid.
    // Usually this can be done by setting the desired value, waiting half a second then turning off the solenoid
    piston.set(Value.kOff);
  }

}

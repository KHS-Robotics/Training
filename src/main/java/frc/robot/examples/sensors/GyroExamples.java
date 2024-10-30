// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples.sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * Used to get the robot orientation in 3-dimensional space. Examples are using the NavX gyro.
 * https://pdocs.kauailabs.com/navx-mxp/
 */
public abstract class GyroExamples {

  /**
   * https://simple.wikipedia.org/wiki/Pitch,_yaw,_and_roll
   */
  private void NavX_GetRobotAngles_Example() {
    // Robot has One NavX usually either connected via MXP or USB on the RoboRIO
    // AHRS = Attitude and Heading Reference System
    // final Port navxPort = Port.kUSB;
    final Port navxPort = Port.kMXP;
    final AHRS navx = new AHRS(navxPort);

    // robot's angle in degrees
    // -360 degrees is the same as 0 degrees is the same as 360 degreees
    // -540 degrees is the same as -180 degrees is the same as 180 degrees is the same as 540 degrees
    // and so on...
    double robotAngle = navx.getAngle();

    // Yaw, Roll, Pitch always return (-180, 180]
    // that is, as low as -179.99 degrees and as high as 180.0 degrees
    double yaw = navx.getYaw();
    double roll = navx.getRoll();
    double pitch = navx.getPitch();

    // robot heading rate of change in degrees/second
    double robotAngleRateOfChange = navx.getRate();
  }

}

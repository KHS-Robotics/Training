// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples.hid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * Joystick examples.
 * HID = Human Interface Device (like a joystick)
 */
public abstract class JoystickExamples {
  // Get joystick using Port Number on Driver Station
  final int PortNumberOnDriverStation = 0;
  final Joystick joystick = new Joystick(PortNumberOnDriverStation);

  /**
   * Buttons - get if a specific button is currently pressed
   */
  private void Joystick_GetButtonPress_Example() {
    // Buttons start at 1 and not 0
    boolean isPressingButton1 = joystick.getRawButton(1);
    boolean isPressingButton8 = joystick.getRawButton(8);
  }

  /**
   * Joystick Axis - X, Y, Z
   */
  private void Joystick_GetAxis_Example() {
    // left/right
    // left is negative
    // right is positive
    // sometimes we negative this depending on the use case
    double xInput = joystick.getX();

    // forwards/backwards
    // forwards is negative
    // backwards in postive
    // very common we negate this in our code
    double yInput = joystick.getY();

    // some joysticks twist too
    // clockwise postive usually
    // counter-clockwise negative usually
    double zInput = joystick.getZ();
  }

  /**
   * CommandXboxController by WPILib
   */
  private void XboxController_CommandBased_Example() {
    // WPILib offers an XboxController class for simplicity
    final int PortNumberOnDriverStationForXbox = 1;
    final CommandXboxController cmdXboxController = new CommandXboxController(PortNumberOnDriverStationForXbox);

    // Buttons to trigger commmands
    cmdXboxController.y().onTrue(Commands.print("'Y' button was pressed!"));
    cmdXboxController.b().onTrue(Commands.print("'B' button was pressed!"));
    cmdXboxController.a().onTrue(Commands.print("'A' button was pressed!"));
    cmdXboxController.x().onTrue(Commands.print("'X' button was pressed!"));
    cmdXboxController.start().onTrue(Commands.print("'Start' button was pressed!"));
    cmdXboxController.back().onTrue(Commands.print("'Back' button was pressed!"));
    cmdXboxController.rightStick().onTrue(Commands.print("'Right Stick' was pressed!"));
    cmdXboxController.leftStick().onTrue(Commands.print("'Left Stick' was pressed!"));
    cmdXboxController.rightBumper().onTrue(Commands.print("'Right Bumper' was pressed!"));
    cmdXboxController.leftBumper().onTrue(Commands.print("'Left Bumper' was pressed!"));

    // You can get the underlying XboxController for it using getHID()
    final XboxController xboxController = cmdXboxController.getHID();

    // Buttons
    boolean isYPressed = xboxController.getYButton();
    boolean isBPressed = xboxController.getBButton();
    boolean isAPressed = xboxController.getAButton();
    boolean isXPressed = xboxController.getXButton();
    boolean isStartPressed = xboxController.getStartButton();
    boolean isBackPressed = xboxController.getBackButton();
    boolean isRightStickPressed = xboxController.getRightStickButton();
    boolean isLeftStickPressed = xboxController.getLeftStickButton();
    boolean isRightBumperPressed = xboxController.getRightBumper();
    boolean isLeftBumperPressed = xboxController.getLeftBumper();

    // Triggers
    // left ranges from [0, 1]
    // right ranges from [0, 1]
    double leftTriggerValue = xboxController.getLeftTriggerAxis();
    double rightTriggerValue = xboxController.getRightTriggerAxis();

    // D-Pad
    // The POV angles start at 0 in the up direction, and increase clockwise (e.g. right is 90, upper-left is 315).
    // Returns -1 if the POV is not pressed.
    double pov = xboxController.getPOV();
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.examples.telemetry;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** 
 * Examples for logging data in your code to Smart Dashboard.
 * This allows you to view variables on the Driver Station in real time.
 */
public abstract class SmartDashboardExamples {

  /**
   * You can put data to the Smart Dashboard in your code. Each variable you put needs to have
   * a unique key to go with it. The unique key is a string. This key is the name of the variable
   * so you can find it on the dashbord on the Driver Station laptop. This also works in the simulator.
   */
  private void SmartDashboard_PutData_Example() {
    // You can put numbers, booleans, and strings

    // numbers (int, double, float, etc)
    double someNumberInYourCode = 4342;
    SmartDashboard.putNumber("", someNumberInYourCode);

    // booleans (true or false)
    boolean someBooleanInYourCode = true;
    SmartDashboard.putBoolean("", someBooleanInYourCode);

    // strings
    String someStringInYourCode = "SomeString";
    SmartDashboard.putString("", someStringInYourCode);


    // You can put arrays to the dashboard as well

    // array of numbers (int[], double[], float[], etc)
    double[] someArrayOfNumbersInYourCode = { 1, 2, 3 };
    SmartDashboard.putNumberArray("", someArrayOfNumbersInYourCode);

    // array of booleans
    boolean[] someArrayOfBooleansInYourCode = { true, false, true };
    SmartDashboard.putBooleanArray("", someArrayOfBooleansInYourCode);

    // array of strings
    String[] someArrayOfStringsInYourCode = { "ABC", "DEF", "GHI" };
    SmartDashboard.putStringArray("", someArrayOfStringsInYourCode);
  }

  /**
   * You can also get data from the Smart Dashboard. You can change the variable on the Driver Station laptop
   * and the variable in the code will update in real time. This can be useful in certain situations.
   */
  private void SmartDashboard_GetData_Example() {
    // Put empty data to start with so there is a value on the Driver Station dashboard to change
    SmartDashboard.putNumber("ChangeMe!", 1);

    // Once on the dashboard it will show up and can be retrieved at any point.
    // If the key does not exist meaning we never put it there in the first place, then return a default value.
    double defaultValue = 0;
    double currentValue = SmartDashboard.getNumber("ChangeMe!", defaultValue);

    // Keep in mind that if you set the variable in the code it will update on the laptop too.
    // The data is "bi-directional" meaning the code can change it and so can the Dashboard on the Driver Station
    double someNewValue = 4342;
    SmartDashboard.putNumber("ChangeMe!", someNewValue);
    // updatedValue is now 4342
    double updatedValue = SmartDashboard.getNumber("ChangeMe!", defaultValue);
    

    // The same principles apply for booleans, strings, and all their array counterparts
  }

}

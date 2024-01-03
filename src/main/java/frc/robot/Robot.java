// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a sample program demonstrating how to read from a ping-response ultrasonic sensor with
 * the {@link Ultrasonic class}.
 */
public class Robot extends TimedRobot {
  // Creates a ping-response Ultrasonic object on DIO 1 and 2.
  DigitalInput beamBreak = new DigitalInput(0);

  @Override
  public void robotInit() {
    // Add the ultrasonic on the "Sensors" tab of the dashboard
    // Data will update automatically
    Shuffleboard.getTab("Sensors").add(beamBreak);
  }

  @Override
  public void teleopPeriodic() {
    // We can read the distance in millimeters
    beamBreak.get();
    // ... or in inches
    
    // We can also publish the data itself periodically
    SmartDashboard.putBoolean("beamBreak", beamBreak.get());
    System.out.println("Beam Break: " + Boolean.toString(beamBreak.get()));
  }

  @Override
  public void testInit() {
    // By default, the Ultrasonic class polls all ultrasonic sensors in a round-robin to prevent
    // them from interfering from one another.
    // However, manual polling is also possible -- note that this disables automatic mode!
  }

  @Override
  public void testPeriodic() {
    
  }

  @Override
  public void testExit() {
    // Enable automatic modea
  }
}

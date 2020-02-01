/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Solenoid;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
   
  double speed = 0.1;
  /*
  TalonSRX leftFrontMotor  = new TalonSRX(2);
  TalonSRX rightFrontMotor  = new TalonSRX(3);
  TalonSRX leftBackMotor  = new TalonSRX(1);
  TalonSRX rightBackMotor  = new TalonSRX(4);
  */
  TalonSRX LeftMotors  = new TalonSRX(1);
  TalonSRX RightMotors  = new TalonSRX(3);
  Joystick joystick1 = new Joystick(0);
  Joystick joystick = new Joystick(1);


  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  public void robotInit() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    
    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    
    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    
   
  }
 

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
 
    
     double rightMotorSide = joystick1.getRawAxis(1);


    double leftMotorSide =  -joystick.getRawAxis(1);

    LeftMotors.set(ControlMode.PercentOutput,leftMotorSide);
    RightMotors.set(ControlMode.PercentOutput,rightMotorSide);



  
}
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }


}

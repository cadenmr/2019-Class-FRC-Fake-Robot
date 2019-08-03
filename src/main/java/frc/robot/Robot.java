/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.autonomous.Mission;
import frc.autonomous2019.commands.CommandFactory2019;
import frc.misc2019.EnhancedJoystick;
import frc.misc2019.Gamepad;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private boolean arm3ExtenderState = false;
  private boolean arm3ButtonPressed = false;

  private EnhancedJoystick leftJoystick;
  private EnhancedJoystick rightJoystick;

  private DriveBase driveBase;

  private Arm1 arm1;
  private Arm2 arm2;
  private Arm3 arm3;
  private Arm4 arm4;

  private boolean arm1ButtonPressed = false;
  private boolean arm2tog = false;
  private boolean arm4ButtonPressed = false;

  private CommandFactory2019 commandFactory;

  private Mission doNothingMission;
  private Mission driveForwardMission;
  private Mission mission3;

  private Mission activeMission;
  private SendableChooser<Mission> missionChooser;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    driveBase = new DriveBase(0, 1, 4, 5);

    leftJoystick = new EnhancedJoystick(0);
    rightJoystick = new EnhancedJoystick(1);

    arm1 = new Arm1(2, 0, 1);
    arm2 = new Arm2(3, 1, 2);
    arm3 = new Arm3(4, 2, 0);
    arm4 = new Arm4(5, 3, 3);

    commandFactory = new CommandFactory2019(driveBase, arm1, arm2, arm3);

    doNothingMission = new Mission("Do Nothing");
    driveForwardMission = new Mission("Drive Forward", commandFactory.moveStraight(2, 0.1, true));
    mission3 = new Mission("Mission 3", commandFactory.moveStraight(2, 0.1, true), commandFactory.delay(1),
        commandFactory.moveStraight(2, 0.1, true));

    missionChooser = new SendableChooser<Mission>();
    missionChooser.setDefaultOption(doNothingMission.getName(), doNothingMission);
    missionChooser.addOption(driveForwardMission.getName(), driveForwardMission);
    missionChooser.addOption(mission3.getName(), mission3);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    doNothingMission = new Mission("Do Nothing");
    driveForwardMission = new Mission("Drive Forward", commandFactory.moveStraight(2, 0.1, true));
    mission3 = new Mission("Mission 3", commandFactory.moveStraight(2, 0.1, true), commandFactory.delay(1),
        commandFactory.moveStraight(2, 0.1, true));

    activeMission = missionChooser.getSelected();

    if (activeMission != null) {
      activeMission.reset();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    if (activeMission != null) {
      if (activeMission.run()) {
        System.out.println("Mission '" + activeMission.getName() + "' Complete");
        activeMission = null;
      }
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    driveBase.drive(leftJoystick.getY(), rightJoystick.getY());

    if (leftJoystick.getTrigger() && !arm1.getLimitSwitch()) {
      arm1.setRotator(1);
    } else {
      arm1.setRotator(0);
    }

    if (rightJoystick.getTrigger() && !arm1ButtonPressed) {
      arm1.changeExtenderState();
    }
    arm1ButtonPressed = rightJoystick.getTrigger();
    arm1.setExtender(rightJoystick.getTrigger());

    if (rightJoystick.getRawButton(3) && !arm3ButtonPressed) {
      arm3ExtenderState = !arm3ExtenderState;
    }

    arm3ButtonPressed = rightJoystick.getRawButton(3);

    arm3.setExtender(arm3ExtenderState);

    if (leftJoystick.getRawButton(3)) {
      if (arm3.getLimitSwitch()) {
        arm3.setRotator(0);
      } else {
        arm3.setRotator(1);
      }
    } else {
      arm3.setRotator(0);
    }

    if (leftJoystick.getRawButton(2) && !arm2.getlimitSwitch()) {
      arm2.setRotator(1);
    } else {
      arm2.setRotator(0);
    }

    arm2.setExtender(leftJoystick.getRawButton(2));

    if (leftJoystick.getRawButton(2) && leftJoystick.getTrigger() != arm2tog) {
      arm2tog = !arm2tog;
    }

    arm2.setExtender(arm2tog);

    if (leftJoystick.getTrigger() && !arm4.getLimitSwitch()) {
      arm4.setRotator(1);
    } else {
      arm1.setRotator(0);
    }

    if (rightJoystick.getTrigger() && !arm4ButtonPressed) {
      arm4.changeExtenderState();
    }
    arm1ButtonPressed = rightJoystick.getTrigger();
    arm4.setExtender(rightJoystick.getTrigger());
  }
}

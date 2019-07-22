package frc.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class DriveBase {
    private final VictorSP leftDrive;
    private final VictorSP rightDrive;

    public DriveBase(int leftDrivePort, int rightDrivePort) {
        leftDrive = new VictorSP(leftDrivePort);
        rightDrive = new VictorSP(rightDrivePort);
    }

    public void drive(double leftPower, double rightPower) {
        leftDrive.set(leftPower);
        rightDrive.set(rightPower);
    }

    public void drive(double power) {
        drive(power, power);
    }
}
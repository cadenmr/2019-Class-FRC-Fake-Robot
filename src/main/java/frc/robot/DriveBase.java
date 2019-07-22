package frc.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class DriveBase
{
    private final VictorSP leftDrive, rightDrive;

    public DriveBase(int leftDrivePort, int rightDrivePort)
    {
        leftDrive = new VictorSP(leftDrivePort);
        rightDrive = new VictorSP(rightDrivePort);
    }

    public void drive(double leftSpeed, double rightSpeed)
    {
        leftDrive.set(leftSpeed);
        rightDrive.set(rightSpeed);
    }
    
    public void drive(double power)
    {
        drive(power, power);
    }
}
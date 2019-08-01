package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveBase {
    private final VictorSP leftDrive;
    private final VictorSP rightDrive;

    private final Encoder encoder;

    public DriveBase(int leftDrivePort, int rightDrivePort, int encoderPortA, int encoderPortB) {
        leftDrive = new VictorSP(leftDrivePort);
        rightDrive = new VictorSP(rightDrivePort);

        encoder = new Encoder(encoderPortA, encoderPortB);

        encoder.setDistancePerPulse((4 * Math.PI) / 1024);
    }

    public void drive(double leftPower, double rightPower) {
        leftDrive.set(-leftPower);
        rightDrive.set(rightPower);
    }

    public void drive(double power) {
        drive(power, power);
    }

    public double getDistance() {
        return encoder.getDistance();
    }

    public double getSpeed() {
        return encoder.getRate();
    }

    public void resetEncoder() {
        encoder.reset();
    }
}
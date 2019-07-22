package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm1 {
    private final VictorSP rotator;
    private final Solenoid extender;

    public Arm1(int rotatorPort, int extenderPort) {
        rotator = new VictorSP(rotatorPort);
        extender = new Solenoid(extenderPort);
    }

    public void setRotator(double power) {
        rotator.set(power);
    }

    public void setExtender(boolean out) {
        extender.set(out);
    }
}
package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm4 {
    private final VictorSP rotator;
    private final Solenoid extender;
    private boolean extenderState;

    public Arm4(int rotatorPort, int extenderPort) {
        rotator = new VictorSP(rotatorPort);
        extender = new Solenoid(extenderPort);
        extenderState = false;
    }

    public void setRotator(double power) {
        rotator.set(power);
    }

    public void setExtender(boolean out) {
        extender.set(out);
        extenderState = out;
    }

    public void changeExtenderState() {
        setExtender(!extenderState);
    }
}
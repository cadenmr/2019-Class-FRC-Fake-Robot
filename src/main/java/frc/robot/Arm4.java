package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;;

public class Arm4 {
    private final VictorSP rotator;
    private final Solenoid extender;
    private final DigitalInput limitSwitch;

    private boolean extenderState;

    public Arm4(int rotatorPort, int extenderPort, int limitSwitchPort) {
        rotator = new VictorSP(rotatorPort);
        extender = new Solenoid(extenderPort);
        limitSwitch = new DigitalInput(limitSwitchPort);

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

    public boolean getLimitSwitch() {
        return !limitSwitch.get();
    }
}
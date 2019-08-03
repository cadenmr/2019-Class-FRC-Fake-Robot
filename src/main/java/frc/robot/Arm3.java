package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm3 {
    private final VictorSP rotator;
    private final Solenoid extender;
    private final DigitalInput limitSwitch;

    private boolean extenderState;

    public Arm3(int rotatorPort, int extenderPort, int limitSwitchPort) {
        rotator = new VictorSP(rotatorPort);
        extender = new Solenoid(extenderPort);
        limitSwitch = new DigitalInput(limitSwitchPort);

        extenderState = false;
    }

    public void setExtender(boolean out) {
        extender.set(out);
        extenderState = out;
    }

    public void changeExtenderState() {
        setExtender(!extenderState);
    }

    public void setRotator(double speed) {
        rotator.set(speed);
    }

    public boolean getLimitSwitch() {
        return limitSwitch.get();
    }
}
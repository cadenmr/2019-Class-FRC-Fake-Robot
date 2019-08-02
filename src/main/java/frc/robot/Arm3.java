package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm3 {
    private final VictorSP rotator;
    private final Solenoid extender;
    private final DigitalInput limitSwitch;

    private boolean extenderState;

    public Arm3(int rotatorChannel, int extenderChannel, int limitSwitchChannel) {
        rotator = new VictorSP(rotatorChannel);
        extender = new Solenoid(extenderChannel);
        limitSwitch = new DigitalInput(limitSwitchChannel);

        extenderState = false;
    }

    public void setExtender(boolean state) {
        extender.set(state);
        extenderState = state;
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
package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm3 {
    private final VictorSP rotator;
    private final Solenoid extender;
    private final DigitalInput limitSwitch;

    public Arm3(int rotatorChannel, int extenderChannel, int limitSwitchChannel) {
        rotator = new VictorSP(rotatorChannel);
        extender = new Solenoid(extenderChannel);
        limitSwitch = new DigitalInput(limitSwitchChannel);
    }

    public void setExtender(boolean state) {
        extender.set(state);
    }

    public void setRotator(double speed) {
        rotator.set(speed);
    }

    public boolean getLimitSwitch() {
        return limitSwitch.get();
    }
}
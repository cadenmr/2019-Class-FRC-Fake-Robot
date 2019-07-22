package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm3 {
    private final VictorSP rotator;
    private final Solenoid extender;

    public Arm3(int rotatorChannel, int extenderChannel) {
        rotator = new VictorSP(rotatorChannel);
        extender = new Solenoid(extenderChannel);
    }

    public void setExtender(boolean state) {
        extender.set(state);
    }

    public void setRotator(double speed) {
        rotator.set(speed);
    }
}
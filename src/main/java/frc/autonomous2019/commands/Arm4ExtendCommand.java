package frc.autonomous2019.commands;

import frc.autonomous.Command;
import frc.robot.Arm4;
import edu.wpi.first.wpilibj.Timer;

public class Arm4ExtendCommand implements Command {

    boolean extend;
    Arm4 arm4;

    public Arm4ExtendCommand(boolean extend, Arm4 arm4) {
        this.extend = extend;
        this.arm4 = arm4;
    }

    @Override
    public boolean run() {
        arm4.setExtender(extend);   
        return true;
    }

    @Override
    public void reset() {
    }

}

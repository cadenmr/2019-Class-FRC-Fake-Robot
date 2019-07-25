package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm2
{
    private final VictorSP rotator;
    private final Solenoid extender;

    private DigitalInput limitSwitch;

    public Arm2(int rotatorPort, int extenderPort, int limitSwitchPort)
    {
        rotator = new VictorSP(rotatorPort);
        extender = new Solenoid(extenderPort);

        limitSwitch = new DigitalInput(limitSwitchPort);
    }

    public void setRotator(double power)
    {
        rotator.set(power);

    }
    
    public void setExtender(boolean out)
    {
        extender.set(out);
    }

    public boolean getlimitSwitch()
    {
        return limitSwitch.get();
    }
}
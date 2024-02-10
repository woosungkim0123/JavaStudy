package command.normal;

import command.common.Alarm;
import command.common.Lamp;

public class ButtonV3 {

    private Lamp theLamp;
    private Alarm theAlarm;
    private Mode theMode;

    public ButtonV3(Lamp theLamp, Alarm theAlarm) {
        this.theLamp = theLamp;
        this.theAlarm = theAlarm;
    }

    public void setMode(Mode theMode) {
        this.theMode = theMode;
    }

    public void pressed() {
        switch (theMode) {
            case LAMP:
                theLamp.turnOn();
                break;
            case ALARM:
                theAlarm.start();
                break;
        }
    }
}

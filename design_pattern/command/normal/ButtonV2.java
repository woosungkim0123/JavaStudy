package command.normal;

import command.common.Alarm;

public class ButtonV2 {

    private Alarm alarm;

    public ButtonV2(Alarm alarm) {
        this.alarm = alarm;
    }

    public void pressed() {
        alarm.start();
        System.out.println();
    }
}

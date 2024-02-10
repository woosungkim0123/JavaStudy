package command.normal;

import command.common.Lamp;

public class ButtonV1 {
    private Lamp theLamp;

    public ButtonV1(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    public void pressed() {
        theLamp.turnOn();
        System.out.println();
    }
}

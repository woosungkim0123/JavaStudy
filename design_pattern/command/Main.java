package command;

import command.common.Alarm;
import command.common.Lamp;
import command.normal.*;
import command.sub.AlarmOnCommand;
import command.sub.Button;
import command.sub.LampOnCommand;

public class Main {
    public static void main(String[] args) {

        /**
         * Command 패턴 적용 전
         * - 여기서 적용된 ButtonV1, ButtonV2, ButtonV3는 기능을 변경한 버전별로 나뉘어있는 것입니다.
         */
        Lamp lamp = new Lamp();
        ButtonV1 buttonV1 = new ButtonV1(lamp);
        buttonV1.pressed();

        /**
         * 다른 기능으로 변경
         * - 버튼을 눌렀을 때 알람이 시작되도록 변경
         * - 새로운 기능으로 변경하려고 하면 기존 코드(ButtonV1 클래스)를 수정해야 한다. (OCP 위반)
         *
         * 1. Alarm 클래스를 만든다.
         * 2. ButtonV1 클래스를 수정하여 Alarm 클래스를 사용하도록 수정한다.
         */
        Alarm alarm = new Alarm();
        ButtonV2 buttonV2 = new ButtonV2(alarm); // ButtonV2는 ButtonV1에서 Alarm을 사용하도록 수정한 버전
        buttonV2.pressed();

        /**
         * 버튼을 누르는 동작에 따라 다른 기능을 수행하도록 변경하려면
         * 한번 누르면 램프가 켜지고, 두번 누르면 알람이 울리도록 변경하려면?
         */
        ButtonV3 buttonV3 = new ButtonV3(lamp, alarm); // ButtonV3는 수정한 버전
        buttonV3.setMode(Mode.LAMP);
        buttonV3.pressed();

        buttonV3.setMode(Mode.ALARM);
        buttonV3.pressed();
        System.out.println();

        // 정리
        // - 필요한 기능을 새로 추가할 때 마다 기존 코드를 수정해야 한다. (Button 클래스의 코드를 수정해야 하므로 재사용하기 어렵다.)

        /**
         * Command 패턴 적용 후
         * - 구체적인 기능을 직접 구현하는 대신 실행될 기능을 캡슐화 해야 합니다.
         * - Button 클래스의 pressed 메서드에서 구체적인 기능을 직접 구현하지 않고 실행될 때(버튼을 눌렀을 때) 실행될 기능을 외부에서 제공받아 캡슐화해 메서드에서 호출합니다.
         */
        System.out.println("==Command 패턴 적용 후==");
        LampOnCommand lampOnCommand = new LampOnCommand(lamp);

        Button button1 = new Button(lampOnCommand);
        button1.pressed();
        System.out.println();

        /**
         * 다른 기능으로 변경
         * 1. Alarm 클래스를 만든다.
         * 2. AlarmOnCommand 클래스를 만든다.
         * 3. Button 클래스 사용시 인자로 AlarmOnCommand 객체를 전달한다.
         */
        AlarmOnCommand alarmOnCommand = new AlarmOnCommand(alarm);
        Button button2 = new Button(alarmOnCommand);
        button2.pressed();
    }
}

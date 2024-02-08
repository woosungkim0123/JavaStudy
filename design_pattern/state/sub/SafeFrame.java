package state.sub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI를 사용한 금고 경비 시스템을 표현한 클래스
 */
public class SafeFrame extends Frame implements Context, ActionListener {
    private TextField textClock = new TextField(60); // 현재시각 표시
    private TextArea textScreen = new TextArea(10, 60); // 경비센터 출력
    private Button buttonUse = new Button("use safe"); // 금고사용 버튼
    private Button buttonAlarm = new Button("emergency bell"); // 비상벨 버튼
    private Button buttonPhone = new Button("phone"); // 일반통화 버튼
    private Button buttonExit = new Button("exit"); // 종료 버튼

    private State state = DayState.getInstance(); // 현재의 상태

    public SafeFrame(String title) {
        super(title);

        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock을 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen을 배치
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼을 넣는다.
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치
        add(panel, BorderLayout.SOUTH);
        // 표시
        pack();
        show();
        // 리스너의 설정
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void setClock(int hour) {
        String clockstring = String.format("현재시각: %02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
}

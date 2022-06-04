import javax.swing.*;   
import java.awt.Dimension;
import java.awt.Toolkit;
public class HelloWorldGuiApp{
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("여긴 제목");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // frame 크기 지정
                frame.setPreferredSize(new Dimension(400, 400));
                // 만든 창을 Frame에 넣어줌
                JLabel label = new JLabel("UI가 생겼네? 하하", SwingConstants.CENTER);
                frame.getContentPane().add(label);
                // 윈도우 중앙에 위치 시켜주는 코드 같음
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width/2-400/2, dim.height/2-400/2);

                frame.pack();
                // 보이게
                frame.setVisible(true);
            }
        });
    }
}


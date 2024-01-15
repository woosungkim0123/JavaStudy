public class For {
    public static void main(String[] args) {
        // 이중 반복문 한번에 break
        Loop1: for(int i=2; i < 9; i++){
            for(int j = 1; j <= 9; j++) {
                if (j == 3) break Loop1; // Loop1로 이름 지은 반복문 break;
                // continue Loop1 가능
            }
        }
    }
}

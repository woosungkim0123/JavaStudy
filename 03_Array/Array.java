public class Array {
    public static void main(String[] args) {
        int[] score = new int[5]; // 5개의 원소를 가진 배열 생성
        score[3] = 100;
        System.out.println("score 2 : " + score[2]); // 0
        System.out.println("score 3 : " + score[3]); // 100
        int tmp = score.length; // 배열의 길이(int 상수)
        System.out.println(tmp);

        // 배열은 한번 생성하면 실행동안 길이를 변경할 수 없다.
        // 5개의 원소를 가진 배열을 생성하면 int(4byte) * 5 = 20byte, 20byte 메모리 공간이 필요
        // 배열은 연속적, 즉 20byte 메모리 공간을 찾게된다
        // 배열을 늘리게 되면 메모리 공간이 더 필요하게 되는데 배열은 연속적이니 뒤쪽으로 더 공간이 필요
        // 그러나 20byte 공간 뒤에 메모리가 비어있다는 보장이 없음
        // 공간이 부족하면? 새로운 큰 배열을 만들고 기존 배열 내용을 복사

        // 배열 초기화
        int[] test = {50, 60, 70, 80, 90};

        // 선언과 초기화를 나눠야 할 때 (사용 빈도 낮음)
        int[] test2;
        test2 = new int[]{50, 60, 70, 80, 90};
    }
}

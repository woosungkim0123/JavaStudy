import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] score = new int[5]; // 5개의 원소를 가진 배열 생성
        score[3] = 100;
        System.out.println("score 2 : " + score[2]); // 0
        System.out.println("score 3 : " + score[3]); // 100
        int tmp = score.length; // 배열의 길이(int 상수)
        System.out.println("score length : " + tmp);

        for (int i=0; i < score.length; i++) {
            System.out.println("arr[" + i + "]=" + score[i]);
        }

        // 배열은 한번 생성하면 실행동안 길이를 변경할 수 없다.
        // 5개의 원소를 가진 배열을 생성하면 int(4byte) * 5 = 20byte, 20byte 메모리 공간이 필요
        // 배열은 연속적, 즉 20byte 메모리 공간을 찾게된다
        // 배열을 늘리게 되면 메모리 공간이 더 필요하게 되는데 배열은 연속적이니 뒤쪽으로 더 공간이 필요
        // 그러나 20byte 공간 뒤에 메모리가 비어있다는 보장이 없음
        // 공간이 부족하면? 새로운 큰 배열을 만들고 기존 배열 내용을 복사

        // 배열 초기화
        // 배열은 기본적으로 자동 초기화가 됨(int는 0)
        int[] a = {50, 60, 70, 80, 90};

        // 선언과 초기화를 나눠야 할 때 (사용 빈도 낮음)
        int[] b;
        b = new int[]{50, 60, 70, 80, 90};

        // 배열 출력
        int [] c = { 100, 95, 80, 70, 60 };
        System.out.println(c); // [I@735f7ae5
        // [ : 배열, I : int 타입, @ : 위치, 숫자 : 주소(정확하게 주소는 아닌데)

        // char 배열은 출력시 내용이 출력됨
        char [] d = {'a', 'b', 'c', 'd'};
        System.out.println(d);

        // 배열의 모든 요소를 출력하려면 for 문을 써야함
        for (int i=0; i < c.length; i++) {
            System.out.println("arr[" + i + "]=" + c[i]);
        }
        // 편한 방법
        // 배열의 내용을 문자열로 만들어서 반환(toString), println은 문자열을 출력할 뿐
        System.out.println(Arrays.toString(c));

        // 배열에 랜덤값 넣기
        int[] iArr1 = new int[10];
        for (int i = 0; i < iArr1.length; i++){
            iArr1[i] = (int)(Math.random()*10) + 1;
        }
        System.out.println(Arrays.toString(iArr1));



    }
}

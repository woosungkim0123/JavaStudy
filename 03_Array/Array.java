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

        // String 배열 : 참조형
        // 참조형의 기본값은 null
        // 참조형이라서 값이 들어가는 것이 아니라 문자열이 만들어지고 그 주소가 들어가는 것것
        String [] name = { "Kim", "Park", "Yi" };

        // String(문자열) 클래스
        // String 클래스 = char[] + 메서드(기능)
        // String 클래스는 내용을 변경할 수 없다 (읽기만 가능)
        String e = "a";
        String f = "b";
        e = e + f;
        // 문자열 e가 바뀌는 것 같지만 그렇지 않고 문자열 "ab"가 새로 만들어지고 e 참조변수에 주소가 저장됨
        System.out.println(e);

        // String 클래스 메서드
        // charAt
        String str = "ABCD";
        char ch = str.charAt(3);
        System.out.println(ch); // D

        // length
        System.out.println(str.length()); // 4

        // substring
        // 문자열의 일부를 뽑아냄, 마지막 인덱스는 포함안됨
        System.out.println(str.substring(1,4));

        // equals
        System.out.println(str.equals("ABCD"));

        // toCharArray
        System.out.println(str.toCharArray()); // String => char[]로 변경할 때

        // 2차원 배열
        int[][] twoArray = new int[4][3];

        // 2차원 배열 초기화
        int[][] twoArray1 = {
                                {1, 2, 3},
                                {4, 5, 6}
                            };

        // Arrays(클래스)로 배열 다루기
        int[][] arr2D = {{11, 12}, {21,22}};
        System.out.println(Arrays.deepToString((arr2D))); // [[11, 12], [21, 22]]

        // 이차원 배열 같은지 확인
        String[][] str2D = new String[][]{{"abc", "bcd"}, {"cde", "def"}};
        String[][] str2D2 = new String[][]{{"abc", "bcd"}, {"cde", "def"}};
        System.out.println(Arrays.equals(str2D, str2D2)); // false
        System.out.println(Arrays.deepEquals(str2D, str2D2)); // true

        // 배열 복사
        // copyOf, copyOfRange
        int[] arrT1 = {0,1,2,3,4};
        int[] arrT2 = Arrays.copyOf(arrT1, arrT1.length); // [0, 1, 2, 3, 4]
        int[] arrT3 = Arrays.copyOf(arrT1, 3); // [0, 1, 2]
        int[] arrT4 = Arrays.copyOf(arrT1, 7); // [0, 1, 2, 3, 4, 0, 0]
        int[] arrT5 = Arrays.copyOfRange(arrT1, 2,4); // [2, 3]

        // sort : 정렬

        int[] arrT6 = {3,2,0,1,4};
        Arrays.sort(arrT6); // 오름차순 정렬

    }
}

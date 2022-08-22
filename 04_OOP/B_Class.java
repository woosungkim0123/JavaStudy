public class B_Class {
    public static void main(String[] args) {
        /*
        클래스의 정의
        클래스 == 데이터 + 함수, 사용자 정의 타입, 설계도

        변수 : 하나의 데이터를 저장할 수 있는 공간
        배열 : 같은 종류의 여러 데이터를 하나로 저장할 수 있는 공간
        구조체 : 서로 관련된 여러 데이터(종류 관계X)를 하나로 저장할 수 있는 공간
        클래스 : 데이터와 함수의 결합(구조체 + 함수)

        사용자 정의 타입? 우리가 정의한 타입. 원하는 타입을 직접 만들 수 있다 => 그 타입이 바로 클래스
        시간을 다루는 타입이 없어서 새로 만든다는 가정 => 기본형 8개 (원래는 자바에 시간을 다루기 위한 클래스가 있음)
        */
        // 비객체지향적 코드
        int hour;
        int minute;
        int second;
        // 만약 3개의 시간을 다루려면?
        int hour1, hour2, hour3;
        int minute1, minute2, minute3;
        int second1, second2, second3;
        // 더 많은 시간을 다루려면? 배열 사용
        // 문제는 시, 분, 초가 하나의 시간인데 각각 시간, 분, 초로 따로 묶여있음
        int[] hourArr = new int[3];
        int[] minuteArr = new int[3];
        int[] secondArr = new int[3];
        // 이 문제를 해결하기 위해서 객체지향적 코드 사용
        class Time {
            int hour;
            int minute;
            int second;
        }

        Time t = new Time(); // 위처럼 3개의 변수를 선언하는 대신에 하나의 객체를 생성하는 걸로 대신

        /*
        변수의 종류 => 선언위치에 따라 종류가 3가지 => Variables 클래스

        변수 생성시기

        iv : 인스턴스가 생성되었을 때
        cv : 클래스가 메모리 올라갈 때 (객체 생성 안해도됨), 아무때나 사용가능
        lv : 변수 선언문이 수행되었을 때

        참고
        CPU는 HDD, SSD에 있는 Time.class 파일을 직접 못가져옴(CPU가 너무 빠름(속도차이))
        그래서 중간에 둔게 RAM(메모리)
        파일을 읽으려면 메모리에 올려야 하는데 이것을 로딩이라고 함
        메모리에 로딩이 다 된 다음에 CPU가 읽고 쓸 수 있음, CPU는 모든 작업을 RAM하고만 함
        작업이 끝나면 메모리에 있는 내용을 디스크에 씀. 이것을 SAVE. 작업 내용을 SAVE 하지 않고 컴퓨터를 종료하면 다 날라감

        클래스 변수와 인스턴스 변수
        포커 카드가 있는데 하트 7과 스페이드 4가 있다. => Card 클래스
        각각의 카드가 객체. 숫자나 모양 같은 개별적인 값들 즉, 객체마다 다른 값들을 iv(인스턴스 변수)라고 한다.
        폭, 높이 등 객체마다 공통적으로 가지고 있는 값들을 cv(클래스 변수)라고 한다.
        */
        // 사용방법
        Card cd = new Card();
        cd.kind = "Heart";
        cd.number = 300;

        // 사용은 가능하지만 사용하지말기(권장안함) - 참조변수
        cd.width = 200;
        cd.height = 300;

        // 이 방식으로 사용하기 - 클래스이름
        Card.width = 200;
        Card.height = 300;

        /*
        메서드 (명명시 동사로)
        코드 중복 줄일 수 있음, 관리 쉬움, 재사용성, 간결해서 이해하기 쉬움움
        반환타입(출력) 메서드이름 매개변수선언(입력)
        메서드는 클래스 안에 있어야하고 함수는 클래스 독립적
        메서드는 한 가지 기능만 수행하도록 작성 => 의미있는 단위로 나눠야 재사용성 높아짐
        void 메서드의 경우 return 생략가능 => 컴파일러가 자동으로 생성
        자동형변환이 이루어질 수 있는 타입들은 다 반환값으로 가능, int 의 경우 char, byte, short
        */
    }
}
class Variables {
    // 클래스 영역 : 선언문만 가능 (변수 선언, 메서드 선언만 가능, 순서 상관 X)
    int iv; // 인스턴스 변수(instance variable)
    static int cv; // 클래스 변수(static변수, 공유변수) = static + iv

    // 메서드 선언 + 메서드 정의({}부분)
    void method()
    {
        // 메서드 영역
        int lv = 0; // 지역변수(local variable)
    }
}
class Card {
    String kind;
    int number;

    static int width = 100;
    static int height = 250;
}
class Test {
    int add(int x, int y) { // 선언부
        int result = x + y; // 구현부
        return result;      // 구현부
    }
    int max(int a, int b) {
        if(a > b) { // 이 부분만 적으면 return 에러
            return a;
        } else {
            return b;
        }
    }
}
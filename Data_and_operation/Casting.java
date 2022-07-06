
public class Casting {

	public static void main(String[] args) {
		// 데이터 타입의 변환(casting)
		
		double a = 1.1;
		double b = 1; // => 자동으로
		// 정수지만 정수가 b라고 하는 변수에 담길때 더블형이라 자동으로
		// 정수가 실수형으로 컨버팅이 됨
		// 이렇게 컨버팅이 되면 잃어버리는 값이 없음
		System.out.println(b);
		// 사실 위 코드는 double b = (double) 1; 똑같음 => 수동으로(명시적으로)
		
		
		// int c = 1.1; // 자동으로 바꾸면 손실이 일어나기때문에 반드시 명시적으로만 형 변환을 해야한다
		// 더블형인데 정수형에 담아서 오류
		// 두가지 방법
		double d = 1.1;
		int e = (int) 1.1; // 정수로 바꾸겠다 라는 의미
		System.out.println(d);
		System.out.println(e); 
		
		// 1 to String
		String f = Integer.toString(1);
		System.out.println(f); 
		System.out.println(f.getClass()); 
	}

}

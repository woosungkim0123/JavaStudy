
public class Datatype {

	public static void main(String[] args) {
		System.out.println(6);
		System.out.println("6");
		System.out.println(6+6);
		System.out.println("6"+"6"); // 더하기가 아닌 결합연산자(문자열)
		System.out.println(6 * 6);
		//System.out.println("6" * "6"); // 에러
		System.out.println("1111".length()); // 문자열 길이
		// System.out.println(1111.length()); 숫자길이는 없음
	    
	    System.out.println(6 + 2); // 8
        System.out.println(6 - 2); // 4
        System.out.println(6 * 2); // 12
        System.out.println(6 / 2); // 3
        System.out.println(6 % 4); // 2 (나머지)
 
        System.out.println(Math.PI); // 3.141592653589793
        System.out.println(Math.floor(Math.PI));
        System.out.println(Math.ceil(Math.PI));
        
        System.out.println("Hello World"); // String
        System.out.println('H'); // Character(문자)
        System.out.println("H"); 
     
        System.out.println("Hello "
                + "World");
         
        // new line
        System.out.println("Hello \nWorld");
         
        // escape
        System.out.println("Hello \"World\"");// Hello "World"
        
        System.out.println("Hello World".length()); // 11
        System.out.println("Hello, [[[name]]] ... bye. ".replace("[[[name]]]", "duru"));

	}

}

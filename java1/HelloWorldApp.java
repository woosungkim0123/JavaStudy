public class HelloWorldApp {
	// java development kit (JDK) 자바를 이용해서 프로그램을 개발할떄 사용하는 여러가지 도구를 모아서 제공하는 개발자용 버전 자바
	// 파일명과 같아야함. 파일을 실행시키면 자바는 HelloWorldApp 클래스를 찾고
	// 메인이라는 약속된 이름의 메소드를 찾아서 실행시킴
	// 저장하면 .class파일이 생기는데 package Explorer에서는 확장자가 class인 파일은 감추기 때문에 눈에 보이지 않음
	public static void main(String[] ags) {
		System.out.println("Hello World!");
		// .java파일에 사람이 읽고 쓸 수 있는 소스코드가 담겨있고 저장버튼 눌렀을때 자바가 컴파일이라는 과정을 거쳐서 확장자가 클래스인 파일을 만듬
		// .class 파일은 사람이 읽도록 고안된 정보가 아님
		
		// 자바 동작 원리
		// source, code, language : 사람만 읽을 수 있음
		// 위를 사용해서 만들어진 결과물 application, app, program
		// 컴퓨터에 자바를 깔았음(jdk) java virtual machine이 깔려있음
		// java인 파일을 작성함(java 소스코드: 사람이 이해)
		// 위에 파일을 기계가 이해할 수 있도록 전환하는 작업 : complie(컴파일)
		// 이클립스에서는 저장하면 .class 파일이 만들어지는데(compile) 그게 바로 자바 application이라고 생각하면됨
		// 이클립스에서 run 버튼을 클릭하면 이클립스가 우리 대신 java virtual machine에 실행하라고 함
	}
}

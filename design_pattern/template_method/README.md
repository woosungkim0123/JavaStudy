# Template Method Pattern

- 템플릿 메소드 패턴은 상위 클래스에서 처리의 뼈대를 정의하고, 하위 클래스에서 그 구체적인 내용을 결정하는 디자인 패턴입니다.
- 변하지 않는 부분을 추상클래스에 두고 변하는 부분을 하위 클래스에서 구현하도록 합니다.

## 역할

### AbstractClass(추상 클래스) 역할

- 템플릿 메소드를 구현하며 처리의 뼈대를 정의합니다.
- 예시에서는 AbstractDisplay 클래스가 이 역할을 합니다.

### ConcreteClass(구체적인 클래스) 역할

- AbstractClass 역할의 추상 메소드를 구현하여 처리의 내용을 결정합니다.
- 예시에서는 CharDisplay와 StringDisplay 클래스가 이 역할을 합니다.
- 실제 동작은 CharDisplay나 StringDisplay 클래스에서 정해집니다.

![템플릿 메서드 패턴](../image/template_method.png)

## 기타 

### 단점

템플릿 메서드 패턴은 상속을 사용하다보니 상속에서 오는 단점들을 그대로 가지고 있습니다.

- 자식 클래스에서 부모 클래스의 기능을 사용하지 않을 경우에도 부모 클래스의 기능을 상속받아야 합니다.
- 별도의 클래스나 익명 내부 클래스를 만들어야 하는 부분도 복잡합니다.

### 왜 인터페이스 대신 추상 클래스를 사용하지?

인터페이스 default 메소드를 사용하면 추상 클래스를 사용하지 않고도 템플릿 메소드 패턴을 구현할 수 있습니다.

**인터페이스와 추상클래스 차이**

- 추상클래스에서는 static이나 final이 아닌 필드를 지정할 수 있다.
- 추상클래스에서는 protected default 접근자 메소드를 가질 수 있다.
- 인터페이스를 구현하는 클래스는, 다른 여러개의 인터페이스들을 함께 구현할 수 있지만 추상클래스를 상속 받은 서브클래스는 다른 클래스를 상속받을 수 없다.

**추상 클래스를 사용하는 경우**

- 관련성이 높은 클래스 간에 코드를 공유하고 싶은 경우
- 추상클래스를 상속받은 클래스들이 공통으로 가지는 메소드와 필드가 많거나, public 이외의 접근제어자(protected, default) 사용이 필요한 경우
- non-static, non-final 필드 선언이 필요한 경우.

**인터페이스를 사용하는 경우**

- 서로 관련성이 없는 클래스들이 인터페이스를 구현하게 되는 경우에 사용한다. 예를 들어, Comparable, Cloneable 인터페이스는 여러 클래스들에서 구현되는데, 구현클래스들 간에 관련성이 없는 경우가 대부분이다.
- 특정 데이터 타입의 행동을 명시하고 싶은데, 어디서 그 행동이 구현되는지는 신경쓰지 않는 경우.
- 다중상속을 허용하고 싶은 경우

### 코드 예시

**사용 전**

```java
public class TemplateMethodTest {

    private void logic1() {
        long startTime = System.currentTimeMillis();
        
        log.info("비즈니스 로직1 실행"); // 이 부분 뺴고 나머지는 변하지 않는 부분
        
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
```

**사용 후**

```java
public abstract class AbstractTemplate {
    public void execute() {
        long startTime = System.currentTimeMillis();
        
        call(); // 상속
        
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
    
    protected abstract void call();
}

public class SubClassLogic1 extends AbstractTemplate {
    @Override
    protected void call() {
        log.info("비즈니스 로직1 실행");
    }
}
```





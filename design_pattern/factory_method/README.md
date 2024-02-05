# Factory Method Pattern

- 객체 생성에 필요한 과정을 템플릿처럼 정해 놓고 각 과정을 다양하게 구현이 가능하도록 하는 패턴입니다.
- 인스턴스 생성을 위한 뼈대(프레임워크)와 실제 인스턴스 생성을 위한 클래스를 분리합니다.

## 역할

### Product(제품) 역할

- 패턴으로 생성되는 인스턴스가 가져야 할 인터페이스를 정의합니다.
- 예시에서는 Product 추상 클래스가 이 역할을 합니다.

### Creator(생성자) 역할

- Proudct를 생성하는 추상 클래스입니다.
- 예시에서는 Factory 클래스가 이 역할을 합니다.

### ConcreteProduct(구체적인 제품) 역할

- Product를 실제로 구현한 클래스입니다.
- 예시에서는 IDCard 클래스가 이 역할을 합니다.

### ConcreteCreator(구체적인 생성자) 역할

- 실제로 인스턴스를 생성하는 클래스입니다.
- 예시에서는 IDCardFactory 클래스가 이 역할을 합니다.

![팩토리 메서드 패턴](../image/factory_method.png)

## 기타

### static 팩토리 메소드

- 인스턴스 생성을 위한 클래스 메소드(static 메소드)를 팩토리 메소드라고 부르는 경우가 있습니다.
- GoF의 팩토리 메소드 패턴과는 다르지만 Java에서 인스턴스를 생성할 때 매우 자주 사용되는 기법입니다.
- create, getInstance, newInstance 등의 이름을 가진 메소드가 이에 해당합니다.

```java
// getInstance 메소드는 난수 생성 알고리즘 이름을 정해서 SecureRandom 인스턴스를 생성하는 static 팩토리 메소드입니다.
SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

// List.of 메소드는 인수로 전달된 요소를 원소로 하는 List 인스턴스를 생성하는 static 팩토리 메소드입니다.
List<String> list = List.of("A", "B", "C");

// String.valueOf 메소드는 다양한 문자열 표현을 얻는 static 팩토리 메소드입니다.
String str = String.valueOf('A');

// Instant.now 메소드는 현재 시각을 나타내는 Instant 인스턴스를 생성하는 static 팩토리 메소드입니다.
Instant now = Instant.now();
```



# Template Method Pattern

- 템플릿 메소드 패턴은 상위 클래스에서 처리의 뼈대를 정의하고, 하위 클래스에서 그 구체적인 내용을 결정하는 디자인 패턴입니다.

## 역할

### AbstractClass(추상 클래스) 역할

- 템플릿 메소드를 구현하며 처리의 뼈대를 정의합니다.
- 예시에서는 AbstractDisplay 클래스가 이 역할을 합니다.

### ConcreteClass(구체적인 클래스) 역할

- AbstractClass 역할의 추상 메소드를 구현하여 처리의 내용을 결정합니다.
- 예시에서는 CharDisplay와 StringDisplay 클래스가 이 역할을 합니다.
- 실제 동작은 CharDisplay나 StringDisplay 클래스에서 정해집니다.

![템플릿 메서드 패턴](../image/template_method.png)



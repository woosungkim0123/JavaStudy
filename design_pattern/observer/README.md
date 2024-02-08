# Observer Pattern (관찰자 패턴)

- 관찰 대상의 상태가 변화하면 관찰자에게 알려주는 패턴 입니다.
- 상태 변화에 따른 처리가 필요한 경우 사용합니다.

## 역할

### Subject (관찰 대상)

- 관찰되는 대상을 나타냅니다.
- 관찰자를 등록하거나 삭제하는 메소드를 가지고 있습니다.
- 예시에서 `NumberGenerator`가 해당 역할을 합니다.

### ConcreteSubject (구체적인 관찰 대상)

- 구체적으로 관찰되는 대상을 표현합니다.
- 상태가 변화하면 등록된 관찰자(Observers)에게 알립니다.
- 예시에서 `RandomNumberGenerator`가 해당 역할을 합니다.

### Observer (관찰자)

- 관찰 대상의 상태가 변화했을 때 전달 받기 위한 메소드를 정의하는 인터페이스입니다.
- 예시에서 `Observer`가 해당 역할을 합니다.

### ConcreteObserver (구체적인 관찰자)

- 구체적인 관찰자(Observer)를 나타냅니다.
- update 메소드가 호출되면 그 메소드 안에서 관찰 대상(Subject)의 현재 상태를 취득합니다.
- 예시에서 `DigitObserver`와 `GraphObserver`가 해당 역할을 합니다.

![옵저버 패턴](../image/observer_pattern.png)

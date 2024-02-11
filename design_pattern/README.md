# 디자인 패턴

- 디자인 패턴은 소프트웨어 설계 시 반복적으로 발생하는 문제에 대한 해결책을 제시합니다.
- GOF라고 불리는 23개의 디자인 패턴이 가장 유명하고 그 밖에도 다수의 디자인 패턴이 존재합니다.

## 디자인 패턴의 의도

디자인 패턴에서 패턴의 모양이 구현 세부 사항을 나타내는 반면, 패턴의 의도는 해당 패턴이 해결하고자 하는 문제와 그 패턴이 적용될 때 얻을 수 있는 이점을 설명합니다

디자인 패턴에서 패턴의 모양도 중요하지만 더 중요한것은 패턴의 의도입니다.

**예시1** 

전략패턴을 구현할 때 필드에 전략을 받아서 선 조립후 실행하는 방식을 선택할 수도있고 메서드로 전략을 받아서 실행 시점에 유연하게 전략을 선택할 수도 있습니다.

이렇게 두가지 예시는 모양은 다르지만 의도는 같습니다. 

**예시2**

프록시 패턴과 데코레이터 패턴은 모두 프록시를 사용하고 있고 모양이 같을 때도 있습니다. 이 두가지는 어떻게 구분할까요?

디자인 패턴에서 패턴의 모양이 같을 때도 의도가 다르면 다른 패턴으로 구분하기 때문에 패턴을 만든 의도가 가장 중요합니다.

프록시 패턴은 접근 제어가 목적이고 데코레이터 패턴은 부가 기능 추가가 목적인 패턴입니다.

## 디자인 패턴 종류

### 생성에 관한 패턴

- [추상 팩토리(Abstract Factory)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/abstract_factory)
- [빌더(Builder)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/builder)
- [팩토리 메서드(Factory Method)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/factory_method)
- [프로토타입(Prototype)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/prototype)
- [싱글턴(Singleton)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/singleton)

### 구조에 관한 패턴

- [어댑터(Adapter)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/adapter)
- [브릿지(Bridge)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/bridge)
- [컴포지트(Composite)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/composite)
- [데코레이터(Decorator)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/decorator)
- [퍼사드(Facade)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/facade)
- [경량(Flyweight)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/flyweight)
- [프록시(Proxy)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/proxy)

### 행동에 관한 패턴

- [책임 연쇄(Chain of Responsibility)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/chain_of_responsibility)
- [명령(Command)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/command)
- [인터프리터(Interpreter)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/interpreter)
- [반복자(Iterator)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/iterator)
- [중재자(Mediator)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/mediator)
- [메멘토(Memento)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/memento)
- [감시자(Observer)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/observer)
- [상태(State)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/state)
- [전략(Strategy)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/strategy)
- [템플릿 메서드(Template Method)](https://github.com/woosungkim0123/java-deep-dive/tree/master/design_pattern/template_method)

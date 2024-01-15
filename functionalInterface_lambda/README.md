# 함수형 인터페이스, 람다

## 개념

추상 메서드를 딱 하나만 가지고 있는 인터페이스 (인터페이스에서는 abstract 생략가능)

추상 메서드가 두개 있으면 함수형 인터페이스가 아닙니다.

## 추가 사항

- 인터페이스에 static 메서드, default 메서드를 정의할 수 있습니다.

- 함수형 인터페이스에 @FunctionalInterface 어노테이션을 붙여주면 컴파일러가 함수형 인터페이스의 조건을 잘 지키고 있는지 확인해줍니다.

## 함수형 인터페이스의 사용

자바8 이전에는 익명 내부 클래스(anonymous inner class)를 사용하여 함수형 인터페이스를 구현했습니다.

```java
public interface Example {
    void doSomething();
};
```
```java
Example example = new Example() {
    @Override
    public void doSomething() {
        System.out.println("Hello World!");
    }
};
```

자바8부터는 람다 표현식을 사용하여 함수형 인터페이스를 구현할 수 있습니다.

```java
Example example = () -> System.out.println("Hello World!");
example.doSomething();
```

람다 표현식은 함수를 정의하는 것처럼 보이지만, 실제로는 함수형 인터페이스를 인라인 형태로 구현한 특수한 형태의 객체입니다. 

이러한 특성 때문에 람다 표현식은 변수에 할당될 수 있으며, 메서드의 매개변수로 전달되거나, 리턴 값으로 사용될 수 있습니다.

람다 표현식으로 생성된 함수형 인터페이스의 구현체는 일급 객체로 취급될 수 있습니다. 

## 함수형 프로그래밍

### 일급 객체(First-Class Objects)

자바에서는 메서드와 클래스 등 다양한 구조체로 값의 구조를 표현할 수 있습니다. 

그러나 프로그램 실행 중에 모든 구조체를 자유롭게 전달하거나 조작할 수는 없습니다. 이렇게 제한적으로 전달되는 구조체는 이급 객체로 간주됩니다. 

반면, int, String, Double과 같은 값은 변수에 할당하고, 함수의 매개변수로 전달하거나, 함수의 리턴 값으로 사용할 수 있어 일급 객체로 간주됩니다. 자바 8부터는 메서드 참조를 통해 메서드도 일급 객체처럼 사용할 수 있게 되었습니다.


### 고차 함수(Higher-Order Function)

고차 함수는 함수를 매개변수로 받을 수 있고, 함수를 리턴할 수 있으며, 변수에 할당할 수 있는 함수를 말합니다.

자바에서는 함수가 특수한 형태의 객체이기 때문에 함수를 리턴하거나 매개변수로 받을 수 있습니다. 즉, 고차 함수가 될 수 있습니다.

일급 객체가 된다면 고차 함수가 되는 것은 당연한 일입니다.

### 순수 함수(Pure Function)

입력 값이 같으면 항상 같은 결과를 리턴하는 함수를 순수 함수라고 합니다. 

이걸 보장해주지 못하는 상황이 발생하거나 그럴 여지가 있으면 함수형 프로그래밍이라고 보기가 어렵습니다.

예시로 함수 안에서 함수 밖에 값을 참조해서 사용하는 경우 상태 값에 의존한다 라고 표현하고 순수 함수가 아닙니다. 또, 함수 밖의 값을 변경하는 경우도 순수 함수가 아닙니다.

```java
int number2 = 10; // 이 값 참조시 순수 함수가 아님

Example example3 = new Example() {
    int number3 = 10; // 이 값 참조시 순수 함수가 아님
    @Override
    public int doSomething(int number) {
        return number + number3;
    }
};
```

```java
int number2 = 10; // 안에서 이 값 변경시 순수 함수가 아님

Example example3 = new Example() {
    int number3 = 10; // 안에서 이 값 변경시 순수 함수가 아님
    @Override
    public int doSomething(int number) {
        number3++; 
        return number;
    }
};
```

안에서 참조한 경우 final로 가정하기 때문에 값을 변경할 수 없습니다.

```java
int number2 = 10; 

Example example3 = new Example() {
    @Override
    public int doSomething(int number) {
        return number + number2;
    }
};

number2++; 
```

### 불변성 (Immutability)

객체가 생성된 후에 그 상태를 변경할 수 없는 속성을 의미합니다. 즉, 한 번 생성된 객체는 그 상태를 변경할 수 없으며, 객체의 값을 수정하려면 새로운 객체를 생성해야 합니다.

**불변성이 중요한 이유**

1. 불변한 객체는 스레드 간의 동시 접근에 대해 안전합니다. 여러 스레드가 동시에 객체에 접근하더라도 객체의 상태가 변경되지 않기 때문에 동기화나 락(lock)을 사용할 필요가 없습니다. 이로 인해 병렬 처리가 간단하고 안전하게 이루어질 수 있습니다.
2. 불변한 객체는 객체의 상태가 변하지 않기 때문에 예측 가능한 동작을 보장합니다. 한 번 생성된 객체는 항상 동일한 값을 가지므로, 객체가 다른 부분에 영향을 주지 않는 한 함수 호출 결과도 항상 동일합니다.

**불변성 유지 원칙**

1. 필드(멤버 변수)는 `final` 키워드를 사용하여 초기화 이후에 변경되지 않도록 선언합니다.
2. 메서드는 객체의 상태를 변경하지 않는다는 것을 명시적으로 표시하고, 새로운 객체를 반환하거나 부작용이 없는 계산을 수행합니다.
3. 객체를 복제(clone)하거나 참조를 공유하는 대신 독립적인 객체를 생성하여 사용합니다.

**불변성을 어기는 예시**

```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    // 객체 상태 변경 메서드 -> 코드 불변성을 어기는 예
    public void setName(String name) {
        this.name = name;
    }
}
```

**불변성을 지키는 예시**

```java
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public Person withName(String newName) {
        return new Person(newName);
    }

    public String getName() {
        return name;
    }
}
```
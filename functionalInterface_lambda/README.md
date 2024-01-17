# 함수형 인터페이스

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

## 기본 제공 함수형 인터페이스

### Function<T, R>

T 타입을 받아서 R 타입을 리턴하는 함수형 인터페이스입니다.

- R apply(T t)
- 조합용으로 andThen, compose 메서드를 제공합니다.

### BiFunction<T, U, R>

T 타입과 U 타입을 받아서 R 타입을 리턴하는 함수형 인터페이스입니다.

- R apply(T t, U u)

### Consumer<T>

T 타입을 받아서 아무것도 리턴하지 않는 함수형 인터페이스입니다.

- void accept(T t)
- 조합용으로 andThen 메서드를 제공합니다.

### Supplier<T>

값을 받지않고 T 타입의 값을 제공하는 함수형 인터페이스입니다. (어떤 값을 하나 가져오는 인터페이스)

- T get

### Predicate<T>

T 타입을 받아서 boolean을 리턴하는 함수형 인터페이스입니다.

- boolean test(T t)
- 조합용으로 and, or, negate 메서드를 제공합니다. negate는 반대로 바꿔주는 메서드입니다.

### UnaryOperator<T>

Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수형 인터페이스입니다.

- T apply(T t)

### BinaryOperator<T>

BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입력값 두개를 받아서 동일한 타입을 리턴하는 함수형 인터페이스입니다.

- T apply(T t1, T t2)

# 람다

## 람다 표현식

람다 표현식은 메서드로 전달할 수 있는 익명 함수를 단순화한 것입니다.

## 인자 표현

- 인자가 없을 때: () -> {}
- 인자가 한 개일 때: (one) -> {}, one -> {}
- 인자가 여러 개일 때: (one, two) -> {}
- 인자 타입은 생략 가능(컴파일러가 타입 추론)

## 변수 캡처

변수 캡처는 익명 클래스나 내부 클래스에서 사용되는 개념입니다. 과거에는 참조하는 외부 변수에 final을 명시해야 했지만, 자바 8부터는 'effective final' 덕분에 final 키워드를 생략할 수 있게 되었습니다. 

'effective final'은 사실상 final 속성을 가진 변수를 의미합니다. 이는 final 키워드를 사용하지 않아도 람다 표현식이나 익명 클래스에서 참조할 수 있는 변수를 말합니다.

### 값이 변경되는 경우

값이 변경될 경우 내부 클래스, 익명 클래스, 람다에서 컴파일 에러가 발생합니다. 외부 변수를 참조하는 내부 클래스, 익명 클래스, 람다에서는 변수가 사실상 final, 즉 변경되지 않는 상태여야 합니다. 변수 값이 변경되면, 이 변수는 더 이상 'effective final'이 아니게 되므로 내부 클래스, 익명 클래스, 람다 표현식 내에서 참조할 수 없게 됩니다. 이러한 제약은 동시성 문제를 방지하고, 불변성을 유지하기 위해 필요합니다.

```java
private void run() {
    int baseNumber = 10;
    IntConsumer printInteger = (i) -> {
        System.out.println(i + baseNumber); // 에러
    };
    
    baseNumber++ // effective final이 아니게 되어서
}
```

## 쉐도잉

쉐도잉은 서로 다른 스코프에 위치한 동일한 이름의 변수 중 하나가 다른 하나를 가리는 현상을 말합니다.

### 내부 클래스

```java
private void run() {
    int baseNumber = 10; // 외부 변수

    class LocalClass {
        void printBaseNumber() {
            int baseNumber = 11; // 내부 변수
            System.out.println(baseNumber); // 11 출력, 내부 변수가 외부 변수를 가림
        }
    }
}
```

### 익명 클래스

```java
private void run() {
    int baseNumber = 10;

    Consumer<Integer> integerConsumer = new Consumer<Integer>() {
        @Override
        public void accept(Integer baseNumber) {
            System.out.println(baseNumber); // 여기서 baseNumber는 파라미터
        }
    };
}
```

### 람다

람다 표현식에서는 쉐도잉이 발생하지 않습니다. 람다는 같은 스코프에 속하기 때문에 같은 이름의 변수를 재정의할 수 없습니다.

```java
private void run() {
    int baseNumber = 10;

    IntConsumer printInteger = (i) -> {
        // int baseNumber = 0; // 에러 발생, 같은 스코프 내에 동일 이름 변수 재정의 불가
        System.out.println(i + baseNumber);
    };
}
```

## 메서드 레퍼런스

람다 표현식을 사용하는 대신, 더 간결하게 메서드 레퍼런스를 사용할 수 있습니다. 메서드 레퍼런스는 기존의 메서드나 생성자를 직접 호출하는 것을 말합니다.

### static 메소드 참조

`타입::static 메소드`

```java
public class Greeting {
    public static String hi(String name) {
        return "hi " + name;
    }
};

UnaryOperator<String> hi = Greeting::hi;
System.out.println("hi.apply() = " + hi.apply("ho"));
```

### 특정 객체의 인스턴스 메서드 참조

`객체 레퍼런스::인스턴스 메소드`

```java
public class Greeting {
    public String hello(String name) {
        return "hello " + name;
    }
};

Greeting greeting = new Greeting();
UnaryOperator<String> hi2 = greeting::hello;
```

### 빈 생성자 참조, 입력 값이 있는 생성자 참조

`타입::new`

```java

public class Greeting {
    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }
};

Supplier<Greeting> newGreeting = Greeting::new;
Greeting greeting1 = newGreeting.get();

Function<String, Greeting> hoGreeting = Greeting::new;
Greeting ho = hoGreeting.apply("ho");
```

### 임의 객체의 인스턴스 메서드 참조

`타입::인스턴스 메소드`

주로 컬렉션 정렬 등에 사용

```java
String[] names = {"ho", "jin", "woo"};

// 1. 익명 클래스
Arrays.sort(names, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
});

// 2. 람다 표현식
Arrays.sort(names, (s, str) -> s.compareToIgnoreCase(str));

// 3. 메서드 레퍼런스
Arrays.sort(names, String::compareToIgnoreCase); // String::compareToIgnoreCase는 (x, y) -> x.compareToIgnoreCase(y)와 같습니다.
```

## 인터페이스 기본 메서드, static 메서드

인터페이스에 새로운 기능을 추가하면, 그 인터페이스를 구현한 클래스를 모두 수정해야 합니다. (추가한 추상 메서드를 구현하지 않았기 때문에)

자바 8부터는 인터페이스에 새로운 기능을 추가하더라도 그 인터페이스를 구현한 클래스를 모두 수정할 필요가 없습니다. 모든 구현체는 해당 기능을 사용할 수 있습니다.

```java
public interface Foo {
    void printName();

    /**
     * @implSpec 
     * 자세한 설명이 들어가야합니다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
    
    // static 메서드는 구현체에서 재정의 할 수 없습니다.
    static void printAnything() {
        System.out.println("Foo");
    }
}
```

### 주의사항

- default 메서드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있습니다. (@implSpec을 활용한 문서화 추천)
- Object 클래스의 메서드는 기본 메서드로 제공할 수 없습니다. (eqauls, hasCode)
- 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다. (기본 구현체를 제공하고 싶지 않을 때)
- 구현체가 재정의 할 수도 있습니다.
- 두개의 인터페이스를 구현한 구현체에서 두 인터페이스에 동일한 디폴트 메서드가 있는 경우는 어떻게 해야할까요? -> 구현체가 재정의해야합니다.

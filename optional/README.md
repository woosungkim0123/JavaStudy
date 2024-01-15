# Optional

## 개념

Optional은 인터페이스로써 값이 있을 수도 있고 없을 수도 있음을 표현하는 타입입니다. 

## 탄생 이유

1. null 체크를 잊어먹는 문제를 방지하기 위해

```java
StudentAttendance1 simStudent = new StudentAttendance1(1L, "심XX", true);
Duration classDuration = simStudent.getProgress().getClassDuration();  // progress가 null인데 메서드를 호출하려고하면 null을 참조할 수 없다고 NullPointerException 에러가 뜨게 됩니다. 
System.out.println("classDuration = " + classDuration);
```

이전에는 이런 상황을 방지하기 위해 아래와 같이 null 체크를 해주었습니다.

```java
StudentAttendance1 simStudent = new StudentAttendance1(1L, "심XX", true);
Progress progress = simStudent.getProgress();
if (progress != null) {
    System.out.println(progress.getClassDuration());
}
```

그러나 이런 코드는 null 체크를 잊어먹을 수 있는 에러를 만들기 쉽습니다.

2. null 리턴

이전에는 값을 리턴할 수 없는 경우 에러를 던지거나 null을 리턴하였습니다.

에러가 발생하면서 스택트레이스를 찍는데 이것도 리소스를 사용하게 됩니다.

그리고 null 자체를 리턴하는 것은 클라이언트 쪽에서 주의 깊게 처리해야하는 문제를 발생시킵니다.

이러한 이유로 탄생한 Optional은 클라이언트 쪽에서 명시적으로 빈 값일 수도 있다는 걸 알려주고, 빈 값인 경우에 대한 처리를 강제합니다.

## 주의점

Optional은 여러곳에서 사용할 수 있지만 리턴 타입으로 쓰는 것만이 권장사항입니다. 

### 메서드 파라미터로 사용하지 않는 것을 권장합니다.

메서드 파라미터로 null을 넘기게 되면 NullPointerException이 발생하고 Optional의 의미가 없어집니다.

```java
student.setProgress(null);

public void setProgress(Optional<Progress> progress) {
    progress.ifPresent(p -> this.progress = p); // NullPointException 발생
}
```
### Map의 key 타입으로 Optional을 사용하지 않는 것을 권장합니다.

Map의 가장 중요한 특징 중 하나가 key가 null이 될 수 없다는 것입니다. 그러나 Optional을 사용하면 비어있을 수 있기 때문에 Map의 인터페이스의 특징을 깨트리는 것입니다. 


### 인스턴스 필드 타입으로도 사용하지 않는 것을 권장합니다.

```java
// 잘못된 예시
public class StudentAttendance1 {
    
    private Optional<Progress> progress; // 설계의 문제
}
```

### 원시타입에는 원시 타입 전용 Optional을 사용하는 것을 권장합니다.

원시(Primitive) 타입에는 원시Optional 타입이 존재합니다. (OptionalInt, OptionalLong ...)

사용을 권장하지 않는 이유는 안에서 박싱과 언박싱이 발생하면서 성능이 떨어지기 때문입니다.

> 박싱(Boxing): 원시(Primitive) 타입의 데이터를 해당 래퍼 클래스의 객체로 변환하는 과정입니다. 예를 들어, int 타입의 데이터를 Integer 객체로 변환하는 것입니다.
>
> 언박싱(Unboxing): 래퍼(Wrapper) 클래스의 객체에서 원시 타입의 데이터를 추출하는 과정입니다. 예를 들어, Integer 객체에서 int 타입의 데이터를 얻는 것입니다.

### Optional을 리턴하는 메서드에서는 절대 null을 리턴하지 않는 것을 권장합니다. 

null을 리턴하면 사용하는 클라이언트 쪽에서 Optional의 메서드를 사용했음에도 불구하고 NullPointerException이 발생하기 때문입니다.

빈 값을 리턴하고 싶으면 Optional.empty()를 리턴하면 됩니다.


### 컨테이너 성격의 인스턴스들은 Optional로 감싸지 않는 것이 좋습니다.

자체로 비어있는지 여부를 판단할 수 있는 컨테이너 성격의 인스턴스(Collection, Map, Stream Array, Optional)를 Optional로 감싸는 것은 무의미한 일입니다.



## Optional Api

### Optional.of, Optional.ofNullable

Optional.of는 null이 아닌 인스턴스를 감싸는 Optional을 리턴합니다

Optional.ofNullable은 null인 인스턴스를 감싸는 Optional을 리턴합니다.

만약 Optional.of에 null을 넣으면 NullPointerException이 발생합니다.

### get

Optional에 감싸진 인스턴스를 리턴합니다. 

만약 비어있는 Optional이면 NoSuchElementException이 발생합니다. 가급적 사용하지 않는 것이 좋습니다.

### ifPresent(Consumer)

체크하는 if문과 꺼내는 get 코드 없이 Optional에 값이 있는 경우에 무언가를 해야할 때 사용합니다.

### orElse(T)

Optional에 값이 있으면 가져오고 없는 경우에는 인자로 넘긴 값을 리턴합니다.

주의할 점은 orElse는 Optional에 값이 있어도 인자로 넘긴 값을 무조건 생성합니다. (상수 등을 넘길 때 사용합니다.)

### orElseGet(Supplier)

Optional에 값이 있으면 가져오고 없는 경우에 인자로 넘긴 Supplier를 실행시킵니다.

orElse와 다른 점은 orElseGet은 Optional에 값이 있을 때만 Supplier를 실행시킵니다. (함수형 인터페이스이기 때문에 Lazy하게 동작합니다.)

### orElseThrow(Supplier)

Optional에 값이 있으면 가져오고 없는 경우에 인자로 넘긴 Supplier를 실행시키고 에러를 던집니다.

### filter(Predicate)

Optional에 값이 있으면 Predicate를 실행시켜서 true가 나오면 Optional을 리턴하고 false가 나오면 비어있는 Optional을 리턴합니다.

### map(Function)

Optional에 값이 있으면 Function을 실행시켜서 리턴된 값을 Optional로 감싸서 리턴합니다.

### flatMap(Function)

Optional에 값이 있으면 Function을 실행시켜서 리턴된 Optional을 리턴합니다. Optional 안에 들어있는 인스턴스가 Optional인 경우에 사용합니다.
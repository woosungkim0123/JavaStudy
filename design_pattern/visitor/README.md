# Visitor Pattern

- 방문자와 방문 공간을 분리하여 방문 공간이 방문자를 맞이할 때, 이후에 대한 행동을 방문자에게 위임하는 패턴입니다
- 새로운 행동을 추가하고 싶을 때는 새로운 방문자를 추가하면 되므로, 기존 코드를 변경하지 않고도 새로운 행동을 추가할 수 있습니다. (중요)

## Visitor 패턴에서 Directory를 추가했을 때

- File에 영향을 주지 않고, 새로운 행동을 추가할 수 있습니다.

1. Entry를 구현한 Directory 클래스를 추가합니다.
2. Visitor 추상 클래스에 Directory를 위한 visit 메소드를 추가합니다.
3. Visitor를 구현한 ListVisitor 클래스에 Directory를 위한 visit 메소드를 추가합니다.

## 역할

### Visitor(방문자) 역할

- visit 메소드를 선언하여, 각 ConcreteElement 역할을 방문할 때의 처리를 정의합니다.
- 예시에서는 Visitor 추상 클래스가 이 역할을 합니다.

### ConcreteVisitor(구체적인 방문자) 역할

- Visitor 역할의 인터페이스를 실제로 구현합니다.
- 예시에서는 ListVisitor 클래스가 이 역할을 합니다.

### Element(요소) 역할

- 방문자를 받아들이는 메소드를 선언합니다.
- 예시에서는 Entry 추상 클래스가 이 역할을 합니다.

### ConcreteElement(구체적인 요소) 역할

- Element 역할의 인터페이스를 실제로 구현합니다.
- 예시에서는 File, Directory 클래스가 이 역할을 합니다.

### ObjectStructure(객체 구조) 역할

- Directory 클래스는 파일 시스템 내에서 폴더 또는 디렉토리를 나타내며, 여러 개의 파일(File)이나 다른 디렉토리(Directory)를 포함할 수 있는 컨테이너 역할을 합니다.
- 예시에서는 Directory 클래스가 이 역할을 합니다. (1인 2역)
- ConcreteVisitor가 각각의 Element를 다룰 수 있도록 Director 클래스 안에 iterator 메소드가 정의되어 있습니다.
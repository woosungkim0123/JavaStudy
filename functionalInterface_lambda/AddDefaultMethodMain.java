import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class AddDefaultMethodMain {
    public static void main(String[] args) {

        /**
         * forEach() 메소드는 Iterable 인터페이스에 추가된 디폴트 메소드이다.
         */
        System.out.println("=== forEach() 메소드 ===");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.forEach(System.out::println);

        /**
         * spliterator() 메소드는 Iterable 인터페이스에 추가된 디폴트 메소드이다.
         * - 쪼갤 수 있는 iterator
         * - stream이 spliterator를 사용한다.
         */
        System.out.println("=== spliterator() 메소드 ===");

        List<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        Spliterator<String> spliterator = list2.spliterator();

        while (spliterator.tryAdvance(System.out::println)); // tryAdvance는 boolean을 반환한다. (순회를 끝내면 false를 반환한다.)

        // trySplit으로 쪼개기 (순서가 보장되지 않는다.)
        System.out.println("=== spliterator trySplit ===");

        List<String> list3 = new ArrayList<>();
        list3.add("g");
        list3.add("h");
        list3.add("i");
        list3.add("j");
        Spliterator<String> spliterator1 = list3.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        System.out.println("=== 1번 ===");
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=== 2번 ===");
        while (spliterator2.tryAdvance(System.out::println));

        /**
         * removeIf() 메소드는 Collection 인터페이스에 추가된 디폴트 메소드이다.
         */
        System.out.println("=== removeIf() 메소드 ===");

        List<String> list4 = new ArrayList<>();
        list4.add("g1");
        list4.add("h1");
        list4.add("i2");
        list4.add("j2");

        list4.removeIf(s -> s.endsWith("1"));
        list4.forEach(System.out::println);

        /**
         * Comparator
         */
        System.out.println("=== Comparator ===");

        Comparator<String> comparator = String::compareToIgnoreCase;
        list4.sort(comparator.reversed()); // 다른 조건으로 정렬하고 싶을 때 .thenComparing()를 추가로 사용하면 됩니다.
        list4.forEach(System.out::println);

        // Comparator를 연결하여 응용 가능
        List<Apple> list5 = new ArrayList<>();
        list5.add(new Apple("red", 100));
        list5.add(new Apple("green", 200));
        list5.add(new Apple("black", 700));
        list5.add(new Apple("blue", 300));
        list5.add(new Apple("yellow", 400));
        list5.add(new Apple("ruby", 400));

        list5.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        list5.forEach(System.out::println);

        // predicate를 사용하여 응용 가능
        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");

        Predicate<Apple> negate = redApple.negate(); // 빨간 사과가 아닌 사과

        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 100) // 빨간 사과이면서 무게가 100보다 큰 사과
                .or(apple -> apple.getColor().equals("green")); // 또는 녹색 사과


    }

    static class Apple {
        private String color;
        private int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}

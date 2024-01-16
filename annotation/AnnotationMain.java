import java.util.Arrays;
import java.util.List;


@Food("apple")
@Food("banana")
public class AnnotationMain {
    public static void main(String[] args) throws @Food RuntimeException {
        List<@Food String> foods = List.of("apple", "banana", "cherry"); // @Target(ElementType.TYPE_USE)

        /**
         * 중복 어노테이션 가져오기
         */
        Food[] foods1 = AnnotationMain.class.getAnnotationsByType(Food.class);
        Arrays.stream(foods1)
                .forEach(f -> System.out.println(f.value()));


        // 컨테이너로 가져오기
        FoodContainer foodContainer = AnnotationMain.class.getAnnotation(FoodContainer.class);
        Arrays.stream(foodContainer.value())
                .forEach(f -> System.out.println(f.value()));
    }

    static class EatCake<@Food T> { // @Target(ElementType.TYPE_PARAMETER)
        public static <@Food F> void print(@Food F f) { // @Target(ElementType.TYPE_USE)

        }
    }

}

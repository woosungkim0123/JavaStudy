import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(FoodContainer.class)
public @interface Food {
    String value() default "apple";
}

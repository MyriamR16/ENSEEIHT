import java.lang.annotation.*;


/** Indicate that a class is a utility class and thus only defines
  * static methods Utility.
  */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
public @interface Utility {
}

import java.lang.reflect.Method;

public class AnnotationProc {
    public static void procAnn(Class<?> clas) {
        if (clas.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx ann = clas.getAnnotation(DeprecatedEx.class);
            System.out.println(clas.getSimpleName()+" устарел. "+ann.message());
        }
        for (Method method : clas.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx ann = method.getAnnotation(DeprecatedEx.class);
                System.out.println(method.getName()+" устарел. "+ann.message());
            }
        }
    }
}

import java.lang.reflect.Field;

public class JsonSer {
    public static String toJson(Object obj) {
        Class<?> clas = obj.getClass();
        Field[] fields = clas.getDeclaredFields();
        String trt="{";
        boolean flag=false;
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                
                if(flag)
                    trt+=",";
                else
                    flag=true;
                try {
                trt+="\"" + field.getAnnotation(JsonField.class).name() + "\": " + String.valueOf(field.get(obj));    
                } catch (Exception e) {
                    
                }
            }
        }
        return trt+"}";
    }
}

package Main;

import java.util.HashMap;

public class ObjectRegistry {
    HashMap<String , Object> map = new HashMap<>();

    public void register(String key , Object object){
        map.put(key , object);
    }

    public Object get(String key){
        return map.get(key);
    }
}

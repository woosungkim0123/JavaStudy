package flyweight.sub;

import java.util.HashMap;
import java.util.Map;

// FlyweightFactory
public class TreeModelFactory {

    private static final Map<String, TreeModel> cache = new HashMap<>(); // 나무 모델 객체 캐시

    public static TreeModel getInstance(String key) {
        // 만약 캐시 되어있다면
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // 캐시되어 있지 않다면 나무 모델 객체를 생성
        TreeModel treeModel = new TreeModel(key, new Object(), new Object());
        System.out.println(key + " 나무 모델 객체 생성 완료");

        cache.put(key, treeModel);

        return treeModel;
    }

    public static void clearCache() {
        cache.clear();
    }
}

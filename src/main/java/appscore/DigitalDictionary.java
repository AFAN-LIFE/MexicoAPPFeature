package appscore;

import java.util.Map;
import java.util.HashMap;

public class DigitalDictionary {
    // 这里使用静态Map模拟数字字典，你可以根据需要初始化数据
    private static final Map<String, Integer> APP_SCORES = new HashMap<>();

    static {
        // 初始化一些示例数据
        APP_SCORES.put("com.example.app1", 85);
        APP_SCORES.put("com.example.app2", 92);
        APP_SCORES.put("com.example.app3", 78);
        APP_SCORES.put("com.example.app4", 95);
        // 可以继续添加更多APP和对应的分数
    }

    /**
     * 根据APP名称获取分数
     * @param appName APP名称
     * @return 对应的分数，如果不存在则返回0
     */
    public static int getScore(String appName) {
        return APP_SCORES.getOrDefault(appName, 0);
    }

    /**
     * 添加或更新APP分数
     * @param appName APP名称
     * @param score 分数
     */
    public static void setScore(String appName, int score) {
        APP_SCORES.put(appName, score);
    }

    /**
     * 获取所有APP分数映射
     * @return 完整的分数映射
     */
    public static Map<String, Integer> getAllScores() {
        return new HashMap<>(APP_SCORES);
    }
}
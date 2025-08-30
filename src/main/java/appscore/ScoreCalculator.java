package appscore;

import java.util.List;
import java.util.Map;

public class ScoreCalculator {

    /**
     * 计算订单的分数统计
     * @param orderNo 订单号
     * @param appList APP列表
     * @return 包含订单号、总分和最高分的ScoreResult对象
     */
    public ScoreResult calculateScores(String orderNo, List<String> appList) {
        if (orderNo == null || orderNo.trim().isEmpty()) {
            throw new IllegalArgumentException("订单号不能为空");
        }

        if (appList == null || appList.isEmpty()) {
            throw new IllegalArgumentException("APP列表不能为空");
        }

        int totalScore = 0;
        int maxScore = Integer.MIN_VALUE;

        // 遍历APP列表，计算总分和最高分
        for (String app : appList) {
            int score = DigitalDictionary.getScore(app);
            totalScore += score;

            if (score > maxScore) {
                maxScore = score;
            }
        }

        // 如果列表为空，确保maxScore不为MIN_VALUE
        if (maxScore == Integer.MIN_VALUE) {
            maxScore = 0;
        }

        return new ScoreResult(orderNo, totalScore, maxScore);
    }

    /**
     * 批量计算多个订单的分数统计
     * @param orders 订单和APP列表的映射
     * @return 包含所有订单结果的列表
     */
    public List<ScoreResult> calculateBatchScores(Map<String, List<String>> orders) {
        return orders.entrySet().stream()
                .map(entry -> calculateScores(entry.getKey(), entry.getValue()))
                .collect(java.util.stream.Collectors.toList());
    }
}
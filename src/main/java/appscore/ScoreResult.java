package appscore;

public class ScoreResult {
    private String orderNo;
    private int totalScore;
    private int maxScore;

    public ScoreResult(String orderNo, int totalScore, int maxScore) {
        this.orderNo = orderNo;
        this.totalScore = totalScore;
        this.maxScore = maxScore;
    }

    // Getter 方法
    public String getOrderNo() { return orderNo; }
    public int getTotalScore() { return totalScore; }
    public int getMaxScore() { return maxScore; }

    @Override
    public String toString() {
        return "ScoreResult{orderNo='" + orderNo + "', totalScore=" + totalScore + ", maxScore=" + maxScore + "}";
    }
}
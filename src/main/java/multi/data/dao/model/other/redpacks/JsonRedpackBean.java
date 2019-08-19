package multi.data.dao.model.other.redpacks;


import java.util.List;

/**
 * 返现红包bean, 未映射到数据库
 */
public class JsonRedpackBean {

    private List<String> newerRedpacks;
    private List<RebateRedpacks> rebateRedpacks;
    private int totalNotUsedAmount;
    private int maxNotUsedAmount;
    private Result result;
    private int costTime;
    public void setNewerRedpacks(List<String> newerRedpacks) {
        this.newerRedpacks = newerRedpacks;
    }
    public List<String> getNewerRedpacks() {
        return newerRedpacks;
    }

    public void setRebateRedpacks(List<RebateRedpacks> rebateRedpacks) {
        this.rebateRedpacks = rebateRedpacks;
    }
    public List<RebateRedpacks> getRebateRedpacks() {
        return rebateRedpacks;
    }

    public void setTotalNotUsedAmount(int totalNotUsedAmount) {
        this.totalNotUsedAmount = totalNotUsedAmount;
    }
    public int getTotalNotUsedAmount() {
        return totalNotUsedAmount;
    }

    public void setMaxNotUsedAmount(int maxNotUsedAmount) {
        this.maxNotUsedAmount = maxNotUsedAmount;
    }
    public int getMaxNotUsedAmount() {
        return maxNotUsedAmount;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }
    public int getCostTime() {
        return costTime;
    }

}
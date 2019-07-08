package multi.data.dao.model.primary;

import javax.persistence.*;

/**
 * 删除用户营销红包记录, 提高测试重复模拟效率
 */

@Entity
@Table(name = "qu_user_redpacket")
public class QuUserRedpack {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "userid")   // tips:驼峰命名后,字段自动变成 user_id
    private int userId;

    @Column(name = "redpacketid")   // 红包ID
    private int redpacketId;

    @Column(name = "orderid")   // 关联的订单id
    private String orderId;

    @Column(name = "planid")   // 红包计划id
    private int planId;

    @Column(name = "planname")   // 计划名称
    private String planName;

    @Column(name = "poptype")   // 红包计划中展示位置
    private int popType;

    @Column(name = "scene")   // 红包使用场景
    private short scene;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRedpacketId() {
        return redpacketId;
    }

    public void setRedpacketId(int redpacketId) {
        this.redpacketId = redpacketId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getPopType() {
        return popType;
    }

    public void setPopType(int popType) {
        this.popType = popType;
    }

    public short getScene() {
        return scene;
    }

    public void setScene(short scene) {
        this.scene = scene;
    }
}

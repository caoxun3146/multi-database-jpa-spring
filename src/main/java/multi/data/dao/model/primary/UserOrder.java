package multi.data.dao.model.primary;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "qu_mall_client_user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_id")  // 外键字段 @JoinColumn与@Column不能同时用 除非将外键关联字段设成只读
    private Long userId;

    @Column(name = "tb_id")
    private String tbId;

    @Column(name = "phone_id")
    private String phoneId;


    @Column(name = "createtime")
    private Date createtime;

    @Column(name = "status") // byte ==  tinyint(2)  该订单是否导入 1已导入， 0未导入
    private byte status;

    @Column(name = "settle_status") // tinyint(1)  结算状态。0：待入账；1：已入账；2：已失效；3：定时任务置失效
    private boolean settleStatus;

    @Column(name = "from_mall") // 商城平台 0-其他 1-淘宝 2-京东 3-苏宁易购 4-国美
    private byte fromMall;

    @Column(name = "type") // 订单类型 1-点击推广商品跳转购买 2-点击跳转商城自由购买
    private byte type;

    @Column(name = "channel") // 订单上传时，渠道号
    private String channel;


    @Column(name = "cip") // 订单上传时，ip
    private String cip;

    @Column(name = "version")
    private Integer version;

    @Column(name = "version_name")
    private String versionName;

    @Column(name = "is_rebate") // 是否可以返利订单 0-否 1-是
    private Integer isRebate;

    /*@Column(name="path_id") // type : test - 订单来源
    private String pathId;*/

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "rebate_amount")
    private BigDecimal rebateAmount;

    @Column(name = "is_coupon_rebated")//是否已经返现0还没1已经返现
    private Integer isCouponRebated;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "is_machine") // 是否机选 1人选 2机选
    private Integer isMachine;

    @Column(name = "topic_id")//专题ID
    private Integer topicId;

    @Column(name = "activity_id")
    private String activityId;

    @Column(name = "source_path")
    private String sourcePath;

    @Column(name = "pro_father_source")
    private String proFatherSource;

    @Column(name = "rebate_money") // 返利金额
    private BigDecimal rebateMoney;

    @Column(name = "self_money") //返利金额(自己拆的部分)
    private BigDecimal selfMoney;

    @Column(name = "share_money") // 返利金额(还有帮拆的部分)
    private BigDecimal shareMoney;

    @Column(name = "rebate_type") //订单返利类型0是不直接返利订单，1是首单，2是0元购
    private byte rebateType;

    @Column(name = "is_money_rebate") // 是否已经返利了
    private byte isMoneyRebate;

/*    @Column(name="is_rebate_use") //是否已经被订单使用  , 数据为空导致异常
    private byte isRebateUse;*/

    @Column(name = "recommend_source_type")//推荐来源类型
    private String recommendSourceType;

    @Column(name = "is_old_user")
    private Integer isOldUser;

    @Column(name = "module_id")
    private Integer moduleId;

/*    @Column(name="request")
    private Clob request;*/

    @Column(name = "utime")
    private Date utime;

    @Column(name = "prdid")
    private String prdId;

    @Column(name = "redpack_money")//营销红包金额
    private BigDecimal redpackMoney;

    @Column(name = "redpack_id")//营销红包ID
    private Integer redpackId;

    @Column(name = "is_first_order") //是否用户首单，1是，0否
    private byte isFirstOrder;

    @Column(name = "settle_time") // 结算时间
    private Date settleTime;

    @Column(name = "is_match")//匹配客户端，服务器结果。空，1 表示已经匹配。0表示未匹配
    private byte isMatch;

    @Column(name = "redpack_total_money")//营销红包总金额
    private BigDecimal redpackTotalMoney;



    /*@JoinColumn(name="user_id",referencedColumnName="userid")//如果关联的不是连表的主键, 需要指明referencedColumnName关联account表的其它字段字段*/
    // 关联的实体对象通常是懒加载 FetchType.LAZY

    @ManyToOne(cascade = {CascadeType.DETACH})
    //CascadeType.DETACH   级联脱管/游离操作  ,如果你要删除一个实体，但是它有外键无法删除，你就需要这个级联权限了。它会撤销所有相关的外键关联。
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
// 由于同一个字段注解两次报错，解决办法是让一个注解字段设成只读 insertable=false,updatable=false

    //@JsonIgnore // 在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
    //@JsonIgnore
    private Account account;

    // 移除实体对象中的外键对象, 解除绑定关系
    public void clearUserOrder() {
        this.getAccount().getUserOrders().remove(this);
    }

    public UserOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    //@JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public boolean getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(boolean settleStatus) {
        this.settleStatus = settleStatus;
    }

    public byte getFromMall() {
        return fromMall;
    }

    public void setFromMall(byte fromMall) {
        this.fromMall = fromMall;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getIsRebate() {
        return isRebate;
    }

    public void setIsRebate(Integer isRebate) {
        this.isRebate = isRebate;
    }

/*    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }*/

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Integer getIsCouponRebated() {
        return isCouponRebated;
    }

    public void setIsCouponRebated(Integer isCouponRebated) {

        this.isCouponRebated = isCouponRebated;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getIsMachine() {
        return isMachine;
    }

    public void setIsMachine(Integer isMachine) {
        this.isMachine = isMachine;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getProFatherSource() {
        return proFatherSource;
    }

    public void setProFatherSource(String proFatherSource) {
        this.proFatherSource = proFatherSource;
    }

    public BigDecimal getRebateMoney() {
        return rebateMoney;
    }

    public void setRebateMoney(BigDecimal rebateMoney) {
        this.rebateMoney = rebateMoney;
    }

    public BigDecimal getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(BigDecimal selfMoney) {
        this.selfMoney = selfMoney;
    }

    public BigDecimal getShareMoney() {
        return shareMoney;
    }

    public void setShareMoney(BigDecimal shareMoney) {
        this.shareMoney = shareMoney;
    }

    public byte getRebateType() {
        return rebateType;
    }

    public void setRebateType(byte rebateType) {
        this.rebateType = rebateType;
    }

    public byte getIsMoneyRebate() {
        return isMoneyRebate;
    }

    public void setIsMoneyRebate(byte isMoneyRebate) {
        this.isMoneyRebate = isMoneyRebate;
    }

 /*   public byte getIsRebateUse() {
        return isRebateUse;
    }

    public void setIsRebateUse(byte isRebateUse) {
            this.isRebateUse = isRebateUse;
    }*/

    public String getRecommendSourceType() {
        return recommendSourceType;
    }

    public void setRecommendSourceType(String recommendSourceType) {
        this.recommendSourceType = recommendSourceType;
    }

    public Integer getIsOldUser() {
        return isOldUser;
    }

    public void setIsOldUser(Integer isOldUser) {
        this.isOldUser = isOldUser;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

   /* public Clob getRequest() {
        return request;
    }

    public void setRequest(Clob request) {
        this.request = request;
    }*/

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public BigDecimal getRedpackMoney() {
        return redpackMoney;
    }

    public void setRedpackMoney(BigDecimal redpackMoney) {
        this.redpackMoney = redpackMoney;
    }

    public Integer getRedpackId() {
        return redpackId;
    }

    public void setRedpackId(Integer redpackId) {
        this.redpackId = redpackId;
    }

    public byte getIsFirstOrder() {
        return isFirstOrder;
    }

    public void setIsFirstOrder(byte isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public byte getIsMatch() {
        return isMatch;
    }

    public void setIsMatch(byte isMatch) {
        this.isMatch = isMatch;
    }

    public BigDecimal getRedpackTotalMoney() {
        return redpackTotalMoney;
    }

    public void setRedpackTotalMoney(BigDecimal redpackTotalMoney) {
        this.redpackTotalMoney = redpackTotalMoney;
    }
}

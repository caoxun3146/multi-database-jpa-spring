package multi.data.dao.model.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qu_mall_alimama_order")
public class AlimamaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "click_time")  // 点击时间
    private Date clickTime = new Date();

    @Column(name = "product_info") //商品信息  -- 【狂欢价】WRZ X6适用手机苹果华为oppo小米vivo耳麦电脑女生韩版可爱男入耳耳塞挂耳式跑步运动耳机K歌吃鸡有
    private String productInfo;

    @Column(name = "product_id") // 商品ID
    private Long productId;

    @Column(name = "shopkeeper_aliwangwang") // 掌柜旺旺 -- 华胜天齐数码专营店
    private String shopkeeperAliwangwang;

    @Column(name = "store") //所属店铺 -- 华胜天齐数码专营店
    private String store;

    @Column(name = "product_number") // -- 1
    private int productNumber;

    @Column(name = "product_unit_price") // -- 88.00
    private String productUnitPrice;

    @Column(name = "order_status") //订单状态 -- 订单付款
    private String orderStatus;

    @Column(name = "order_type")   // 订单类型  -- 天猫
    private String orderType;

    @Column(name = "income_ratio") //收入比率   -- 30.01 %
    private String incomeRatio;

    @Column(name = "separate_ratio") //分成比率   -- 100.00 %
    private String separateRatio;

    @Column(name = "payment_money") // 付款金额   -- 19.9900
    private String paymentMoney;

    @Column(name = "result_estimate") // 效果预估   -- 6.00
    private String resultEstimate;

    @Column(name = "clearing_money") //结算金额  -- 0.00
    private String clearingMoney;

    @Column(name = "estimate_income")//预估收入  -- 0.00
    private String estimateIncome;

    @Column(name = "commission_ratio") //佣金比率  -- 30.01 %
    private String commissionRatio;

    @Column(name = "commission_money")  // -- 0
    private String commissionMoney;

    @Column(name = "subsidy_ratio")  // -- 0.00 %
    private String subsidyRatio;

    @Column(name = "subsidy_money")//补贴金额  -- 0
    private String subsidyMoney;

    @Column(name = "subsidy_type")//补贴类型  -
    private String subsidyType;

    @Column(name = "result_platform")//成交平台   --- 无线
    private String resultPlatform;

    @Column(name = "third_party_source") // 第三方服务来源  --
    private String thirdPartySource;

    @Column(name = "order_id")//订单编号
    private String orderId;

    @Column(name = "class_name")//类目名称   --- 影音电器
    private String className;

    @Column(name = "source_media_id")//来源媒体id  --- 45368612
    private String sourceMediaId;

    @Column(name = "source_media_name")//来源媒体名称  -- 趣专享
    private String sourceMediaName;

    @Column(name = "advertising_id") //广告位id  --  23950950016
    private String advertisingId;

    @Column(name = "advertising_name") //广告位名称  --  趣专享高佣
    private String advertisingName;

    @Column(name = "right_order_id")
    private String rightOrderId;

    @Column(name = "compare_time")
    private Date compareTime;

    @Column(name = "utime")
    private Date utime;

    @Column(name = "status")  // 0
    private int status;

    public AlimamaOrder() {
    }

    public AlimamaOrder(Date createTime, Date clickTime, String productInfo, Long productId, String shopkeeperAliwangwang, String store, int productNumber, String productUnitPrice, String orderStatus, String orderType, String incomeRatio, String separateRatio, String paymentMoney, String resultEstimate, String clearingMoney, String estimateIncome, String commissionRatio, String commissionMoney, String subsidyRatio, String subsidyMoney, String subsidyType, String resultPlatform, String thirdPartySource, String orderId, String className, String sourceMediaId, String sourceMediaName, String advertisingId, String advertisingName, String rightOrderId, Date compareTime, Date utime, int status) {
        this.createTime = createTime;
        this.clickTime = clickTime;
        this.productInfo = productInfo;
        this.productId = productId;
        this.shopkeeperAliwangwang = shopkeeperAliwangwang;
        this.store = store;
        this.productNumber = productNumber;
        this.productUnitPrice = productUnitPrice;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.incomeRatio = incomeRatio;
        this.separateRatio = separateRatio;
        this.paymentMoney = paymentMoney;
        this.resultEstimate = resultEstimate;
        this.clearingMoney = clearingMoney;
        this.estimateIncome = estimateIncome;
        this.commissionRatio = commissionRatio;
        this.commissionMoney = commissionMoney;
        this.subsidyRatio = subsidyRatio;
        this.subsidyMoney = subsidyMoney;
        this.subsidyType = subsidyType;
        this.resultPlatform = resultPlatform;
        this.thirdPartySource = thirdPartySource;
        this.orderId = orderId;
        this.className = className;
        this.sourceMediaId = sourceMediaId;
        this.sourceMediaName = sourceMediaName;
        this.advertisingId = advertisingId;
        this.advertisingName = advertisingName;
        this.rightOrderId = rightOrderId;
        this.compareTime = compareTime;
        this.utime = utime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getShopkeeperAliwangwang() {
        return shopkeeperAliwangwang;
    }

    public void setShopkeeperAliwangwang(String shopkeeperAliwangwang) {
        this.shopkeeperAliwangwang = shopkeeperAliwangwang;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIncomeRatio() {
        return incomeRatio;
    }

    public void setIncomeRatio(String incomeRatio) {
        this.incomeRatio = incomeRatio;
    }

    public String getSeparateRatio() {
        return separateRatio;
    }

    public void setSeparateRatio(String separateRatio) {
        this.separateRatio = separateRatio;
    }

    public String getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(String paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getResultEstimate() {
        return resultEstimate;
    }

    public void setResultEstimate(String resultEstimate) {
        this.resultEstimate = resultEstimate;
    }

    public String getClearingMoney() {
        return clearingMoney;
    }

    public void setClearingMoney(String clearingMoney) {
        this.clearingMoney = clearingMoney;
    }

    public String getEstimateIncome() {
        return estimateIncome;
    }

    public void setEstimateIncome(String estimateIncome) {
        this.estimateIncome = estimateIncome;
    }

    public String getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(String commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public String getCommissionMoney() {
        return commissionMoney;
    }

    public void setCommissionMoney(String commissionMoney) {
        this.commissionMoney = commissionMoney;
    }

    public String getSubsidyRatio() {
        return subsidyRatio;
    }

    public void setSubsidyRatio(String subsidyRatio) {
        this.subsidyRatio = subsidyRatio;
    }

    public String getSubsidyMoney() {
        return subsidyMoney;
    }

    public void setSubsidyMoney(String subsidyMoney) {
        this.subsidyMoney = subsidyMoney;
    }

    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
    }

    public String getResultPlatform() {
        return resultPlatform;
    }

    public void setResultPlatform(String resultPlatform) {
        this.resultPlatform = resultPlatform;
    }

    public String getThirdPartySource() {
        return thirdPartySource;
    }

    public void setThirdPartySource(String thirdPartySource) {
        this.thirdPartySource = thirdPartySource;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSourceMediaId() {
        return sourceMediaId;
    }

    public void setSourceMediaId(String sourceMediaId) {
        this.sourceMediaId = sourceMediaId;
    }

    public String getSourceMediaName() {
        return sourceMediaName;
    }

    public void setSourceMediaName(String sourceMediaName) {
        this.sourceMediaName = sourceMediaName;
    }

    public String getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(String advertisingId) {
        this.advertisingId = advertisingId;
    }

    public String getAdvertisingName() {
        return advertisingName;
    }

    public void setAdvertisingName(String advertisingName) {
        this.advertisingName = advertisingName;
    }

    public String getRightOrderId() {
        return rightOrderId;
    }

    public void setRightOrderId(String rightOrderId) {
        this.rightOrderId = rightOrderId;
    }

    public Date getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(Date compareTime) {
        this.compareTime = compareTime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

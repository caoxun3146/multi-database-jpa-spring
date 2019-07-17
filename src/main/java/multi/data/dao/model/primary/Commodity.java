package multi.data.dao.model.primary;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "qu_mall_product_info")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "coupon_final_price")
    private Float couponFinalPrice;

    @Column(name = "tk_rate")
    private String tkRate;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "title")
    private String title;

    public Commodity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCouponFinalPrice() {
        return couponFinalPrice;
    }

    public void setCouponFinalPrice(Float couponFinalPrice) {
        this.couponFinalPrice = couponFinalPrice;
    }

    public String getTkRate() {
        return tkRate;
    }

    public void setTkRate(String tkRate) {
        this.tkRate = tkRate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

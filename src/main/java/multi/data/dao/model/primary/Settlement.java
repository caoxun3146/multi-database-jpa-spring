package multi.data.dao.model.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qu_mall_settle_order")
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_status")
    private String order_status;

    @Column(name = "settle_status")
    private short settle_status;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "clearing_time")
    private Date clearing_time;

    @Column(name = "ctime")
    private Date ctime;

    @Column(name = "utime")
    private Date utime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public short getSettle_status() {
        return settle_status;
    }

    public void setSettle_status(short settle_status) {
        this.settle_status = settle_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getClearing_time() {
        return clearing_time;
    }

    public void setClearing_time(Date clearing_time) {
        this.clearing_time = clearing_time;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }


    public Settlement() {
        // 如果已经创建了其它构造函数, 那么必须创建默认构造函数
    }

    public Settlement(String orderId, String order_status, short settle_status, Date create_time, Date clearing_time, Date ctime, Date utime) {
        this.orderId = orderId;
        this.order_status = order_status;
        this.settle_status = settle_status;
        this.create_time = create_time;
        this.clearing_time = clearing_time;
        this.ctime = ctime;
        this.utime = utime;
    }
}

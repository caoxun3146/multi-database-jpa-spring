package multi.data.dao.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "qu_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tb_id") //淘宝ID
    private String tbId;

    @Column(name = "phone_id")
    private String phoneId;

    @Column(name = "prdid")
    private String prdId;

    @Column(name = "status") // byte ==  tinyint(2)
    private byte status;

    @Column(name = "union_id")
    private String unionId;



    public Account() {

    }


    @OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    /*@OneToMany(targetEntity = Account.class,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")//注释的是另一个表指向本表的外键。*/
    //简化被动方,手动维护外键ID
    @JsonIgnore // 在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
    private List<UserOrder> userOrders = new ArrayList<>();

    public void addAccount(UserOrder userOrder) {
        userOrder.setAccount(this);
        userOrders.add(userOrder);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId;
    }


    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }


    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    //@JsonIgnore
    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }


}

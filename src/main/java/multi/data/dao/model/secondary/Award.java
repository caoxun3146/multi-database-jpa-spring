package multi.data.dao.model.secondary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "qu_activity_viewproduct_award")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @Column(name = "phone_id") // 设备号
    private String phoneId;

    @Column(name = "create_time") // 创建时间
    private Date createTime;

    @Column(name = "receive_count") // 今日领取次数
    private byte receiveCount;

    @Column(name = "cashbeans_sum")  // 今日已领取现金豆数量
    private Integer cashbeansSum;

    public Award (){

    }


}

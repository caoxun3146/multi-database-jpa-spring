package multi.data.dao.model.primary;

import javax.persistence.*;

/**
 * 首页瀑布 设备领1元红包资格登记表 update
 */

@Entity
@Table(name = "qu_activity_new_user_redpack")
public class UserRedpack {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "userid")   // tips:驼峰命名后,字段自动变成 user_id
    private int userId;

    @Column(name = "phoneid", columnDefinition = "varchar(100)")
    private String phoneId;

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

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }
}

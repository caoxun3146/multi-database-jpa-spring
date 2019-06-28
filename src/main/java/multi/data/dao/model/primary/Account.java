package multi.data.dao.model.primary;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

    public Account() {

    }

}

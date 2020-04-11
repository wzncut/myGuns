package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * mooc数据结果
 * </p>
 *
 * @author stylefeng
 * @since 2020-03-27
 */
@TableName("mooc_visual")
public class Visual extends Model<Visual> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String sources;
    private String target;
    private String sup;
    private String conf;
    private Integer catycray;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public Integer getCatycray() {
        return catycray;
    }

    public void setCatycray(Integer catycray) {
        this.catycray = catycray;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Visual{" +
        ", id=" + id +
        ", sources=" + sources +
        ", target=" + target +
        ", sup=" + sup +
        ", conf=" + conf +
        ", catycray=" + catycray +
        "}";
    }
}

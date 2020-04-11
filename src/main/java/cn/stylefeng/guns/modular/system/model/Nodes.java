package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2020-03-27
 */
@TableName("mooc_nodes")
public class Nodes extends Model<Nodes> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String projectid;
    private String projectname;
    private Integer projectcount;
    private Integer catycray;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Integer getProjectcount() {
        return projectcount;
    }

    public void setProjectcount(Integer projectcount) {
        this.projectcount = projectcount;
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
        return "Nodes{" +
        ", id=" + id +
        ", projectid=" + projectid +
        ", projectname=" + projectname +
        ", projectcount=" + projectcount +
        ", catycray=" + catycray +
        "}";
    }
}

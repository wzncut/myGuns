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
 * @since 2020-01-12
 */
@TableName("sys_test1")
public class Test1 extends Model<Test1> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "aaa", type = IdType.AUTO)
    private Integer aaa;
    private String bbb;


    public Integer getAaa() {
        return aaa;
    }

    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    @Override
    protected Serializable pkVal() {
        return this.aaa;
    }

    @Override
    public String toString() {
        return "Test1{" +
        ", aaa=" + aaa +
        ", bbb=" + bbb +
        "}";
    }
}

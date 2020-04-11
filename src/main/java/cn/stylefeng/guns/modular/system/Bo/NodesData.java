package cn.stylefeng.guns.modular.system.Bo;

import lombok.Data;

@Data
public class NodesData {
    /**
     * 分组
     */
    private Integer category;
    private String name;
    /**
     * count
     */
    private Integer value;
    /**
     * count*10
     */
    private Integer symbolSize;
}

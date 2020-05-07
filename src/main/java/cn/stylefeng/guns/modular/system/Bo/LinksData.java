package cn.stylefeng.guns.modular.system.Bo;

import lombok.Data;

@Data
public class LinksData {
    private String source;
    private String target;
    private double value;
    private LineStyle lineStyle;
}

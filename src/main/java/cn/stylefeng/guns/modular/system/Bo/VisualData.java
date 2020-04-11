package cn.stylefeng.guns.modular.system.Bo;

import lombok.Data;

import java.util.List;

@Data
public class VisualData {
    private List<NodesData> nodes;
    private List<LinksData> links;
}

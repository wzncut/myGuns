package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Order;
import cn.stylefeng.guns.modular.system.dao.OrderMapper;
import cn.stylefeng.guns.modular.system.service.IOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2020-03-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}

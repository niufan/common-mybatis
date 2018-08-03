package site.niufan.common.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.niufan.common.mybatis.dal.mapper.CommonMapper;
import site.niufan.common.mybatis.service.CommonService;

/**
 * @author Fan Niu
 * @since 2018/8/3
 */
public class CommonServiceImpl<M extends CommonMapper<T>, T> extends ServiceImpl<M, T> implements CommonService<T> {
}

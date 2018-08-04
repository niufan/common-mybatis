package site.niufan.common.mybatis.dal.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * @author Fan Niu
 * @since 2018/8/4
 */
public class TemplateEntity<PK extends Serializable, T extends TemplateEntity> extends Model<T> {

    protected PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

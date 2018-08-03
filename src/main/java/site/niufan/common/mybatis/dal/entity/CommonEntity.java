package site.niufan.common.mybatis.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 通用实体
 * @author Fan Niu
 * @since 2018/8/3
 */
public class CommonEntity<PK extends Serializable, T extends CommonEntity> extends Model<T> {

    @TableId(value = "ID", type = IdType.UUID)
    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}

package site.niufan.common.mybatis.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 全局唯一ID 实体
 * @author Fan Niu
 * @since 2018/8/4
 */
public class UUIDEntity<T extends UUIDEntity> extends TemplateEntity<String, T> {

    @TableId(value = "ID", type = IdType.UUID)
    protected String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}

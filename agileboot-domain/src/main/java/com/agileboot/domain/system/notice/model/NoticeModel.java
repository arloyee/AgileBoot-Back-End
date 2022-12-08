package com.agileboot.domain.system.notice.model;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.domain.system.notice.command.NoticeUpdateCommand;
import com.agileboot.orm.entity.SysNoticeEntity;
import com.agileboot.orm.enums.dictionary.NoticeTypeEnum;
import com.agileboot.orm.enums.dictionary.StatusEnum;
import com.agileboot.orm.enums.interfaces.BasicEnumUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author valarchie
 */
@Data
@NoArgsConstructor
public class NoticeModel extends SysNoticeEntity {

    public NoticeModel(SysNoticeEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

    public void loadUpdateCommand(NoticeUpdateCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this);
        }
    }

    public void checkFields() {
        BasicEnumUtil.fromValue(NoticeTypeEnum.class, getNoticeType());
        BasicEnumUtil.fromValue(StatusEnum.class, getStatus());
    }

}

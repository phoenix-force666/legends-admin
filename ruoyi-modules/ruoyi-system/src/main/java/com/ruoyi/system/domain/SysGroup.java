package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_group
 * 
 * @author herion
 * @date 2020-11-25
 */
public class SysGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组ID */
    private Integer groupId;

    /** 组名称 */
    @Excel(name = "组名称")
    private String groupName;

    /** 组类型（0：系统组，1：流程引擎组，2：API组） */
    @Excel(name = "组类型", readConverterExp = "0=：系统组，1：流程引擎组，2：API组")
    private Integer groupType;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private Long updateUser;

    public void setGroupId(Integer groupId) 
    {
        this.groupId = groupId;
    }

    public Integer getGroupId() 
    {
        return groupId;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setGroupType(Integer groupType) 
    {
        this.groupType = groupType;
    }

    public Integer getGroupType() 
    {
        return groupType;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateUser(Long updateUser) 
    {
        this.updateUser = updateUser;
    }

    public Long getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupId", getGroupId())
            .append("groupName", getGroupName())
            .append("groupType", getGroupType())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

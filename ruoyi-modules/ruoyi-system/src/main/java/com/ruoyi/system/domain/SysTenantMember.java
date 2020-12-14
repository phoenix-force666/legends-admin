package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 租户成员（用户/组）对象 sys_tenant_member
 * 
 * @author herion
 * @date 2020-11-25
 */
public class SysTenantMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租户用户/组关联ID */
    @Excel(name = "租户用户/组关联ID")
    private Long tenantMemberId;

    /** 租户ID */
    @Excel(name = "租户ID")
    private Integer tenantId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 组ID */
    @Excel(name = "组ID")
    private Integer groupId;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private Long updateUser;

    public void setTenantMemberId(Long tenantMemberId) 
    {
        this.tenantMemberId = tenantMemberId;
    }

    public Long getTenantMemberId() 
    {
        return tenantMemberId;
    }
    public void setTenantId(Integer tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Integer getTenantId() 
    {
        return tenantId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setGroupId(Integer groupId) 
    {
        this.groupId = groupId;
    }

    public Integer getGroupId() 
    {
        return groupId;
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
            .append("tenantMemberId", getTenantMemberId())
            .append("tenantId", getTenantId())
            .append("userId", getUserId())
            .append("groupId", getGroupId())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

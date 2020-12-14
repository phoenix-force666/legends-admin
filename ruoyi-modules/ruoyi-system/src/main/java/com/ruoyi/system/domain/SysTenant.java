package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 租户对象 sys_tenant
 * 
 * @author herion
 * @date 2020-11-25
 */
public class SysTenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租户id */
    private Integer tenantId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer tenantType;

    /** 租户名称 */
    @Excel(name = "租户名称")
    private String tenantName;

    /** 租户描述 */
    @Excel(name = "租户描述")
    private String tenantDesc;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private Long updateUser;

    public void setTenantId(Integer tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Integer getTenantId() 
    {
        return tenantId;
    }
    public void setTenantType(Integer tenantType) 
    {
        this.tenantType = tenantType;
    }

    public Integer getTenantType() 
    {
        return tenantType;
    }
    public void setTenantName(String tenantName) 
    {
        this.tenantName = tenantName;
    }

    public String getTenantName() 
    {
        return tenantName;
    }
    public void setTenantDesc(String tenantDesc) 
    {
        this.tenantDesc = tenantDesc;
    }

    public String getTenantDesc() 
    {
        return tenantDesc;
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
            .append("tenantId", getTenantId())
            .append("tenantType", getTenantType())
            .append("tenantName", getTenantName())
            .append("tenantDesc", getTenantDesc())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

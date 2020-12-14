package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTenant;

/**
 * 租户Mapper接口
 * 
 * @author herion
 * @date 2020-11-25
 */
public interface SysTenantMapper 
{
    /**
     * 查询租户
     * 
     * @param tenantId 租户ID
     * @return 租户
     */
    public SysTenant selectSysTenantById(Integer tenantId);

    /**
     * 查询租户列表
     * 
     * @param sysTenant 租户
     * @return 租户集合
     */
    public List<SysTenant> selectSysTenantList(SysTenant sysTenant);

    /**
     * 新增租户
     * 
     * @param sysTenant 租户
     * @return 结果
     */
    public int insertSysTenant(SysTenant sysTenant);

    /**
     * 修改租户
     * 
     * @param sysTenant 租户
     * @return 结果
     */
    public int updateSysTenant(SysTenant sysTenant);

    /**
     * 删除租户
     * 
     * @param tenantId 租户ID
     * @return 结果
     */
    public int deleteSysTenantById(Integer tenantId);

    /**
     * 批量删除租户
     * 
     * @param tenantIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTenantByIds(Integer[] tenantIds);
}

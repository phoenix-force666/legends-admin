package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTenant;

/**
 * 租户Service接口
 * 
 * @author herion
 * @date 2020-11-25
 */
public interface ISysTenantService 
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
     * 批量删除租户
     * 
     * @param tenantIds 需要删除的租户ID
     * @return 结果
     */
    public int deleteSysTenantByIds(Integer[] tenantIds);

    /**
     * 删除租户信息
     * 
     * @param tenantId 租户ID
     * @return 结果
     */
    public int deleteSysTenantById(Integer tenantId);
}

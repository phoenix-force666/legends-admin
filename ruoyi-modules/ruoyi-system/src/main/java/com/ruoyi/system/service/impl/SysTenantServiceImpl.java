package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTenantMapper;
import com.ruoyi.system.domain.SysTenant;
import com.ruoyi.system.service.ISysTenantService;

/**
 * 租户Service业务层处理
 * 
 * @author herion
 * @date 2020-11-25
 */
@Service
public class SysTenantServiceImpl implements ISysTenantService 
{
    @Autowired
    private SysTenantMapper sysTenantMapper;

    /**
     * 查询租户
     * 
     * @param tenantId 租户ID
     * @return 租户
     */
    @Override
    public SysTenant selectSysTenantById(Integer tenantId)
    {
        return sysTenantMapper.selectSysTenantById(tenantId);
    }

    /**
     * 查询租户列表
     * 
     * @param sysTenant 租户
     * @return 租户
     */
    @Override
    public List<SysTenant> selectSysTenantList(SysTenant sysTenant)
    {
        return sysTenantMapper.selectSysTenantList(sysTenant);
    }

    /**
     * 新增租户
     * 
     * @param sysTenant 租户
     * @return 结果
     */
    @Override
    public int insertSysTenant(SysTenant sysTenant)
    {
        sysTenant.setCreateTime(DateUtils.getNowDate());
        return sysTenantMapper.insertSysTenant(sysTenant);
    }

    /**
     * 修改租户
     * 
     * @param sysTenant 租户
     * @return 结果
     */
    @Override
    public int updateSysTenant(SysTenant sysTenant)
    {
        sysTenant.setUpdateTime(DateUtils.getNowDate());
        return sysTenantMapper.updateSysTenant(sysTenant);
    }

    /**
     * 批量删除租户
     * 
     * @param tenantIds 需要删除的租户ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantByIds(Integer[] tenantIds)
    {
        return sysTenantMapper.deleteSysTenantByIds(tenantIds);
    }

    /**
     * 删除租户信息
     * 
     * @param tenantId 租户ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantById(Integer tenantId)
    {
        return sysTenantMapper.deleteSysTenantById(tenantId);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTenantMemberMapper;
import com.ruoyi.system.domain.SysTenantMember;
import com.ruoyi.system.service.ISysTenantMemberService;

/**
 * 租户成员（用户/组）Service业务层处理
 * 
 * @author herion
 * @date 2020-11-25
 */
@Service
public class SysTenantMemberServiceImpl implements ISysTenantMemberService 
{
    @Autowired
    private SysTenantMemberMapper sysTenantMemberMapper;

    /**
     * 查询租户成员（用户/组）
     * 
     * @param tenantMemberId 租户成员（用户/组）ID
     * @return 租户成员（用户/组）
     */
    @Override
    public SysTenantMember selectSysTenantMemberById(Long tenantMemberId)
    {
        return sysTenantMemberMapper.selectSysTenantMemberById(tenantMemberId);
    }

    /**
     * 查询租户成员（用户/组）列表
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 租户成员（用户/组）
     */
    @Override
    public List<SysTenantMember> selectSysTenantMemberList(SysTenantMember sysTenantMember)
    {
        return sysTenantMemberMapper.selectSysTenantMemberList(sysTenantMember);
    }

    /**
     * 新增租户成员（用户/组）
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 结果
     */
    @Override
    public int insertSysTenantMember(SysTenantMember sysTenantMember)
    {
        sysTenantMember.setCreateTime(DateUtils.getNowDate());
        return sysTenantMemberMapper.insertSysTenantMember(sysTenantMember);
    }

    /**
     * 修改租户成员（用户/组）
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 结果
     */
    @Override
    public int updateSysTenantMember(SysTenantMember sysTenantMember)
    {
        sysTenantMember.setUpdateTime(DateUtils.getNowDate());
        return sysTenantMemberMapper.updateSysTenantMember(sysTenantMember);
    }

    /**
     * 批量删除租户成员（用户/组）
     * 
     * @param tenantMemberIds 需要删除的租户成员（用户/组）ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantMemberByIds(Long[] tenantMemberIds)
    {
        return sysTenantMemberMapper.deleteSysTenantMemberByIds(tenantMemberIds);
    }

    /**
     * 删除租户成员（用户/组）信息
     * 
     * @param tenantMemberId 租户成员（用户/组）ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantMemberById(Long tenantMemberId)
    {
        return sysTenantMemberMapper.deleteSysTenantMemberById(tenantMemberId);
    }
}

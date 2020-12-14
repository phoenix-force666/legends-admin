package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTenantMember;

/**
 * 租户成员（用户/组）Service接口
 * 
 * @author herion
 * @date 2020-11-25
 */
public interface ISysTenantMemberService 
{
    /**
     * 查询租户成员（用户/组）
     * 
     * @param tenantMemberId 租户成员（用户/组）ID
     * @return 租户成员（用户/组）
     */
    public SysTenantMember selectSysTenantMemberById(Long tenantMemberId);

    /**
     * 查询租户成员（用户/组）列表
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 租户成员（用户/组）集合
     */
    public List<SysTenantMember> selectSysTenantMemberList(SysTenantMember sysTenantMember);

    /**
     * 新增租户成员（用户/组）
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 结果
     */
    public int insertSysTenantMember(SysTenantMember sysTenantMember);

    /**
     * 修改租户成员（用户/组）
     * 
     * @param sysTenantMember 租户成员（用户/组）
     * @return 结果
     */
    public int updateSysTenantMember(SysTenantMember sysTenantMember);

    /**
     * 批量删除租户成员（用户/组）
     * 
     * @param tenantMemberIds 需要删除的租户成员（用户/组）ID
     * @return 结果
     */
    public int deleteSysTenantMemberByIds(Long[] tenantMemberIds);

    /**
     * 删除租户成员（用户/组）信息
     * 
     * @param tenantMemberId 租户成员（用户/组）ID
     * @return 结果
     */
    public int deleteSysTenantMemberById(Long tenantMemberId);
}

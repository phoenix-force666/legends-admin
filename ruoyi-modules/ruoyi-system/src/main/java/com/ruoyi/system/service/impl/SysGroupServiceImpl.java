package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGroupMapper;
import com.ruoyi.system.domain.SysGroup;
import com.ruoyi.system.service.ISysGroupService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author herion
 * @date 2020-11-25
 */
@Service
public class SysGroupServiceImpl implements ISysGroupService 
{
    @Autowired
    private SysGroupMapper sysGroupMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param groupId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SysGroup selectSysGroupById(Integer groupId)
    {
        return sysGroupMapper.selectSysGroupById(groupId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysGroup> selectSysGroupList(SysGroup sysGroup)
    {
        return sysGroupMapper.selectSysGroupList(sysGroup);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysGroup(SysGroup sysGroup)
    {
        sysGroup.setCreateTime(DateUtils.getNowDate());
        return sysGroupMapper.insertSysGroup(sysGroup);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysGroup(SysGroup sysGroup)
    {
        sysGroup.setUpdateTime(DateUtils.getNowDate());
        return sysGroupMapper.updateSysGroup(sysGroup);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param groupIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSysGroupByIds(Integer[] groupIds)
    {
        return sysGroupMapper.deleteSysGroupByIds(groupIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param groupId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSysGroupById(Integer groupId)
    {
        return sysGroupMapper.deleteSysGroupById(groupId);
    }
}

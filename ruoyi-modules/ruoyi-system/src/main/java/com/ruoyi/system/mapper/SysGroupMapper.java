package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGroup;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author herion
 * @date 2020-11-25
 */
public interface SysGroupMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param groupId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SysGroup selectSysGroupById(Integer groupId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysGroup> selectSysGroupList(SysGroup sysGroup);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 结果
     */
    public int insertSysGroup(SysGroup sysGroup);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysGroup 【请填写功能名称】
     * @return 结果
     */
    public int updateSysGroup(SysGroup sysGroup);

    /**
     * 删除【请填写功能名称】
     * 
     * @param groupId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSysGroupById(Integer groupId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param groupIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysGroupByIds(Integer[] groupIds);
}

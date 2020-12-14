package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.system.domain.SysGroup;
import com.ruoyi.system.service.ISysGroupService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author herion
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/group")
public class SysGroupController extends BaseController
{
    @Autowired
    private ISysGroupService sysGroupService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize(hasPermi = "system:group:list")
    @GetMapping("/list")
    public TableDataInfo list(SysGroup sysGroup)
    {
        startPage();
        List<SysGroup> list = sysGroupService.selectSysGroupList(sysGroup);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize(hasPermi = "system:group:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysGroup sysGroup) throws IOException
    {
        List<SysGroup> list = sysGroupService.selectSysGroupList(sysGroup);
        ExcelUtil<SysGroup> util = new ExcelUtil<SysGroup>(SysGroup.class);
        util.exportExcel(response, list, "group");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize(hasPermi = "system:group:query")
    @GetMapping(value = "/{groupId}")
    public AjaxResult getInfo(@PathVariable("groupId") Integer groupId)
    {
        return AjaxResult.success(sysGroupService.selectSysGroupById(groupId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize(hasPermi = "system:group:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGroup sysGroup)
    {
        return toAjax(sysGroupService.insertSysGroup(sysGroup));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize(hasPermi = "system:group:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGroup sysGroup)
    {
        return toAjax(sysGroupService.updateSysGroup(sysGroup));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize(hasPermi = "system:group:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupIds}")
    public AjaxResult remove(@PathVariable Integer[] groupIds)
    {
        return toAjax(sysGroupService.deleteSysGroupByIds(groupIds));
    }
}

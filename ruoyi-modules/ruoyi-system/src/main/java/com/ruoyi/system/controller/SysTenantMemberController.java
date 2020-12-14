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
import com.ruoyi.system.domain.SysTenantMember;
import com.ruoyi.system.service.ISysTenantMemberService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 租户成员（用户/组）Controller
 * 
 * @author herion
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/member")
public class SysTenantMemberController extends BaseController
{
    @Autowired
    private ISysTenantMemberService sysTenantMemberService;

    /**
     * 查询租户成员（用户/组）列表
     */
    @PreAuthorize(hasPermi = "system:member:list")
    @GetMapping("/list")
    public TableDataInfo list(SysTenantMember sysTenantMember)
    {
        startPage();
        List<SysTenantMember> list = sysTenantMemberService.selectSysTenantMemberList(sysTenantMember);
        return getDataTable(list);
    }

    /**
     * 导出租户成员（用户/组）列表
     */
    @PreAuthorize(hasPermi = "system:member:export")
    @Log(title = "租户成员（用户/组）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTenantMember sysTenantMember) throws IOException
    {
        List<SysTenantMember> list = sysTenantMemberService.selectSysTenantMemberList(sysTenantMember);
        ExcelUtil<SysTenantMember> util = new ExcelUtil<SysTenantMember>(SysTenantMember.class);
        util.exportExcel(response, list, "member");
    }

    /**
     * 获取租户成员（用户/组）详细信息
     */
    @PreAuthorize(hasPermi = "system:member:query")
    @GetMapping(value = "/{tenantMemberId}")
    public AjaxResult getInfo(@PathVariable("tenantMemberId") Long tenantMemberId)
    {
        return AjaxResult.success(sysTenantMemberService.selectSysTenantMemberById(tenantMemberId));
    }

    /**
     * 新增租户成员（用户/组）
     */
    @PreAuthorize(hasPermi = "system:member:add")
    @Log(title = "租户成员（用户/组）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTenantMember sysTenantMember)
    {
        return toAjax(sysTenantMemberService.insertSysTenantMember(sysTenantMember));
    }

    /**
     * 修改租户成员（用户/组）
     */
    @PreAuthorize(hasPermi = "system:member:edit")
    @Log(title = "租户成员（用户/组）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTenantMember sysTenantMember)
    {
        return toAjax(sysTenantMemberService.updateSysTenantMember(sysTenantMember));
    }

    /**
     * 删除租户成员（用户/组）
     */
    @PreAuthorize(hasPermi = "system:member:remove")
    @Log(title = "租户成员（用户/组）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tenantMemberIds}")
    public AjaxResult remove(@PathVariable Long[] tenantMemberIds)
    {
        return toAjax(sysTenantMemberService.deleteSysTenantMemberByIds(tenantMemberIds));
    }
}

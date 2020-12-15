package com.ruoyi.auth.api.legends;

import com.ruoyi.auth.domain.legends.ComReq;
import com.ruoyi.auth.domain.legends.ComResp;
import com.ruoyi.auth.domain.legends.CpLoginVO;
import com.ruoyi.auth.domain.legends.WxCpOauth2UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zero
 * @version 1.0
 * @title: WechatService
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1518:27
 */

@FeignClient(contextId = "freshmeatWechat", value = "freshmeat-wechat")
public interface WechatService {
    @PostMapping("/openapi/v1/qywechat/user/login")
    ComResp<WxCpOauth2UserInfo> wxLogin(@RequestBody ComReq<CpLoginVO> loginData);
}

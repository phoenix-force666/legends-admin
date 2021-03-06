package com.ruoyi.system.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import java.util.List;

/**
 * objectUtils
 * @author lih(929168750@qq.com)
 * @date 2017年6月15日 下午2:58:32
 */
public class CheckUtil {

	@Autowired
	PatternsRequestCondition patternsRequestCondition;

	
	public static boolean isNull(Object o){
		return null == o;
	}
	
	public static boolean isNotNull(Object o){
		return null != o;
	}

	public static boolean listIsNotNull(List list){
		 if(null!=list && !list.isEmpty()){
		 	return true;
		 }
		 return false;

	}
}

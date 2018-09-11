package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.OperateMsgTemplateBO;
import com.hhly.lottomsg.bo.OperateWechatTemplateBO;
import com.hhly.lottomsg.vo.OperateMsgTemplateVO;

public interface MsgTemplateDaoMapper {
		
		/**
		 * 
		 * @Desc   查询信息模板详情
		 * @Author HouXB
		 * @Date   2017年3月8日 上午10:45:37
		 * @param id
		 * @return
		 */
		OperateMsgTemplateBO findMsgTemplateById(@Param("id") Integer id);
		
		/**
		 * 
		 * @Desc   查询信息模板
		 * @Author HouXB
		 * @Date   2017年3月8日 上午10:45:37
		 * @param id
		 * @return
		 */
		List<OperateMsgTemplateBO> findMsgTemplate(OperateMsgTemplateVO vo);
		
		/**
		 * 
		 * @Desc   查询信息模板详情
		 * @Author HouXB
		 * @Date   2017年3月8日 上午10:45:37
		 * @param typeId 模板编号
		 * @return
		 */
		OperateMsgTemplateBO findMsgTemplateByTypeId(@Param("typeId") Integer typeId);
		
		/**
		 * 
		 * @Desc   查询信息模板详情
		 * @Author HouXB
		 * @Date   2017年3月8日 上午10:45:37
		 * @param typeId 模板编号
		 * @return
		 */
		List<OperateMsgTemplateBO> findMsgTemplateListByTypeIds(@Param("list") List<Integer> list);
		
		/**
		 * 
		 * @Desc   查询微信公众号模板设置详情
		 * @Author HouXB
		 * @Date   2017年3月8日 上午10:45:52
		 * @param id
		 * @return
		 */
		OperateWechatTemplateBO findWechatTemplateById(@Param("id") Integer id);
		
}

package com.hhly.lottomsg.service.manage;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.hhly.lottomsg.common.util.PropertyUtil;

/**
 * @desc 线程池管理类,对线程池统一管理监控和使用
 * @author jiangwei
 * @date 2017年2月24日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class ThreadPoolManager {

	/**
	 * 线程池
	 */
	private static final ThreadPoolExecutor THREAD_POOL;

	static {
		// 根据配置文件初始化线程池
		int corePoolSize = Integer.parseInt(PropertyUtil.getPropertyValue("application.properties", "manager_core_pool_size"));
		int maxCorePoolSize = Integer.parseInt(PropertyUtil.getPropertyValue("application.properties", "manager_max_core_pool_size"));
		THREAD_POOL = new ThreadPoolExecutor(corePoolSize, maxCorePoolSize, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),new RunsPolicy());
	}

	/**
	 * 启动一个线程
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年2月27日 上午9:43:32
	 * @param remark
	 *            备注
	 * @param runnable
	 *            线程
	 * @param addLog
	 *            是否添加到数据库
	 */
	public static void execute(Runnable runnable) {
		THREAD_POOL.execute(runnable);
	}

	/**
	 * @desc 线程池满后的处理策略
	 * @author jiangwei
	 * @date 2017年4月1日
	 * @company 益彩网络科技公司
	 * @version 1.0
	 */
	public static class RunsPolicy extends ThreadPoolExecutor.CallerRunsPolicy{
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
			super.rejectedExecution(r, e);
		}
	}
}

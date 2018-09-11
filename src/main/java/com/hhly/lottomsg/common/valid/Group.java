package com.hhly.lottomsg.common.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-12-1 下午2:59:35
 * @Desc 验证分组
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ ElementType.FIELD })  
public @interface Group {
   String [] value();
}

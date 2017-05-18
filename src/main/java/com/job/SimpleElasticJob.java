package com.job;

/**
 * Created by tree on 2017/4/27.
 */
import com.alibaba.druid.support.json.JSONUtils;
import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.util.env.IpUtils;
import com.entity.User;
import com.service.IUserService;
import com.util.ElasticJobUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 * 根据数据库记录／分片 ，
 * 打印ip，线程，分片记录，数据库记录
 *
 * @author 刘振树
 * @date 2017-05-18 11:15
 */
@Component
public class SimpleElasticJob implements SimpleJob {
    protected static final Logger logger = LoggerFactory.getLogger(SimpleElasticJob.class);

    @Autowired
    private IUserService userService;

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.error(String.format("【SimpleElasticJob】开始 IP: %s | Item: %s | Time: %s | Thread: %s | %s | %s | ",
                IpUtils.getIp(), shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(),
                "SIMPLE",shardingContext.getShardingParameter()));
        //1. 获取有效的用户
        List<User> validUsers = getValidData(shardingContext.getShardingParameter(),shardingContext.getShardingTotalCount());

        //2. TODO 处理有效的用户, 模拟休息10s
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. 成功处理， 打印日志／或者更新db
        logger.error("【SimpleElasticJob】结束 ...  第一个有效用户 = {}, 最后一个有效用户={}\n" +
                "作业名称= {}， 作业任务编号taskId = {}, 分片总数shardingTotalCount = {}, " +
                "分配于本作业实例的分片项ShardingItem = {}, 作业自定义参数jobParameter = {}",
                validUsers.get(0).getUserName(), validUsers.get(validUsers.size()-1).getUserName(),
                shardingContext.getJobName(), shardingContext.getTaskId(), shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(), shardingContext.getShardingParameter());

    }


    /**
     * 1. 取余后等于分片的参数
     * 2. TODO：以后添加其他验证，比如说状态为有效的用户（这里不演示，因为这里只有一种状态）
     * 3. TODO： 以后为添加一列为已经执行过并且成功的job-->sharding_job_status
     *
     * @param shareItemParam  分片作业参数， 这里是取余后的值
     * @shardingNum 分片总数
     * @return
     */
    public List<User> getValidData(String shareItemParam, int shardingNum ){
        List<User> users = new ArrayList<>();
        Long shareItemParamLong =  Long.valueOf(shareItemParam);
        List<User> data = userService.listUser();
        for(User user : data){
            //TODO 以后加上对有效用户数据的过滤
            if(user.getId()%shardingNum == shareItemParamLong ){
                users.add(user);
//                logger.info("Id = {}, userName = {}" , user.getId(),user.getUserName());
            }
        }

        return users;
    }

}
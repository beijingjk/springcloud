package com.jk.solr;

import com.jk.model.FruitsInfo;
import com.jk.service.UserServiceApi;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Solr {

    @Autowired
    private SolrClient client;

    @Autowired
    private CloudSolrClient cloudSolrClient;

    @Pointcut("execution(* com.jk.controller.FruitsController.*(..))")
    public void logPointCut() {}


    @AfterReturning(value="logPointCut()",argNames = "rtv", returning = "rtv")
    public void saveLog(JoinPoint joinPoint, Object rtv) throws Exception {

        //获取方法请求参数
        Object[] os = joinPoint.getArgs();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        String param = "";
        //System.out.println(methodName);
        if(methodName.contains("save") || methodName.contains("edit")){
            for (int i = 0; i < os.length; i++) {
                param += os[i].toString();
                FruitsInfo test = (FruitsInfo) os[0];
                //System.out.println(test.getId());
                SolrInputDocument doc = new SolrInputDocument();
                doc.setField("id", test.getId());
                doc.setField("title", test.getTitle());
                doc.setField("price", test.getPrice());
                doc.setField("img1", test.getImg1());
                /* 如果spring.data.solr.host 里面配置到 core了, 那么这里就不需要传 core1 这个参数
                 * 下面都是一样的
                 */
                cloudSolrClient.add("core2", doc);
                //client.commit();
                cloudSolrClient.commit("core2");
            }
        }
        if(methodName.contains("del")){
            for (int i = 0; i < os.length; i++) {
                param += os[i].toString();
                Integer test = (Integer) os[0];
                cloudSolrClient.deleteById("core2",test.toString());
                cloudSolrClient.commit("core2");
                //System.out.println(test.toString());
            }
        }




    }

}

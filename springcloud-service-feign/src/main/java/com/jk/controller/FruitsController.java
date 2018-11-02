package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.model.Area;
import com.jk.model.FruitsInfo;
import com.jk.model.FruitsType;
import com.jk.service.UserServiceApi;
import com.jk.util.AliyunOSSClientUtil;
import com.jk.util.OSSClientConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("fruits")
public class FruitsController {

    @Autowired
    private UserServiceApi userService;

    /*
     *  薛长欢
     *
     *  上传图片回显
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile imgFile, HttpServletRequest request) throws Exception{
        Map<String, Object> result = new HashMap<>();
        //获取原文件名称
        String fileName = imgFile.getOriginalFilename();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = request.getSession().getServletContext().getRealPath("/")+
                "upload/";
        File file = new File(folderPath);
//        该目录是否已经存在
        if(!file.exists()){
            //   创建文件夹
            file.mkdir();
        }
        String onlyFileName = UUID.randomUUID().toString().replace("-","")+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(imgFile.getBytes());
        fos.flush();
        fos.close();
        result.put("route","upload/"+onlyFileName);
        return  result;
    }

    @RequestMapping("toFruits")
    public String toFruits(){
        return "showFruitsInfo";
    }
    @RequestMapping("queryFruitsById")
    public String queryFruitsById(){
        return "editFruits";
    }

    @RequestMapping("toAddFruits")
    public String toAddFruits(Model mo){
        return "addFruits";
    }

    @RequestMapping("queryFruitsType")
    @ResponseBody
    public List<FruitsType> queryFruitsType(){
        List<FruitsType> typelist = userService.queryFruitsType();
        return typelist;
    }

    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(){
        List<Area> arealist = userService.queryArea();
        return arealist;
    }

    @RequestMapping("queryFruitsPage")
    @ResponseBody
    public Map<String,Object> queryFruitsPage(FruitsInfo fruitsInfo, Integer start, Integer limit){
        List<FruitsInfo> list =new ArrayList<FruitsInfo>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list = userService.queryFruitsList(fruitsInfo,start,limit);
            long count = userService.queryFruitsCount(fruitsInfo);
            map.put("count", count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
    //新增商品
    @RequestMapping("saveFruits")
    @ResponseBody
    public String saveFruits(FruitsInfo fruitsInfo,String[] imgs,HttpServletRequest request){
        String img1 = "";
        String folderPath = request.getSession().getServletContext().getRealPath("/");
        for (int i=0;i<imgs.length;i++){
            //System.out.println(folderPath+imgs[i]);
            File file = new File(folderPath+imgs[i]);
            OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
            String url = AliyunOSSClientUtil.uploadObject2OSS(ossClient, file, OSSClientConstants.BACKET_NAME, OSSClientConstants.FOLDER_TOW);
            img1 += img1 == "" ? url:","+url;
        }
        fruitsInfo.setImg1(img1);
        userService.saveFruits(fruitsInfo);
        return "";
    }

    @RequestMapping("queryAllFruitsById")
    public String queryAllFruitsById(String fruid, HttpServletRequest request){
        FruitsInfo fruitsInfo = userService.queryAllFruitsById(fruid);
        request.setAttribute("fruitsInfo",fruitsInfo);
        return "editFruits";
    }

    @RequestMapping("editFruits")
    @ResponseBody
    public Boolean editFruits(FruitsInfo fruitsInfo){
        try {
            userService.editFruits(fruitsInfo);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("delFruits")
    @ResponseBody
    public Boolean delFruits(Integer id){
        try {
            userService.delFruits(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

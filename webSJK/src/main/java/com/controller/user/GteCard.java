package com.controller.user;

import com.dao.reader.ReaderDao;
import com.dao.readerType.ReaderTypeDao;
import com.domain.Reader;
import com.domain.ReaderType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*使用多及目录的时候需要注意的事项为：
* springmvc中的转发器，会根据当前的请求的目录进行跳转，如果是二级目录，它会从第二级下面开始找文件
* idea中以/为当前项目路径，如果是二级的话 比如 /user/，就会从user下面找相应的路径，也就相当于
* 根目录变了，说以静态资源如果使用相对定位的话，就加载不了这些静态资源，因为路径错了
*
* 解决方案：${pageContext.request.contextPath}，加上这个，这是当前项目的路径
* 让静态文件跟着项目跑，永远都是以项目路径开始的，这样就不会找不到资源了
* */
@Controller
public class GteCard {
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ReaderTypeDao readerTypeDao;

    /*使用文件上传是MultipartFile 后面的字段名要和上传文件的input框中的name的名字一样才可以封装成功 */
    @RequestMapping("/saveUser")
    public String getCard(MultipartFile fileUpload, Reader reader)
    {

        try {
            if(fileUpload!=null){
                //截取文件格式
                System.out.println(fileUpload.getOriginalFilename());

                int begin = fileUpload.getOriginalFilename().indexOf(".");
                int last = fileUpload.getOriginalFilename().length();
                String s = fileUpload.getOriginalFilename().substring(begin, last);
                String imgname= UUID.randomUUID().toString().replace("-","");

               /* //创建一个新文件，
                String name=Integer.toString(max+1);
                File excelFile=File.createTempFile(name,s);*/

                reader.setRdPhoto("./UserImg/"+imgname+s);

                readerDao.addReader(reader);

                fileUpload.transferTo(new File("E:\\javaAllPractice\\images\\"+imgname+s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(reader);
        return "user";
    }


    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(MultipartFile fileUpload, Reader reader,HttpServletRequest request)
    {

        try {
            if(fileUpload!=null){
                //截取文件格式

                int begin = fileUpload.getOriginalFilename().indexOf(".");
                int last = fileUpload.getOriginalFilename().length();
                String s = fileUpload.getOriginalFilename().substring(begin, last);
                String imgname= UUID.randomUUID().toString().replace("-","");

               /* //创建一个新文件，
                String name=Integer.toString(max+1);
                File excelFile=File.createTempFile(name,s);*/

                reader.setRdPhoto("./UserImg/"+imgname+s);
                System.out.println("===============");
                System.out.println(reader);

                readerDao.updateUserInfo(reader);

                fileUpload.transferTo(new File("E:\\javaAllPractice\\images\\"+imgname+s));
            }
            else {
                String photo=readerDao.findPhotoByID(Integer.parseInt(request.getParameter("rdID")));
                reader.setRdPhoto(photo);
                readerDao.updateUserInfo(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "user";
    }

    @ResponseBody
    @RequestMapping("/getReaderType")
    public  List<ReaderType> getReaderType(){
      List<ReaderType> list = readerTypeDao.findAllReaderType();
      return list;
    }

    @ResponseBody
    @RequestMapping("updateReaderStatusByID")
    public Map updateStatusByID(HttpServletRequest request)
    {
      int id =Integer.parseInt(request.getParameter("readerID")) ;
      String status=request.getParameter("status");
        System.out.println(status);
    int i=  readerDao.updateReaderStatusByID(status,id);
        Map map=new HashMap();
        map.put("status","成功");
       return map;
    }

    @RequestMapping("deleteReader")
    public Map deleteReaderByID(HttpServletRequest request){
       int id=Integer.parseInt(request.getParameter("readerID")) ;
        System.out.println("开始删除---");
        readerDao.deleteReader(id);


        Map map=new HashMap();
        map.put("status","成功");
        return map;
    }
}

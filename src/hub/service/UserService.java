package hub.service;


import com.opensymphony.xwork2.ActionContext;
import hub.dao.IUserDao;
import hub.po.user.User;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {
    private IUserDao userDao;
    private Map<String, Object> session, request;

    public UserService() {
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean login(User user) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        String account = user.getAccount();
        String password = user.getPassword();
        String hql = "from User where account='" + account + "' and password='" + password + "'";
        List list = userDao.findByHql(hql);
        if (list.isEmpty()) {
            return false;
        } else {
            user= (User) list.get(0);
            session.put("user",user);
            return true;
        }
    }

    @Override
    public boolean modifyImg(File file,String fileName) throws IOException {
        // 文件输入流
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        InputStream is=null;
        OutputStream os=null;
        try{
            is = new FileInputStream(file);
            // 设置文件保存的目录
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
            // 设置目标文件
            File toFile = new File(uploadPath, fileName);
            // 文件输出流
            os = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int length = 0;
            // 读取file文件输出到toFile文件中
            while (-1 != (length = is.read(buffer, 0, buffer.length))) {
                os.write(buffer);
            }
            User user= (User) session.get("user");
            user.setImage(fileName);
            userDao.updateUser(user);
            session.put("user",user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            // 关闭输入流和输出流
            is.close();
            os.close();
        }
    }


}

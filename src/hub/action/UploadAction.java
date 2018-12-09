package hub.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import hub.service.IUserService;

public class UploadAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    // 提交过来的文件
    private File file;
    // 提交过来的file的名字
    private String fileFileName;
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String execute() throws Exception {
        if(userService.modifyImg(file,fileFileName))
            return "success";
        else
            return "fail";
    }
}

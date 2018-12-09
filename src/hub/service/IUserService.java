package hub.service;

import hub.po.user.User;

import java.io.File;
import java.io.IOException;

public interface IUserService {
    public boolean login(User user);

    public boolean modifyImg(File file, String fileName) throws IOException;
}

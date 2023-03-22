package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Entity.UserInfo;
import comIsteGelsinApp.Getir.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServiceImpl{
    public String add(UserInfo userInfo);
    public void delete(int id);
    public void update(UserInfo userInfo,int id);
    public List<UserInfo>userList();
    public UserInfo getById(int id);

}

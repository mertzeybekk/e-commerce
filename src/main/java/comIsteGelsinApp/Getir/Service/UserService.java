package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Entity.UserInfo;
import comIsteGelsinApp.Getir.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService  implements UserServiceImpl{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String add(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);
        return "User success Create";
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(UserInfo userInfo, int id) {

    }

    @Override
    public List<UserInfo> userList() {
        return null;
    }

    @Override
    public UserInfo getById(int id) {
        return null;
    }

}

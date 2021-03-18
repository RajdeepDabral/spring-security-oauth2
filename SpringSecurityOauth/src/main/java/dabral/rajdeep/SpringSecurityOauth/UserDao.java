package dabral.rajdeep.SpringSecurityOauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    List<User> userList = Arrays.asList(
//            new User("user", passwordEncoder.encode("pass"), Arrays.asList(new GrantAuthorityImpl("ROLE_USER"))),
//            new User("admin", passwordEncoder.encode("pass"), Arrays.asList(new GrantAuthorityImpl("ROLE_ADMIN"))));

//    User loadUserByUsername(String username) {
//        User user = null;
//        Optional<User> userOptional = userList.stream().filter(e -> e.getUsername().equals(username)).findFirst();
//        if(userOptional.isPresent()){
//            user= userOptional.get();
//        }else {
//            throw new RuntimeException("User not found");
//        }
//        return user;
//    }
//
    AppUser loadUserByUsername(String username) {
        User user = null;
        user = userRepository.findByUserName(username);
        if(user!=null) {
            return new AppUser(user.getUserName(),user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        }else{
            throw new RuntimeException("User not found!!!");
        }
    }
}

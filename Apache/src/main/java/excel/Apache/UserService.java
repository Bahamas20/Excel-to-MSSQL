package excel.Apache;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> viewUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void addUser(User user) {
        Long id = userRepo.count() + 1;
        user.setId(id);
//        if(userRepo.existsByName(user.getName())) {
//        	System.out.println("User already exists !");
//        }
        	 userRepo.save(user);
             System.out.println("User Added Succesfully!" +" ID number:" + id);
             

       
    }
    
    public void editUser(User user) {
       userRepo.save(user);
  
    }
    
  

    public User viewUser(int id) {
        Optional<User> User = userRepo.findById(id);
        return User.get();
    }

}

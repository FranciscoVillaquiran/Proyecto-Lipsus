package auth.module.service;


import auth.module.dto.LoginRequest;
import auth.module.dto.RegisterRequest;
import auth.module.model.User;
import auth.module.repository.UserRepository;
import auth.module.util.PasswordEncryptor;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class AuthService {


    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String register(RegisterRequest request) {


        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());


        if (existingUser.isPresent()) {
            return "User already exists";
        }


        String encryptedPassword = PasswordEncryptor.encrypt(request.getPassword());


        User user = new User(
                request.getEmail(),
                encryptedPassword,
                request.getName()
        );


        userRepository.save(user);


        return "User registered successfully";
    }


    public String login(LoginRequest request) {


        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());


        if (userOptional.isEmpty()) {
            return "User not found";
        }


        User user = userOptional.get();


        boolean valid = PasswordEncryptor.matches(
                request.getPassword(),
                user.getPassword()
        );


        if (!valid) {
            return "Invalid credentials";
        }


        return "Login successful";
    }
}

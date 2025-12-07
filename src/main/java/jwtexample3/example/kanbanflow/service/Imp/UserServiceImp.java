package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.customExceptions.PasswordNotFoundException;
import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.enums.Role;
import jwtexample3.example.kanbanflow.models.User;
import jwtexample3.example.kanbanflow.repository.UserRepository;
import jwtexample3.example.kanbanflow.service.UserService;
import jwtexample3.example.kanbanflow.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto)  {
        User user = UserTransformer.getUserFromRequest(userRequestDto);
        user.setRoles(Set.of(Role.ROLE_ADMIN));
        try{
            if(user.getPassword()==null)throw new PasswordNotFoundException("password is null");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
         User savedUser = userRepository.save(user);
            return UserTransformer.getUserResponseDto(savedUser);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto deleteUser(String uuid) {
        return null;
    }

    @Override
    public UserResponseDto deleteUserByPhone(String phone) {
        return null;
    }

    @Override
    public UserResponseDto deleteUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponseDto getUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto getUserByPhone(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto getUserByEmail(UserRequestDto userRequestDto) {
        return null;
    }
}

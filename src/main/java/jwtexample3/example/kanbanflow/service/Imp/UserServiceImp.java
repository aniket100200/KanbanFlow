package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.customExceptions.PasswordNotFoundException;
import jwtexample3.example.kanbanflow.customExceptions.UserNotFoundException;
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
    public UserResponseDto updateUser(UserRequestDto userRequestDto,String uuid) {
        User user = userRepository.findById(uuid).orElseThrow();
        if(userRequestDto.getPassword()!=null)user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user = UserTransformer.getUpdatedUser(user,userRequestDto);
        User savedUser = userRepository.save(user);
        return UserTransformer.getUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto deleteUser(String uuid) {
         userRepository.deleteById(uuid);
        return UserResponseDto.builder().message("User deleted successfully").build();
    }

    @Override
    public UserResponseDto deleteUserByPhone(String phone) {
        userRepository.deleteByPhone(phone);
        return UserResponseDto.builder().message("User deleted successfully").build();
    }

    @Override
    public UserResponseDto deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
        return UserResponseDto.builder().message("User deleted successfully").build();
    }

    @Override
    public UserResponseDto getUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto getUserByPhone(String phone) throws UserNotFoundException {
        User user = userRepository.findByPhone(phone);
        if(user!=null)return UserTransformer.getUserResponseDto(user);
        throw new UserNotFoundException("User not found");
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
       User user =  userRepository.findByEmail(email);
       if(user!=null)return UserTransformer.getUserResponseDto(user);

       throw new UserNotFoundException("User not found");
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

package com.random.Spri.Service;

import com.random.Spri.Dto.UserDto;
import com.random.Spri.Exception.BadRequestException;
import com.random.Spri.Exception.ResourceAlreadyExitException;
import com.random.Spri.Exception.ResourceNotFoundException;
import com.random.Spri.Mapper.UserMapper;
import com.random.Spri.Model.User;
import com.random.Spri.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public User createUser(User user) {
        if (user.getPassword().isEmpty() || user.getUserName().isEmpty() || user.getEmail().isEmpty()) {
            throw new BadRequestException("Field required cannot be left blank.");
        }
        // Check if user with the same username already exists
        if (userRepository.existsByUserName(user.getUserName())) {
            throw new ResourceAlreadyExitException("User with this username already exists.");
        }
        // Check if user with the same email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResourceAlreadyExitException("User with this email already exists.");
        }
        return userRepository.save(user);
    }

    // Get (by ID)
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return UserMapper.toDTO(user);
    }

    // Update
    public UserDto updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update the existing user with new data
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(updatedUser);
    }

    // Delete
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    // Read (all users)
    public List<UserDto> getAllUsers() throws Exception {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}

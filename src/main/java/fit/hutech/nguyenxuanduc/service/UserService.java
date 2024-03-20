package fit.hutech.nguyenxuanduc.service;


import fit.hutech.nguyenxuanduc.entity.User;
import fit.hutech.nguyenxuanduc.model.dto.UserDTO;
import fit.hutech.nguyenxuanduc.model.request.ChangePasswordRequest;
import fit.hutech.nguyenxuanduc.model.request.CreateUserRequest;
import fit.hutech.nguyenxuanduc.model.request.UpdateProfileRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getListUsers();

    Page<User> adminListUserPages(String fullName, String phone, String email, Integer page);

    User createUser(CreateUserRequest createUserRequest);

    void changePassword(User user, ChangePasswordRequest changePasswordRequest);

    User updateProfile(User user, UpdateProfileRequest updateProfileRequest);
}

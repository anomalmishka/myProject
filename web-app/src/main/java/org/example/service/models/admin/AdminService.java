package org.example.service.models.admin;

import org.example.model.UserLogin;

public interface AdminService {
    UserLogin isAccountNonLockedChange(Long id);
}

package com.jpacrud.service;

import com.jpacrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserMgmtService {

    private final UserRepository userRepository;
}

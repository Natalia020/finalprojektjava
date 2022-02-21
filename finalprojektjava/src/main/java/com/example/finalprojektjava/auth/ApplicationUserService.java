package com.example.projektjava.auth;

import java.util.Optional;

import com.example.projektjava.repository.UserRepository;
import com.example.projektjava.model.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

  private final UserRepository userRepository;

  public ApplicationUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<User> user = userRepository.findByUsername(username);
    user.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    return user.map(ApplicationUser::new).get();

  }

}

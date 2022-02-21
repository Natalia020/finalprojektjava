package com.example.projektjava.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.projektjava.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails {

  private final Set<? extends GrantedAuthority> grantedAuthorities;

  private final String username;

  private final String password;

  private final boolean isAccountNonExpired;

  private final boolean isAccountNonLocked;

  private final boolean isCredentialsNonExpired;

  private final boolean isEnabled;

  public ApplicationUser(
      Set<? extends GrantedAuthority> grantedAuthorities,
      String username,
      String password,
      boolean isAccountNonExpired,
      boolean isAccountNonLocked,
      boolean isCredentialsNonExpired,
      boolean isEnabled) {
    this.grantedAuthorities = grantedAuthorities;
    this.password = password;
    this.username = username;
    this.isAccountNonExpired = isAccountNonExpired;
    this.isAccountNonLocked = isAccountNonLocked;
    this.isCredentialsNonExpired = isCredentialsNonExpired;
    this.isEnabled = isEnabled;
  }

  public ApplicationUser(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.isAccountNonExpired = true;
    this.isAccountNonLocked = true;
    this.isCredentialsNonExpired = true;
    this.isEnabled = user.isActive();
    this.grantedAuthorities = Arrays.stream(user.getAuthorities().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }

}

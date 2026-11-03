package com.vignesh.banking.controller;
import com.vignesh.banking.dto.*;import com.vignesh.banking.service.AuthService;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController{ private final AuthService s; public AuthController(AuthService s){this.s=s;} @PostMapping("/register") public AuthResponse register(@RequestBody AuthRequest r){return s.register(r);} @PostMapping("/login") public AuthResponse login(@RequestBody AuthRequest r){return s.login(r);} }

// package com.example.demo.controller;

// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService,
//                           PasswordEncoder passwordEncoder,
//                           JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtUtil = jwtUtil;
//     }

//     // REGISTER
//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody User user) {
//         User savedUser = userService.register(user);
//         return ResponseEntity.ok(savedUser);
//     }

//     // LOGIN
//     @PostMapping("/login")
//     public ResponseEntity<Map<String, String>> login(@RequestBody User request) {

//         User user = userService.findByEmail(request.getEmail());

//         if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         String token = jwtUtil.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole().name()
//         );

//         Map<String, String> response = new HashMap<>();
//         response.put("token", token);

//         return ResponseEntity.ok(response);
//     }
// }
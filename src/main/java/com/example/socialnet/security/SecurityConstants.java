package com.example.socialnet.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)";
    public static final int TOKEN_EXPIRATION_TIME = 7_200_000; // 7_200_000 milliseconds = 7200 seconds = 2 hours.
    public static final String PREFIX = "Bearer "; // Authorization : "Bearer " + Token
    public static final String REGISTER_PATH = "/user/register"; // Public path that clients can use to register.

//    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
}

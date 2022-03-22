package com.example.demo.bindings;

import lombok.Data;

@Data
public class UnlockAccRequest {
 private String email;
 private String tempPwd;
 private String newPwd;
 private String confirmPwd;
}

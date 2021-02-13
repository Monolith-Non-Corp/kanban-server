package com.kanban.springbootserver;

import com.kanban.springbootserver.spring.AccountAuthService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountAuthServiceTests {
    
    @Autowired
    private AccountAuthService accountAuthService;

    @Test
    public void givenUnexistingAccount_shouldCreateNewAccount_thenReturnAccount() {
    }
}

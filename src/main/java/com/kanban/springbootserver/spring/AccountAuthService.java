package com.kanban.springbootserver.spring;

import java.time.ZonedDateTime;

import com.kanban.springbootserver.dao.AccountDao;
import com.kanban.springbootserver.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.ClaimAccessor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import lombok.Getter;
import ma.glasnost.orika.MapperFacade;

@Service
public class AccountAuthService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private MapperFacade mapperFacade;

    public Account getAccount(Jwt jwt) {
        AuthClaimProxyModelMapper mapper = new AuthClaimProxyModelMapper(jwt);
        Account currentAuthAccount = accountDao.findByAuthId(mapper.getAuthId()).map(account -> {
            account.setLastActive(ZonedDateTime.now());
            account = accountDao.save(account);
            return account;
        }).orElseGet(() -> {
            Account account = mapperFacade.map(mapper, Account.class);
            account.setLastActive(ZonedDateTime.now());
            account = accountDao.save(account);
            return account;
        });

        return currentAuthAccount;
    }

    @Getter
    public static class AuthClaimProxyModelMapper {

        private String authId;
        private String pictureUrl;
        private String displayName;
        private String username;
        private String email;

        AuthClaimProxyModelMapper(ClaimAccessor accessor) {
            this.authId = accessor.getClaimAsString("iss") + "|" + accessor.getClaimAsString("sub");
            this.pictureUrl = accessor.getClaimAsString("picture");
            this.displayName = accessor.getClaimAsString("family_name") + " " + accessor.getClaimAsString("given_name");
            this.username = accessor.getClaimAsString("preferred_username");
            this.email = accessor.getClaimAsString("email");
        }
    }
}

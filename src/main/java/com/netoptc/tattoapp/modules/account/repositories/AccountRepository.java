package com.netoptc.tattoapp.modules.account.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netoptc.tattoapp.modules.account.entities.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    Optional<AccountEntity> findByUsernameOrEmail(String username, String email);
}

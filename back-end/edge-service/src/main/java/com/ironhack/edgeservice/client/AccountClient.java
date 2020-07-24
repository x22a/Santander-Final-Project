package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "account-client", url = "http://localhost:8082")
public interface AccountClient {
    @GetMapping("/accounts/owner/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllByOwnerUsername(@PathVariable Long id);

    /**
     * Create Account
     * @param account Account to create
     * @return Account created
     */
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account save(@RequestBody @Valid Account account);
}

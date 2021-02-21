package com.systemDesign.accountTransaction;

import com.systemDesign.accountTransaction.data.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping(path="/account")
public class AccountController {
    @Autowired
    private CrudRepository<Account, Integer> accountRepository;

    @PostMapping(path="")
    public @ResponseBody Account createAccount(@RequestParam String balance) {
        Account account = new Account();
        account.setBalance(Integer.parseUnsignedInt(balance));
        return accountRepository.save(account);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Account> getAccount(@PathVariable String id) {
        return accountRepository.findById(Integer.parseInt(id));
    }

    @GetMapping(path="")
    public @ResponseBody
    Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping(path="/{id}/transfer")
    public @ResponseBody
    Iterable<Account> transfer(@PathVariable String id, @RequestParam String to,
                               @RequestParam String amount) {
        Account sender = accountRepository.findById(Integer.parseInt(id)).get();
        Account receiver = accountRepository.findById(Integer.parseInt(to)).get();
        Integer amountInt = Integer.parseUnsignedInt(amount);
        if (sender.getBalance() - amountInt < 0 ) {
            throw new RuntimeException("No enough balance");
        }
        sender.setBalance(sender.getBalance() - amountInt);
        receiver.setBalance(receiver.getBalance() + amountInt);
        accountRepository.saveAll(Arrays.asList(sender, receiver));
        return Arrays.asList(sender, receiver);
    }
}

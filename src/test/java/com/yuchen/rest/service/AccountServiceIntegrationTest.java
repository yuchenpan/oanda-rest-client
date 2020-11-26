package com.yuchen.rest.service;

import com.yuchen.rest.IntegrationTestInstances;
import com.yuchen.rest.IntegrationTestProperties;
import com.yuchen.rest.model.account.AccountProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

class AccountServiceIntegrationTest {
    private AccountService testSubject;

    @BeforeEach
    void setUp() {
        this.testSubject = IntegrationTestInstances.accountService();
    }

    @Test
    void accounts_authorisationProvided_hasCorrectAccounts() {
        List<AccountProperties> accounts = testSubject.accounts();

        assertThat(accounts, hasItem(testAccountProperties()));
    }

    private AccountProperties testAccountProperties() {
        return new AccountProperties(IntegrationTestProperties.TEST_ACCOUNT_ID, 0, new ArrayList<>());
    }
}
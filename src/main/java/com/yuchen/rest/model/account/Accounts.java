package com.yuchen.rest.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Accounts(
        @JsonProperty("accounts") List<AccountProperties> accounts) {
}

package com.yuchen.rest.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AccountProperties(
        @JsonProperty("id") String id,
        @JsonProperty("mt4AccountID") int mt4AccountID,
        @JsonProperty("tags") List<String> tags) {

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof AccountProperties o)) {
            return false;
        }

        if (!o.id.equals(id)) {
            return false;
        }

        if (o.mt4AccountID != mt4AccountID) {
            return false;
        }

        return o.tags.containsAll(tags);
    }
}

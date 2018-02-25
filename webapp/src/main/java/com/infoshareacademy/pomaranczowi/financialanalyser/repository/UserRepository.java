package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.User;

public interface UserRepository {

    public boolean isUserAlreadyExisting(User user);

    public void addUser(User user);
}

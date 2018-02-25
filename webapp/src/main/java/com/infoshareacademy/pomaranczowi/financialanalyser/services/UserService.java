package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.User;

import javax.servlet.ServletConfig;

public interface UserService {

    public User getUserInfo(ServletConfig config, String accessToken);
}

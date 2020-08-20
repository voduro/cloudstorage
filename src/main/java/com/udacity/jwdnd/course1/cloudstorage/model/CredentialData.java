package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialData {
    private Integer credentialId;
    private String url;
    private String username;
    private String password;
    private String encryptedPassword;

    public CredentialData(Integer credentialId, String url, String username, String password, String encryptedPassword) {
        this.credentialId = credentialId;
        this.url = url;
        this.username = username;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}

package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialData;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;
    private final UserMapper userMapper;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService, UserMapper userMapper) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
        this.userMapper = userMapper;
    }

    public int addCredential(CredentialForm credentialForm, String username) {
        System.out.println("inside create credential");
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodeKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentialForm.getPassword(), encodeKey);
        User user = userMapper.getUser(username);
        Credential credential = new Credential(null, credentialForm.getUrl(), credentialForm.getUsername(), encodeKey, encryptedPassword, user.getUserId() );
        return credentialMapper.insertCredential(credential);
    }

    public int updateCredential(CredentialForm credentialForm, String username) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodeKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentialForm.getPassword(), encodeKey);
        User user = userMapper.getUser(username);
        Credential credential = new Credential(credentialForm.getCredentialId(), credentialForm.getUrl(), credentialForm.getUsername(), encodeKey, encryptedPassword, user.getUserId() );

        return credentialMapper.updateCredential(credential);
    }

    public List<CredentialData> getAllCredentials(String username) {
        System.out.println("inside create getAllCredentials");
        User user = userMapper.getUser(username);
        List<Credential> credentials = credentialMapper.getAllCredentials(user.getUserId());
        return credentials.stream()
                .map(credential -> mapToCredentialData(credential))
                .collect(Collectors.toList());
    }

    private CredentialData mapToCredentialData(Credential credential) {
        System.out.println("inside mapToCredentialData");
        return new CredentialData(credential.getCredentialId(), credential.getUrl(),credential.getUsername(),decryptPassword(credential.getPassword(),credential.getKey()), credential.getPassword());
//                credential.getCredentialId(),
//                credential.getUrl(),
//                credential.getUsername(),
//                decryptPassword(credential.getPassword(), credential.getKey()), credential.getPassword());
    }

    private String decryptPassword(String password, String key) {
        return encryptionService.decryptValue(password, key);
    }

    public int deleteCredential(Integer credentialId) {
        return credentialMapper.deleteCredential(credentialId);
    }

    public Credential getCredential(Integer credentialId) {
        return credentialMapper.getCredential(credentialId);
    }
}

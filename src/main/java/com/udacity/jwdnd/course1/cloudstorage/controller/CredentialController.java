package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping
    public String addCredential(@ModelAttribute(value = "credentialForm") CredentialForm credentialForm, Authentication authentication, Model model) {

            System.out.println("attempt to create credential");

            if(credentialForm.getCredentialId() == null){
                credentialService.addCredential(credentialForm, authentication.getName());

                model.addAttribute("message", "SuccessAddCredential");

                return "result";
            }else {
                credentialService.updateCredential(credentialForm, authentication.getName());
                model.addAttribute("message", "SuccessUpdCredential");

                return "result";
            }
//            credentialService.addCredential(credentialForm, authentication.getName());
//            model.addAttribute("message", "SuccessAddCredential");
//
//        return "result";
    }

//    @PostMapping("/edit/{credential_id}")
//    public String editCredential(@PathVariable(value = "/edit/{credential_id}") CredentialForm credentialForm, Authentication authentication, Model model) {
//
//        if(credentialForm.getCredentialId() == null){
//            credentialService.addCredential(credentialForm, authentication.getName());
//
//            model.addAttribute("message", "SuccessAddCredential");
//
//            return "result";
//        }else {
//            credentialService.updateCredential(credentialForm, authentication.getName());
//            model.addAttribute("message", "SuccessDelCredential");
//
//            return "result";
//        }
////            credentialService.updateCredential(credentialForm, authentication.getName());
////            model.addAttribute("message", "SuccessUpdCredential");
////
////        return "result";
//    }

    @GetMapping("/delete/{credential_id}")
    public String deleteCredential(@PathVariable(value = "credential_id") Integer credentialId, Model model) {
        credentialService.deleteCredential(credentialId);
        model.addAttribute("message", "SuccessDelCredential");

        return "result";
    }
}

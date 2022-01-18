package com.appeals.appeals.service;

import com.appeals.appeals.configuration.RegistrationRequest;
import com.appeals.appeals.configuration.security.EmailValidatorImpl;
import com.appeals.appeals.domain.ConfirmationToken;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import com.appeals.appeals.service.mail.EmailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final EmailValidatorImpl emailValidatorImpl;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public RegistrationService(EmailValidatorImpl emailValidatorImpl, UserService userService, ConfirmationTokenService confirmationTokenService, EmailSender emailSender) {
        this.emailValidatorImpl = emailValidatorImpl;
        this.userService = userService;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSender = emailSender;
    }

    public String register(final RegistrationRequest registrationRequest) {
        final boolean isValidEmail = emailValidatorImpl.test(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }
        final String token = userService.signUpUser(
                new User(registrationRequest.getUsername(),
                        registrationRequest.getFullUsername(),
                        registrationRequest.getPassword(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPhone(),
                        UserRole.USER_ROLE
                ));
        final String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(
                registrationRequest.getEmail(),
                buildEmail(registrationRequest.getFullUsername(), link));

        return token;
    }

    public String confirmToken(final String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token is expaired");
        }

        confirmationTokenService.setConfirmedTokenAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed token";
    }

    private String buildEmail(String name, String link) {
        return "<table role=\"presentation\" width=\"640\" style=\"width:640px;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "<tr>\n" +
                "<td align=\"center\" bgcolor=\"#000000\" background=\"https://pages.customertimes.com/rs/055-AWU-851/images/second_row.png\" width=\"640\" height=\"400\" valign=\"top\" style=\"background: url('https://pages.customertimes.com/rs/055-AWU-851/images/second_row.png') center / cover no-repeat;\">\n" +
                "<!--[if gte mso 9]>\n" +
                "<v:image xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\" border: 0;display: inline-block; width: 480pt; height: 300pt;\" src=\"https://pages.customertimes.com/rs/055-AWU-851/images/second_row.png\" />                <v:rect xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\" border: 0;display: inline-block;position: absolute; width: 480pt; height:300pt;\">\n" +
                "<v:fill  opacity=\"0%\" color=\"#000000”  />\n" +
                "<v:textbox inset=\"0,0,0,0\">\n" +
                "<![endif]-->\n" +
                "<table>" +
                "<tbody> " +
        "                         <tr> "+
        "                                   <td width='https://pages.customertimes.com/rs/055-AWU-851/images/second_row.png' style='line-height:1px;font-size:1px;'>&nbsp;</td> "+
        "                                   <td> "+
        "                                     <div class='hero_text mktoText' mktoname='first hero' id='first_hero_text' style='line-height: 16; text-align: center; font-size: 12px'>" +
        "                                       <p><span style='color: #000000;'>He scales large projects in a single bound and wields his programming framework skills to architect any solution on-demand.</span></p>"+
        "                                     </div> </td> "+
        "                                   <td width='43' style='line-height:1px;font-size:1px;'>&nbsp;</td> "+
        "                                 </tr> "+
        "                               </tbody> "+
        "                             </table>"+
                "<!--[if gte mso 9]>\n" +
                "</v:textbox>\n" +
                "</v:fill>\n" +
                "</v:rect>\n" +
                "</v:image>\n" +
                "<![endif]-->\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>";
    }


}

package org.weida.toko.email;

import org.weida.toko.exception.AccountEmailException;

public interface AccountEmail {

    void sendEmail(String to,String subject,String text) throws AccountEmailException;
}

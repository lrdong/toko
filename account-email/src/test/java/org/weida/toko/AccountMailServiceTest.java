package org.weida.toko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.weida.toko.email.AccountEmail;
import org.weida.toko.exception.AccountEmailException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountMailServiceTest {

    @Autowired
    AccountEmail accountEmail;

    @Test
    public void testSayHello() throws AccountEmailException {
        accountEmail.sendEmail("donglinrong1121@163.com","会议通知","会议通知");
    }

}

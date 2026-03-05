package com.pushan;

import com.pushan.OneToOne.Bidirectional.DAO.BiDAO;
import com.pushan.OneToOne.Bidirectional.Entity.PassportBI;
import com.pushan.OneToOne.Bidirectional.Entity.UsersBI;
import com.pushan.OneToOne.Unidirectional.DAO.UniDAO;
import com.pushan.OneToOne.Unidirectional.Entity.Passport;
import com.pushan.OneToOne.Unidirectional.Entity.Users;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {


            // One to One Unidirectional
//        Passport passport = new Passport("A1234567");
//        Users s = new Users("Pushan", passport);
//        UniDAO udao = new UniDAO();
//        udao.save(s);

        // One to One Bidirectional
//        UsersBI usersBI = new UsersBI("Pushan");
//        PassportBI passportBI = new PassportBI("A1234567", usersBI);
        BiDAO biDAO = new BiDAO();
//        biDAO.insert(usersBI, passportBI);
        List<UsersBI> allList = biDAO.getAllList();
        for(UsersBI u : allList) {
            System.out.println(u.toString());
        }
    }
}

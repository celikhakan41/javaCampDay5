package com.javacamp.core.concretes;

import com.javacamp.core.abstracts.VerificationService;
import com.javacamp.entities.concretes.User;

import java.util.Random;
import java.util.Scanner;

public class EmailVerificationManager implements VerificationService {

    @Override
    public boolean verification(User user) {
        Scanner scanner = new Scanner(System.in);
        char chosenValue = 'h';
        System.out.println(user.getEmail()
                + " Doğrulama maili gönderildi. Doğrulamak için 'E' basınız. İptal için 'H' basınız...(E/H)");
        chosenValue = scanner.next().charAt(0);

        if (chosenValue == 'e' || chosenValue == 'E') {
            Random random = new Random();
            int randomInteger, enteredNumber, count = 0;

            do {
                randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

                System.out.println(
                        "Hesabı doğrulamak için gördüğünüz sayıyı giriniz:\n--> " + randomInteger);
                enteredNumber = scanner.nextInt();
                count++;
                if (count == 4) {
                    System.out.println(
                            "Çok sayıda yanlış deneme yapıldı.");
                    scanner.close();
                    return false;
                }
            } while (!(enteredNumber == randomInteger) && count < 4);
            System.out.println("Hesabınız doğrulandı");

            scanner.close();
            return true;

        }
        scanner.close();
        return false;

    }
}
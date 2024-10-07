package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // Dummy-Daten für Benutzer
    private List<User> users = new ArrayList<>();

    public UserService() {
        // Dummy-Benutzer hinzufügen mit verschlüsselten Passwörtern
        users.add(new User("user1", "password1")); // Passwort: password1
        users.add(new User("user2","password2")); // Passwort: password2
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            	System.out.println("passt");
                return user; // Benutzer ist erfolgreich angemeldet
            }
        }
        System.out.println("feher");
        return null; // Anmeldedaten ungültig
    }
}

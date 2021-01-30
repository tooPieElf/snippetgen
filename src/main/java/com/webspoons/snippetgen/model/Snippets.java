package com.webspoons.snippetgen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snippets {
    String snippet;
    String name;
    String url;
    LocalDateTime expiresAt;
    Integer likes;


    public Snippets(String url, String name, LocalDateTime expiresAt, String snippetContent, int likes) {
    }
}

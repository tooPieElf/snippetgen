package com.webspoons.snippetgen.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SnippetsRequest {
    String snippet;
    String name;
    String url;
    LocalDateTime expiresAt;
    Integer likes;
}

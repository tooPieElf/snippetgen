package com.webspoons.snippetgen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnippetsRequest {
    String snippet;
    String name;
    Integer expiresIn;
}

package com.webspoons.snippetgen.controller;

import com.webspoons.snippetgen.model.Snippets;
import com.webspoons.snippetgen.model.SnippetsRequest;
import com.webspoons.snippetgen.service.SnippetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/snippets")
@RequiredArgsConstructor
public class SnippetController {

    public final SnippetsService snippetsService;

    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSnippet (@RequestBody SnippetsRequest snippetRequest){
        Snippets snippet = snippetsService.createSnippet(snippetRequest);
        return ResponseEntity.created(URI.create(snippet.getUrl())).body(snippet);
    }

    @GetMapping(value = "/{snippetName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSnippet (@PathVariable("snippetName") String snippetName) {
        Snippets snippet = snippetsService.getSnippet(snippetName);
        if(snippet == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry... The snippet with " + snippetName + " does not exist or has expired");
        return ResponseEntity.ok(snippet);
    }



}

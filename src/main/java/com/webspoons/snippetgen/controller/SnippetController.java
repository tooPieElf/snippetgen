package com.webspoons.snippetgen.controller;

import com.webspoons.snippetgen.model.Snippets;
import com.webspoons.snippetgen.model.SnippetsRequest;
import com.webspoons.snippetgen.service.SnippetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/snippets")
@RequiredArgsConstructor
public class SnippetController {

    public final SnippetsService snippetsService;

    @PostMapping("")
    public ResponseEntity<?> createSnippet (@RequestBody SnippetsRequest snippetRequest){
        Snippets snippet = snippetsService.createSnippet(snippetRequest);
        return ResponseEntity.created(URI.create(snippet.getUrl())).body(snippet);
    }


}

package com.webspoons.snippetgen.service;

import com.webspoons.snippetgen.model.Snippets;
import com.webspoons.snippetgen.model.SnippetsRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SnippetsService {

    private List<Snippets> snippetList = new ArrayList<>();
    public Snippets createSnippet(SnippetsRequest snippetsRequest) {


        String url = "http://localhost:8080/snippets/" + snippetsRequest.getName();
        LocalDateTime expiresAt = LocalDateTime.now().plusSeconds(snippetsRequest.getExpiresIn());
        String snippetContent = snippetsRequest.getSnippet();

        if (isSnipplet(snippetsRequest.getName())) {
            for (Snippets snippet : snippetList) {
                if (snippet.getName().equals(snippetsRequest.getName())) {
                    snippet.setExpiresAt(expiresAt);
                    snippet.setSnippet(snippetContent);
                    snippet.setLikes(0);
                    return snippet;
                }
            }
        }
            Snippets snippet = new Snippets(url, snippetsRequest.getName(), expiresAt, snippetContent, 0);
            snippetList.add(snippet);
            return snippet;

    }


    public Snippets getSnippet(String snippetName) {

       try {
           for (Snippets snippets : snippetList) {
               if (snippets.getName().equals(snippetName)) {
                   if (LocalDateTime.now().isAfter(snippets.getExpiresAt())) {
                       return null;
                   } else {
                       snippets.setExpiresAt(snippets.getExpiresAt().plusSeconds(30));
                       return snippets;
                   }
               }
           }
           return null;
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       return null;

    }
    public boolean isSnipplet(String snippetName) {
        return snippetList.stream().anyMatch(snippet -> snippet.getName().equals(snippetName));
    }
}

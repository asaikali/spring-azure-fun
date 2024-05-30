package com.example.api;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  private final ChatClient chatClient;

  public RootController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @GetMapping("/")
  public String get() {
    return this.chatClient.prompt()
            .user("Write a funny song about Spring IO in Barcelona")
            .call()
            .content();
  }
}

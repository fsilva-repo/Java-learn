package com.web.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.web.app.domain.SocialMetaTag;
import com.web.app.service.SerializeFromGson;
import com.web.app.service.SocialMetaTagService;
@RestController//para uma api restfull
@RequestMapping("/meta")
public class SocialMetaTagController {
  // @Autowired componente do spring adiciona uma nova intancia quando necessario
  @Autowired
  SocialMetaTagService service;
  @Autowired
  SerializeFromGson serializad;
  @PostMapping("/info")
  public ResponseEntity<String> getDataByUrl(@RequestParam("url") String url) {
    SocialMetaTag tag = service.getSocialMetaTagByUrl(url);
    return tag != null
    ? ResponseEntity.ok(serializad.toJson(tag))
    : ResponseEntity.notFound().build();
  }
}

package com.web.app.service;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.web.app.domain.SocialMetaTag;
@Service// define a classe como um bean do spring
public class SerializeFromGson {
  private final Gson GSON = new GsonBuilder()
      .setPrettyPrinting().create();
  /** Converte qualquer objeto para JSON usando Gson (Modo generico) */
  public String toJson(Object obj) {
    return GSON.toJson(obj);
  }
  /** Sobrecarga aceit apenasa tipo SocialMetaTag */
  public String toJson(SocialMetaTag tag) {
    return GSON.toJson(tag);
  }
}


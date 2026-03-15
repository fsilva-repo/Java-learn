package com.web.app.service;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import com.web.app.domain.SocialMetaTag;
@Service
public class SocialMetaTagService {
	private SocialMetaTag getOpengraphByUrl(String url) {
		SocialMetaTag tag = new SocialMetaTag();
		try {
			Document doc = Jsoup.connect(url).get();
			tag.setSite(doc.head().select("meta[property=og:site_name]").attr("content"));
			tag.setTitle(doc.head().select("meta[property=og:title]").attr("content"));
			tag.setImage(doc.head().select("meta[property=og:image]").attr("content"));
			tag.setUrl(doc.head().select("meta[property=og:url]").attr("content"));
			tag.setDescription(doc.head().select("meta[property=og:description]").attr("content"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tag;
	}
	private SocialMetaTag getTwitterCardByUrl(String url) {
		SocialMetaTag tag = new SocialMetaTag();
		try {
			Document doc = Jsoup.connect(url).get();
			tag.setSite(doc.head().select("meta[name=twitter:site]").attr("content"));
			tag.setTitle(doc.head().select("meta[name=twitter:title]").attr("content"));
			tag.setImage(doc.head().select("meta[name=twitter:image]").attr("content"));
			tag.setUrl(doc.head().select("meta[name=twitter:url]").attr("content"));
			tag.setDescription(doc.head().select("meta[name=twitter:description]").attr("content"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tag;
	}
	private boolean isEmpty(SocialMetaTag tag) {
		if (tag.getSite() == null &&
				tag.getTitle() == null &&
				tag.getImage() == null &&
				tag.getUrl() == null &&
				tag.getDescription() == null) {
			return true;
		}
		return false;
	}
	public SocialMetaTag getSocialMetaTagByUrl(String url) {
		SocialMetaTag twitterCard = getTwitterCardByUrl(url);
		SocialMetaTag openGraph = getOpengraphByUrl(url);
		if (!isEmpty(twitterCard)) {
			return twitterCard;
		} else if (!isEmpty(openGraph)) {
			return openGraph;
		} else {
			return null;
		}
	}
}




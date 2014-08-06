package oop.rssparser;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class PostItem {
    static SimpleDateFormat FORMATTER = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z", Locale.US);
   
    private String title; // Название поста
    private URL link; // Ссылка на пост на сайте (в формате URL для использования в Java)
    private String linkText; // Ссылка на пост на сайте (в виде строки текста для вывода)
    private String description; // Описание поста
    private Date date; // Дата публикации поста (в формате Date для обработки в программе)

	
    public void setTitle(String title) {
    	this.title = title.trim();
    }


    public String getTitle() {
    	return title;
    }  


    public void setDescription(String description) {
    	this.description = description.trim();
    }


	public String getDescription() {
		return description;
	}	


    public void setLink(String link) {
    	this.linkText = link.trim();
        try {
            this.link = new URL(link);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

	public URL getLink() {
		return link;
	}

	public String getLinkText() {
		return linkText;
	}

    public void setDate(String date) {
        try {
            this.date = FORMATTER.parse(date.trim());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }	

    public String getDate() {
        return FORMATTER.format(this.date);
    }
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Название поста: ");
		sb.append(title);
		sb.append('\n');
		sb.append("Дата: ");
		sb.append(this.getDate());
		sb.append('\n');
		sb.append("Ссылка: ");
		sb.append(linkText);
		sb.append('\n');
		sb.append("Description: ");
		sb.append(description);
		return sb.toString();
    }
	public PostItem copy() {
		PostItem copy = new PostItem();
		copy.title = title;
		copy.link = link;
		copy.linkText = linkText;
		copy.description = description;
		copy.date = date;
		return copy;
	}
}
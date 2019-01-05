package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Scores;

/**
 * Jikan4java
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MangaUserUpdate {

	@JsonProperty("username")
	private String username;

	@JsonProperty("url")
	private String url;

	@JsonProperty("image_url")
	private String image_url;

	@JsonProperty("score")
	private int scores;

	@JsonProperty("status")
	private String status;

	@JsonProperty("chapters_read")
	private int chapters_seen;

	@JsonProperty("volumes_read")
	private int volumes_seen;

	@JsonProperty("chapters_total")
	private int episodes_total;

	@JsonProperty("volumes_total")
	private int volumes_total;

	@JsonProperty("date")
	private String date;

	public String getUsername() {
		return username;
	}

	public String getUrl() {
		return url;
	}

	public String getImage_url() {
		return image_url;
	}

	public int getScores() {
		return scores;
	}

	public String getStatus() {
		return status;
	}

	public int getVolumes_seen() {
		return volumes_seen;
	}

	public int getChapters_seen() {
		return chapters_seen;
	}

	public int getVolumes_total() {
		return volumes_total;
	}


	public int getEpisodes_total() {
		return episodes_total;
	}

	@Override
	public String toString() {
		return "MangaUserUpdate{" +
				"username='" + username + '\'' +
				", url='" + url + '\'' +
				", image_url='" + image_url + '\'' +
				", scores=" + scores +
				", status='" + status + '\'' +
				", chapters_seen=" + chapters_seen +
				", volumes_seen=" + volumes_seen +
				", episodes_total=" + episodes_total +
				", volumes_total=" + volumes_total +
				'}';
	}
}

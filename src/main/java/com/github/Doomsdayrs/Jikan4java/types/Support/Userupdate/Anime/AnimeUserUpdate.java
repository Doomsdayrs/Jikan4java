package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Scores;

/**
 * Jikan4java
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeUserUpdate {

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

	@JsonProperty("episodes_seen")
	private int episodes_seen;

	@JsonProperty("episodes_total")
	private int episodes_total;

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

	public int getEpisodes_seen() {
		return episodes_seen;
	}

	public int getEpisodes_total() {
		return episodes_total;
	}

	@Override
	public String toString() {
		return "AnimeUserUpdate{" +
				"username='" + username + '\'' +
				", url='" + url + '\'' +
				", image_url='" + image_url + '\'' +
				", scores=" + scores +
				", status='" + status + '\'' +
				", episodes_seen=" + episodes_seen +
				", episodes_total=" + episodes_total +
				'}';
	}
}

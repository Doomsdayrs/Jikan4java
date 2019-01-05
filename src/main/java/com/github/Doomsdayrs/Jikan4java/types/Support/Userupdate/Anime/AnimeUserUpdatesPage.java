package com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Jikan4java
 * 04 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class AnimeUserUpdatesPage {
	@JsonProperty("request_hash")
	private String request_hash;

	@JsonProperty("request_cached")
	private boolean request_cached;

	@JsonProperty("request_cache_expiry")
	private int request_cache_expiry;

	@JsonProperty("users")
	private ArrayList<AnimeUserUpdate> userUpdates;

	public String getRequest_hash() {
		return request_hash;
	}

	public boolean isRequest_cached() {
		return request_cached;
	}

	public int getRequest_cache_expiry() {
		return request_cache_expiry;
	}

	public ArrayList<AnimeUserUpdate> getUserUpdates() {
		return userUpdates;
	}

	@Override
	public String toString() {
		return "UserUpdatesPage{" +
				"request_hash='" + request_hash + '\'' +
				", request_cached=" + request_cached +
				", request_cache_expiry=" + request_cache_expiry +
				", AnimeUserUpdate=" + userUpdates +
				'}';
	}
}

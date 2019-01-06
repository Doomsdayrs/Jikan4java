package com.github.Doomsdayrs.Jikan4java.types.Main.Club;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.BasicMeta;
import com.github.Doomsdayrs.Jikan4java.types.Support.Userupdate.Anime.AnimeUserUpdatesPage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Club {
	@JsonIgnore
	private final ObjectMapper mapper = new ObjectMapper();

	@JsonProperty("request_hash")
	private String request_hash;
	@JsonProperty("request_cached")
	private boolean request_cached;
	@JsonProperty("request_cache_expiry")
	private int request_cache_expiry;

	@JsonProperty("mal_id")
	private int mal_id;
	@JsonProperty("url")
	private String url;
	@JsonProperty("image_url")
	private String image_url;
	@JsonProperty("title")
	private String title;
	@JsonProperty("members_count")
	private float members_count;
	@JsonProperty("pictures_count")
	private float pictures_count;
	@JsonProperty("category")
	private String category;
	@JsonProperty("created")
	private String created;
	@JsonProperty("type")
	private String type;
	@JsonProperty("staff")
	private ArrayList<BasicMeta> staff;
	@JsonProperty("anime_relations")
	private ArrayList<BasicMeta>  anime_relations;
	@JsonProperty("manga_relations")
	private ArrayList<BasicMeta>  manga_relations;
	@JsonProperty("character_relations")
	private ArrayList<BasicMeta>  character_relations;

	public String getRequest_hash() {
		return request_hash;
	}

	public boolean isRequest_cached() {
		return request_cached;
	}

	public int getRequest_cache_expiry() {
		return request_cache_expiry;
	}

	public int getMal_id() {
		return mal_id;
	}

	public String getUrl() {
		return url;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getTitle() {
		return title;
	}

	public float getMembers_count() {
		return members_count;
	}

	public float getPictures_count() {
		return pictures_count;
	}

	public String getCategory() {
		return category;
	}

	public String getCreated() {
		return created;
	}

	public String getType() {
		return type;
	}

	public ArrayList<BasicMeta> getStaff() {
		return staff;
	}

	public ArrayList<BasicMeta> getAnime_relations() {
		return anime_relations;
	}

	public ArrayList<BasicMeta> getManga_relations() {
		return manga_relations;
	}

	public ArrayList<BasicMeta> getCharacter_relations() {
		return character_relations;
	}


	@JsonProperty
	public ClubMemberPage getMembers() throws IOException, ParseException {
		return mapper.readValue(this.retrieve("members").toJSONString(), ClubMemberPage.class);
	}

	/**
	 * Retrieves data from page
	 *
	 * @param subCategory What is needed to be retrieved, ie 'moreinfo'
	 * @return JSONObject of the page
	 * @throws IOException    IOException
	 * @throws ParseException ParseException
	 */
	@JsonProperty
	private JSONObject retrieve(String subCategory) throws IOException, ParseException {
		String baseURL = "https://api.jikan.moe/v3";
		Request request = new Request.Builder().url(baseURL + "/club/" + mal_id + "/" + subCategory).build();
		Response response = new OkHttpClient().newCall(request).execute();
		JSONParser parser = new JSONParser();
		String responseString = response.body().string();
		if (!responseString.equals(null))
			return (JSONObject) parser.parse(responseString);
		else return null;
	}

	@Override
	public String toString() {
		return "Club{" +
				"request_hash='" + request_hash + '\'' +
				", request_cached=" + request_cached +
				", request_cache_expiry=" + request_cache_expiry +
				", mal_id=" + mal_id +
				", url='" + url + '\'' +
				", image_url='" + image_url + '\'' +
				", title=" + title +
				", members_count=" + members_count +
				", pictures_count=" + pictures_count +
				", category='" + category + '\'' +
				", created='" + created + '\'' +
				", type='" + type + '\'' +
				", staff=" + staff +
				", anime_relations=" + anime_relations +
				", manga_relations=" + manga_relations +
				", character_relations=" + character_relations +
				'}';
	}
}

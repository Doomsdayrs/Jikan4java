package com.github.Doomsdayrs.Jikan4java.connection.Club;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Main.Anime.AnimePage.AnimePage;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;

/**
 * Jikan4java
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ClubConnection {
	private final JSONParser jsonParser = new JSONParser();
	private final OkHttpClient client = new OkHttpClient();
	private final String baseURL = "https://api.jikan.moe/v3";
	private final ObjectMapper objectMapper = new ObjectMapper();

	public ClubConnection()
	{}

	/**
	 * retreives a club
	 *
	 * @param ID id of the club
	 * @return AnimePage
	 * @throws IOException    IOException
	 * @throws ParseException ParseException
	 */
	public Club clubRetrieve(int ID) throws IOException, ParseException {
		return objectMapper.readValue(((JSONObject) jsonParser.parse(client.newCall(new Request.Builder().url(baseURL + "/club/"+ID).build()).execute().body().string())).toJSONString(), Club.class);
	}
}

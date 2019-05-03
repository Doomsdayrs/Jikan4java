package com.github.Doomsdayrs.Jikan4java.connection.Club;

import com.github.Doomsdayrs.Jikan4java.connection.Connection;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Jikan4java
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ClubConnection extends Connection {

	public ClubConnection() {
		super();
	}

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

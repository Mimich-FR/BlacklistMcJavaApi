/*
 * MIT License
 *
 * Copyright (c) 2020 Mimich-FR, BlacklistMCJavaAPI
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fr.mimich.blacklistmcapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * Small and easy Bukkit inventory API with 1.7 to 1.16 support.
 * The project is on <a href="https://github.com/MrMicky-FR/FastInv">GitHub</a>
 *
 * @author Mimich-FR
 * @version 1.0
 */

public final class BlacklistMcAPI {

    /**
     * Get if username/id was blacklisted
     *
     * @param search        a object do you want search. (id, username)
     * @param apiCheckTypes all check type do you want use for the checking.
     * @return if no or yes object was blacklisted.
     */
    public final boolean isBlackListed(final String search, ApiCheckType... apiCheckTypes) {

        return getProfile(search, apiCheckTypes).isBlacklisted();
    }

    /**
     * Get if username/id was blacklisted
     *
     * @param search a object do you want search. (id, username)
     * @return if no or yes object was blacklisted.
     */
    public final boolean isBlackListed(final String search) {

        return getProfile(search).isBlacklisted();

    }

    /**
     * Get a blacklisted profile object.
     *
     * @param search a object do you want search. (id, username)
     * @return if no or yes object was blacklisted.
     * @throws IOException if connection or stream or link was not nice (Object was null)
     */
    public final BlacklistProfile getProfile(final String search) {

        return getProfile(search, ApiCheckType.values());

    }

    /**
     * Get a blacklisted profile object.
     *
     * @param search        a object do you want search. (id, username)
     * @param apiCheckTypes all check type do you want use for the checking.
     * @return a simple blacklistprofile.(if object was not blacklisted all object was null)
     * @throws IOException if connection or stream or link was not nice (Object was null)
     */
    public final BlacklistProfile getProfile(final String search, final ApiCheckType... apiCheckTypes) {

        for (final ApiCheckType apiCheckType : apiCheckTypes) {

            try {

                URL obj = new URL(apiCheckType.getLink(apiCheckType, search));

                final HttpURLConnection con;

                con = (HttpURLConnection) obj.openConnection();

                con.setRequestMethod("GET");

                con.setRequestProperty("User-Agent", "Mozilla/5.0");

                final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine;

                final StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {

                    response.append(inputLine);

                }

                in.close();

                final JSONObject jsonObject = new JSONObject(response.toString());

                if (jsonObject.getBoolean("blacklisted")) {

                    final JSONArray jsonArrayNicknameHisotry = jsonObject.getJSONArray("nickname_history"),
                            jsonArrayProofs = jsonObject.getJSONArray("proof");

                    JSONObject jsonObjectNicknameHistory,
                               jsonObjectProofs;


                    Map<String, Object> nicknameHistorty = new HashMap<>();

                    for (int i = 0; i < jsonArrayNicknameHisotry.length(); i++) {

                        jsonObjectNicknameHistory = jsonArrayNicknameHisotry.getJSONObject(i);

                        nicknameHistorty.put(jsonObjectNicknameHistory.getString("name"), jsonObjectNicknameHistory.get("changedToAt"));



                    }

                    final List<String> proofs = new ArrayList<>();

                    for (int i = 0; i < jsonArrayProofs.length(); i++) {

                        jsonObjectProofs = jsonArrayProofs.getJSONObject(i);

                        proofs.add(jsonObjectProofs.getString("proof_" + (i + 1)));

                    }

                    return new BlacklistProfile(true,
                            jsonObject.getString("blacklistmc_post"),
                            jsonObject.getString("title"),
                            jsonObject.getString("minecraft_username"),
                            nicknameHistorty,
                            jsonObject.getString("twitter_username"),
                            jsonObject.getString("discord_id"),
                            jsonObject.getString("discord_username"),
                            jsonObject.getString("description"),
                            proofs,
                            jsonObject.getString("blacklistmc_verified"),
                            jsonObject.getString("blacklisted_date"));

                }

            } catch (IOException e) {

                System.err.println("Can't get a BlackListProfile");

                e.printStackTrace();

                return null;

            }

        }

        return new BlacklistProfile(false, null, null, null, null, null, null, null, null, null, null, null);

    }

}

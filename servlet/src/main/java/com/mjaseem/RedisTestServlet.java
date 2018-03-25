package com.mjaseem;

import org.json.JSONArray;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author Jaseem
 */
public class RedisTestServlet extends HttpServlet {
    Jedis jedis;

    @Override
    public void init() throws ServletException {
        //VCAP_SERVICES contains info including credentials for bound services
        String hash= System.getenv("VCAP_SERVICES");

        //Parse VCAP_SERVICES to get the host, port and password
        JSONObject jsonObject = new JSONObject(hash);
        final JSONArray jsonArray = jsonObject.getJSONArray("redis");
        final JSONObject jsonObject1 = jsonArray.getJSONObject(0);
        final JSONObject credentials = jsonObject1.getJSONObject("credentials");

        String host = credentials.getString("hostname");
        String password = credentials.getString("password");
        int port = credentials.getInt("port");

        //Configure Jedis Object
        jedis = new Jedis(host,port);
        jedis.auth(password);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(jedis.get("input"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        jedis.set("input", requestBody);
    }
}

package cogent.infotech.com.DoConnect.jwt;

import java.io.Serializable;

public class JwtResponse {
    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}